package com.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionFileTest {

    @Test
    void test() throws IOException {

        File f = File.createTempFile("prefix", "test");

        assertThat(f)
                .exists()
                .isFile()
                .canRead()
                .canWrite();
    }
}
