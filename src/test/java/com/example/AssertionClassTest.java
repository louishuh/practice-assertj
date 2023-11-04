package com.example;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionClassTest {

    @Test
    void test() {

        assertThat(Runnable.class)
                .hasAnnotation(FunctionalInterface.class)
                .isInterface();

        assertThat(Exception.class)
                .isAssignableFrom(NoSuchElementException.class);
    }
}
