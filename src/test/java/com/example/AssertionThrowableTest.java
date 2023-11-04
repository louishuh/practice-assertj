package com.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class AssertionThrowableTest {

    @Test
    void test() {
        Throwable thrown = catchThrowable(() -> {
            throw new RuntimeException("error");
        });

        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("error");


        assertThatThrownBy(() -> {
            throw new RuntimeException("gg");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage("gg");


        // 지원 메소드
        // assertThatNullPointerException
        // assertThatIllegalArgumentException
        // assertThatIllegalStateException
        // assertThatIOException
        assertThatIOException().isThrownBy(() -> {
                    throw new IOException("boom!");
                })
                .withMessage("%s!", "boom")
                .withMessageContaining("boom")
                .withNoCause();

        assertThatExceptionOfType(IOException.class)
                .isThrownBy(() -> {
                    throw new IOException("no");
                })
                .withMessage("no");

        assertThatCode(() -> {
            // no error here
        }).doesNotThrowAnyException();
    }
}
