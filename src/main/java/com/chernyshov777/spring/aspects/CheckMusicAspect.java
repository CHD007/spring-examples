package com.chernyshov777.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CheckMusicAspect {

    @Before("execution(* com.chernyshov777.spring.soundsystem.MediaPlayer.play(..))")
    public void verifyCDDisc() {
        System.out.println("CDPlayer is verified");
    }
}
