package com.estsoft.spring_project.lombok;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertTest {
    @Test
    public void testAssert() {
        int a = 1;
        int b = 2;
        int result = a + b;

        Assertions.assertThat(result).isEqualTo(a+b);
    }

}
