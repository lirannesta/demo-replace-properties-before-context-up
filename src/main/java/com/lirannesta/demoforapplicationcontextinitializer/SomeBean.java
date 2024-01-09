package com.lirannesta.demoforapplicationcontextinitializer;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeBean {
    @Value("${some_key}")
    private String someKey;

    @PostConstruct
    public void init() {
        System.out.println("someKey = " + someKey);
    }

}
