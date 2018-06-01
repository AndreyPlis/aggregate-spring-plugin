package com.andreyplis.springplugin;


import org.springframework.context.annotation.*;

@Configuration
public class SpringConfiguration {
    @Bean
    public Greet helloWorld() {
        return new Greet();
    }
}