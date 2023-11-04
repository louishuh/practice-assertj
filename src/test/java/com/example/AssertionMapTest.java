package com.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class AssertionMapTest {

    @Test
    void test() {

        Map<String, Long> map = new HashMap<>();
        map.put("a", 5L);
        map.put("b", 8L);

        assertThat(map)
                .isNotEmpty()
                .containsKey("b")
                .doesNotContainKey("c")
                .contains(entry("b", 8L))
                .containsKeys("b", "a")
                .containsValues(8L, 5L);
    }
}
