package com.jzl.product_service.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 项目名：v13
 * HAPPY JAVA ！
 * Create by jiangzonglin on 2019-06-12 上午 9:52
 */

@Configuration
public class CommonConfig {

    @Bean
    public PageHelper getPageHelper(){
        PageHelper pageHelper = new PageHelper();
        //设置属性
        Properties properties = new Properties();
        properties.setProperty("dialect","mysql");
        properties.setProperty("reasonable","true");
        //
        pageHelper.setProperties(properties);
        return pageHelper;
    }

}
