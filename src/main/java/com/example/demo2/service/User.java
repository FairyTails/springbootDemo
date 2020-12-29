package com.example.demo2.service;

import com.example.demo2.Demo2Application;
import org.springframework.beans.BeansException;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author chenSongBin
 * @date 2020/12/9
 */
@Service
public class User implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        System.out.println("----User----init()");
    }

    public void reflush() {
        System.out.println("----User----start---reflush");

        // 启动第二个Spring容器，指定端口为8848
        SpringApplicationBuilder springApplicationBuildernew2 = new SpringApplicationBuilder(Demo2Application.class);
        ConfigurableApplicationContext context2 = springApplicationBuildernew2.run(new String[]{"--server.port=8033", "--spring.application.admin.jmx-name=org.springframework.boot:type=Admin2,name=SpringApplication2"});


        System.out.println("----User----start---end");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
