package com.chernyshov777.spring.terminator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("Advanced terminator");
    }
}
