package com.yacoding.serviceDriverUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author yaCoding
 * @create 2022-11-22 下午 10:51
 */

@SpringBootApplication
@MapperScan("com.yacoding.serviceDriverUser.mapper")
public class ServiceDriverUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDriverUserApplication.class);
    }

}
