package com.chernyshov777.spring.soundsystem;

import com.chernyshov777.spring.colors.ColorConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(ColorConfiguration.class)
public class CDPlayerConfig {
}
