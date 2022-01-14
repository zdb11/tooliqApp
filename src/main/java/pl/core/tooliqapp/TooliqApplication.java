package pl.core.tooliqapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication


public class TooliqApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TooliqApplication.class, args);
    }

}
