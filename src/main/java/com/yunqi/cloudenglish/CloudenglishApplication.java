package com.yunqi.cloudenglish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = {"com.yunqi.cloudenglish.mapper", "com.yunqi.cloudenglish.generate.mapper"})
public class CloudenglishApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudenglishApplication.class, args);
    }
}
