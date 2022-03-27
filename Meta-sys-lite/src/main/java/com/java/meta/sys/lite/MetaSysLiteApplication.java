package com.java.meta.sys.lite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HY
 */
@MapperScan("com.java.meta.sys.lite.dao")
@SpringBootApplication
public class MetaSysLiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaSysLiteApplication.class, args);
        System.out.println("=============Meta system already start============");
    }

}

