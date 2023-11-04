package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionStringTest {

    @Test
    void string() {
        String expression = "This is a string";
        assertThat(expression)
                .startsWith("This")
                .endsWith("string")
                .contains("a");

    }
}
