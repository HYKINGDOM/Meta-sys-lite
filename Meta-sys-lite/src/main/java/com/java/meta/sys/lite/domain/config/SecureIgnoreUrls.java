package com.java.meta.sys.lite.domain.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HY
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class SecureIgnoreUrls {

    private List<String> urls = new ArrayList<>();

}
