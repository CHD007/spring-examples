package com.chernyshov777.spring.soundsystem;

import com.chernyshov777.spring.aspects.AspectsConfigurations;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CDPlayerConfig.class, AspectsConfigurations.class})
public class CDPlayerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    @DarkPlayer
    private MediaPlayer cdBlackPlayer;

    @Autowired
    @GreenPlayer
    private MediaPlayer dvdGreenPlayer;

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void compactDiscShouldNotBeNull() {
        assertNotNull(compactDisc);
    }

    @Test
    public void play() {
        cdBlackPlayer.play();
        assertEquals("CDPlayer is verified\r\nPlaying Sgt. Pepper's Lonely Hearts Club Band by The Beatles",
                systemOutRule.getLog().trim());
    }

    @Test
    public void cpPlayerColorShouldBeBlack() {
        assertEquals("black", cdBlackPlayer.getColor());
    }

    @Test
    public void dvdPlayerColorShouldBeGreen() {
        assertEquals("green", dvdGreenPlayer.getColor());
    }
}
