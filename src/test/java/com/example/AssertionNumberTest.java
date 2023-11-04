package com.example;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class AssertionNumberTest {

    @Test
    void test() {

        assertThat(5.234)
                .isCloseTo(5.1, Offset.offset(0.2))
                .isBetween(4.5, 5.5)
                .isGreaterThan(2)
                .isNotZero();

        assertThat(45.234)
                .isEqualTo(44.333, withPrecision(1d)) // 1 차이가 안나서 성공
                .isEqualTo(45.235, withPrecision(0.01)); // 0.01 차이가 안나서 성공
    }
}
