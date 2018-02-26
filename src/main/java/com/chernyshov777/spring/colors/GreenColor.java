package com.chernyshov777.spring.colors;

import org.springframework.stereotype.Component;

@Component
public class GreenColor implements Color {
    @Override
    public String color() {
        return "green";
    }
}
