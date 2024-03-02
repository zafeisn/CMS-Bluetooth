package com.example.cms.config;

import com.example.cms.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Title：MyStaticConfig
 * @Package：com.example.cms.config
 * @Description：
 * @author：done
 * @date：2021/9/25 19:36
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        registration.addPathPatterns("/","/user","/rssi");  // 对后台管理进行拦截
        registration.excludePathPatterns(
                "/login",                //登录
                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css"             //css静态资源
        );
    }

}
