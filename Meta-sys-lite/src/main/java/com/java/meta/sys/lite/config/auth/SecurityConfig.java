package com.java.meta.sys.lite.config.auth;


import com.java.meta.sys.lite.common.exception.AuthAccountException;
import com.java.meta.sys.lite.config.DynamicSecurityFilter;
import com.java.meta.sys.lite.config.JwtAuthenticationTokenFilter;
import com.java.meta.sys.lite.config.RestAccessDeniedHandler;
import com.java.meta.sys.lite.config.RestAuthEntryPointConfig;
import com.java.meta.sys.lite.domain.config.SecureIgnoreUrls;
import com.java.meta.sys.lite.service.AccountAuthService;
import com.java.meta.sys.lite.service.AccountService;
import com.java.meta.sys.lite.service.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author HY
 */
@Configuration
public class SecurityConfig {

    @Autowired
    private SecureIgnoreUrls secureIgnoreUrls;

    @Autowired
    private AccountAuthService accountAuthService;


    @Autowired
    private RestAuthEntryPointConfig restAuthEntryPointConfig;


    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    @Autowired
    private DynamicSecurityFilter dynamicSecurityFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return accountNumber -> accountAuthService.getAccountDetails(accountNumber);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity.authorizeRequests();
        //不需要保护的资源路径允许访问
        for (String url : secureIgnoreUrls.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        //允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restAccessDeniedHandler)
                .authenticationEntryPoint(restAuthEntryPointConfig)
                // 自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //有动态权限配置时添加动态权限校验过滤器
        if (dynamicSecurityService != null) {
            registry.and().addFilterBefore(dynamicSecurityFilter, FilterSecurityInterceptor.class);
        }
        return httpSecurity.build();
    }
}
