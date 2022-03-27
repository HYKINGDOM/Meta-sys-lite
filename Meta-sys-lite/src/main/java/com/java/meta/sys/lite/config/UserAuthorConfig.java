package com.java.meta.sys.lite.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author HY
 */
@Component
public class UserAuthorConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String user = "System";
        return Optional.of(user);
    }
}
