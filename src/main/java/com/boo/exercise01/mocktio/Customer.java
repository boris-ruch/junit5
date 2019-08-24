package com.boo.exercise01.mocktio;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Customer {
    private final String name;
    private final String phone;
}
