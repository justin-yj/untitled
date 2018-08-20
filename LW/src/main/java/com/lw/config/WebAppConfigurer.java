package com.lw.config;

import com.lw.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author sunping
 * @create 2017/8/29
 */
@Configuration
@EnableRedisHttpSession
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }

    @Bean
    public HandlerInterceptor getMyInterceptor(){
        return new BaseInterceptor();
    }
}
