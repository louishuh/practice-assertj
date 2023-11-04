package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionObjectTest {

    @Test
    void test() {

        Person p1 = new Person(28, "park");
        Person p2 = new Person(28, "park");

        assertThat(p1)
                .isNotEqualTo(p2)
                .usingRecursiveComparison()
                .isEqualTo(p2);

        assertThat(p1)
                .usingRecursiveComparison()
                .comparingOnlyFields("age")
                .isEqualTo(p2);

        assertThat(p1)
                .usingRecursiveComparison()
                .ignoringFields("name")
                .isEqualTo(p2);


    }
}
