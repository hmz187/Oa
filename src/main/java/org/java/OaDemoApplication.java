package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "org.java.dao")
public class OaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OaDemoApplication.class, args);
    }

}
