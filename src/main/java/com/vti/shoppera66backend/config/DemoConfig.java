package com.vti.shoppera66backend.config;

import com.vti.shoppera66backend.modal.dto.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DemoConfig {

    @Bean
    @Primary
    public DemoBean demo1(){
        DemoBean demoBean = new DemoBean();
        demoBean.setName("Demo Bean!");
        demoBean.setId(1);
        return demoBean;
    }

    @Bean
    public DemoBean demo2(){
        DemoBean demoBean = new DemoBean();
        demoBean.setName("Demo Bean 2!");
        demoBean.setId(2);
        return demoBean;
    }
}
