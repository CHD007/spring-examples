package com.chernyshov777.spring.terminator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertiesConfiguration.class, QuotersConfig.class);
        Quoter bean = context.getBean(Quoter.class);
        while (true) {
            Thread.sleep(100);
            bean.sayQuote();
        }
    }
}
