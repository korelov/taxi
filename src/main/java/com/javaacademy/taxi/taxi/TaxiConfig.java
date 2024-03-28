package com.javaacademy.taxi.taxi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class TaxiConfig {

    @Bean
    public Taxi taxi1() {
        return new Taxi("О777МР78");
    }

    @Bean
    public Taxi taxi2() {
        return new Taxi("В555ТУ178");
    }

    @Bean
    @Profile("luna")
    public Taxi taxi3() {
        return new Taxi("К220ЕН178");
    }
}
