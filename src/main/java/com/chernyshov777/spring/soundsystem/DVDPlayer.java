package com.chernyshov777.spring.soundsystem;

import com.chernyshov777.spring.colors.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DVDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;
    private Color color;

    @Autowired
    public DVDPlayer(CompactDisc compactDisc, Color color) {
        this.compactDisc = compactDisc;
        this.color = color;
    }

    @Override
    public void play() {
        System.out.println("DVDPlayer: ");
        compactDisc.play();
    }

    @Override
    public String getColor() {
        return color.color();
    }
}
