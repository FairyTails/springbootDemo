package com.example.demo2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@ComponentScan(resourcePattern = "**/*.classt")
public class Demo2Application {

    public static void main(String[] args) throws InterruptedException {

//        SpringApplicationBuilder springApplicationBuildernew = new SpringApplicationBuilder(Demo2Application.class);
////        ConfigurableApplicationContext context = springApplicationBuildernew.run(new String[]{"--server.port=8032"});
////
////        Thread.sleep(3000L);
////
////        SpringApplicationBuilder springApplicationBuildernew2 = new SpringApplicationBuilder(KKApplication.class);
////        context.getEnvironment().getSystemProperties().put("server.port", 4322);
////        springApplicationBuildernew2.parent(context).sources(KKApplication.class);
////        springApplicationBuildernew2.run(new String[]{"--server.port=8033"});

//        ConfigurableApplicationContext context = SpringApplication.run(Demo2Application.class, args);
//
//
//        ConfigurableApplicationContext context2 = SpringApplication.run(KKApplication.class, args);

        SpringApplicationBuilder springApplicationBuildernew = new SpringApplicationBuilder(Demo2Application.class);
        ConfigurableApplicationContext context = springApplicationBuildernew.run(new String[]{"--server.port=8032"});


    }

}
