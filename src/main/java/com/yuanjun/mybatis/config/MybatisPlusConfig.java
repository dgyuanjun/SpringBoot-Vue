package com.yuanjun.mybatis.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatisplus配置
 */
@Configuration
@MapperScan("com.yuanjun.mybatis.mapper")
public class MybatisPlusConfig {
    /**
     * mybatis-plus 开启分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
