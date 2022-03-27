package com.java.meta.sys.lite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author HY
 */
@EnableJpaAuditing
@MapperScan("com.java.meta.sys.lite.infrastructure.repository.db.dao")
@SpringBootApplication
public class MetaSysLiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaSysLiteApplication.class, args);
        System.out.println("=============Meta system already start============");
    }

}

