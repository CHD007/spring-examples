package com.chernyshov777.spring.aspects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectsConfigurations {
    @Bean
    public CheckMusicAspect checkMusicAspect() {
        return new CheckMusicAspect();
    }
}
