package com.kbstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class Web01Application {

    public static void main(String[] args) {
        SpringApplication.run(Web01Application.class, args);

    }
    //JSP setting

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/"); //이 폴더에서 index라는 파일을 찾고
        resolver.setSuffix(".jsp"); // .jsp 라는 확장자를 붙여서 찾아라
        return resolver;
    }
}
