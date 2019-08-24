package com.boo.exercise03.extension;

import com.boo.exercise03.extension.extension.EnvironmentExtension;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.Assert.assertEquals;

/**
 * Custom Extension.
 * Test is disabled when application property 'env'= qa
 */
@ExtendWith(EnvironmentExtension.class)
class MowerConnectivityTest {

    @Test
    void testBatteryLevel() {

        val mower = Mower.builder().name("Sileno").batteryLevelPercentage(99).build();
        int qualityInPercentage = mower.getBatteryLevelPercentage();

        assertEquals(99, qualityInPercentage);
    }
}
