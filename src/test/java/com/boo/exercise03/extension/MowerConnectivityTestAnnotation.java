package com.boo.exercise03.extension;

import com.boo.exercise03.extension.extension.DisabledInQA;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Custom Extension Annotation.
 * Test is disabled when application property 'env'= qa
 */
@DisabledInQA
class MowerConnectivityTestAnnotation {

    @Test
    void testRadioQuality() {
        val mower = Mower.builder().name("Sileno").batteryLevelPercentage(99).build();
        int qualityInPercentage = mower.getBatteryLevelPercentage();

        assertEquals(99, qualityInPercentage);
    }
}
