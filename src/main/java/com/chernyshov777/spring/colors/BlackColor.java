package com.chernyshov777.spring.colors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BlackColor implements Color {

    @Override
    public String color() {
        return "black";
    }
}
