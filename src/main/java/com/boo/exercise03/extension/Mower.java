package com.boo.exercise03.extension;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mower {

    private final String name;
    private int batteryLevelPercentage;

    public boolean startMowing() {
        if (batteryLevelPercentage > 10) {
            return true;
        } else if (batteryLevelPercentage > 5) {
            return false;
        } else {
            throw new IllegalStateException("Empty battery, please charge me");
        }
    }
}
