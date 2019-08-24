package com.boo.exercise01.simplestuff.junit5;

import com.boo.exercise03.extension.Mower;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class MowerTest {

    private Mower mower;

    @BeforeAll
    static void initClass() {
        log.info("MowerTest.initClass");
    }

    @BeforeEach
    void setup() {
        mower = Mower.builder().name("Sileno").build();
    }

    @Test
    @DisplayName("Full battery, mowing")
    void mowing_fullBattery_ok() {
        mower.setBatteryLevelPercentage(100);
        boolean isMowing = mower.startMowing();
        assertTrue(isMowing);
    }

    @Test
    @DisplayName("Low battery, not mowing")
    void mowing_lowBattery_nok() {
        mower.setBatteryLevelPercentage(7);
        boolean isMowing = mower.startMowing();
        assertFalse(isMowing);
    }

    @Test
    @DisplayName("Very low battery, expect exception")
    void mowing_emptyBattery() {
        mower.setBatteryLevelPercentage(0);
        assertThrows(IllegalStateException.class, () -> mower.startMowing());
    }

    @AfterEach
    void reset() {
        log.info("MowerTest.reset");
    }

    @AfterAll
    static void shutdown() {
        log.info("MowerTest.shutdown");
    }
}
