package com.chernyshov777.spring.terminator;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:messages.properties")
public class PropertiesConfiguration {
}
