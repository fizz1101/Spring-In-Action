package com.fizz.spring.part2;

import com.fizz.spring.part2.config.SoundSystemConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class CDPlayerTest {

    @Autowired()
    private CDPlayer player;

    @Qualifier("sgtPeppers")
    @Autowired
    private CompactDisc cd;

    @Autowired
    private SgtPeppers sgtPeppers;

    @Autowired
    private BlackDisc blackDisc;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
        cd.play();
    }

    @Test
    public void sgtPeppers() {
        sgtPeppers.play();
    }

    @Test
    public void blackDisc() {
        blackDisc.play();
    }

    @Test
    public void play() {
        player.play();
    }

}
