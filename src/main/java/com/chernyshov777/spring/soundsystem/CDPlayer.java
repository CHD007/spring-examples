package com.chernyshov777.spring.soundsystem;

import com.chernyshov777.spring.colors.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;
    private Color color;

    @Autowired
    public CDPlayer(CompactDisc cd, Color color) {
        this.cd = cd;
        this.color = color;
    }

    @Override
    public void play() {
        cd.play();
    }

    @Override
    public String getColor() {
        return color.color();
    }
}
