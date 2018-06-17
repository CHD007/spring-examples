package com.chernyshov777.spring.terminator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @Value("${quoters.terminatorQuote}")
    private String message;

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    public TerminatorQuoter() {
        System.out.println("Terminator constructor: phase 1");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("phase 2");
        System.out.println(repeat);
    }
}
