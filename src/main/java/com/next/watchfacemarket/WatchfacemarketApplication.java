package com.next.watchfacemarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.next.watchfacemarket")
@MapperScan(basePackages = "com.next.watchfacemarket.dao")
public class WatchfacemarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WatchfacemarketApplication.class, args);
    }

}
