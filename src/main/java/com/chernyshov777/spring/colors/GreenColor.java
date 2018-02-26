package com.chernyshov777.spring.colors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("green")
public class GreenColor implements Color {
    
    @Override
    public String color() {
        return "green";
    }
}
