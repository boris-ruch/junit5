package com.boo.exercise01.simplestuff.junit4;

import com.boo.exercise03.extension.Mower;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
public class MowerTest {

    private Mower mower;

    @BeforeClass
    public static void initClass() {
        log.info("MowerTest.initClass");
    }

    @Before
    public void setup() {
        mower = Mower.builder().name("Sileno").build();
    }

    @Test
    public void mowing_fullBattery_ok() {
        mower.setBatteryLevelPercentage(100);
        boolean isMowing = mower.startMowing();
        assertTrue(isMowing);
    }

    @Test
    public void mowing_lowBattery_nok() {
        mower.setBatteryLevelPercentage(7);
        boolean isMowing = mower.startMowing();
        assertFalse(isMowing);
    }

    @Test(expected = IllegalStateException.class)
    public void mowing_emptyBattery() {
        mower.setBatteryLevelPercentage(0);
        mower.startMowing();
    }

    @After
    public void reset() {
        log.info("MowerTest.reset");
    }

    @AfterClass
    public static void shutdown() {
        log.info("MowerTest.shutdown");
    }
}
