package com.imooc.mall.config;

import com.imooc.mall.filter.AdminFilter;
import com.imooc.mall.filter.UserFilter;
import com.imooc.mall.model.pojo.User;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User过滤器的配置
 */
@Configuration
public class UserFilterConfig {
    @Bean
    public UserFilter userFilter() {
        return new UserFilter();
    }
    @Bean(name = "userFilterConf")
    public FilterRegistrationBean adminFilterConfig() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(userFilter());
        filterRegistrationBean.addUrlPatterns("/cart/*");
        filterRegistrationBean.addUrlPatterns("/order/*");
        filterRegistrationBean.setName("userFilterConfig");
        return filterRegistrationBean;
    }
}
