package com.qinkai.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.qinkai.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
