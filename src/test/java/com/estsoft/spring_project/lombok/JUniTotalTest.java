package com.estsoft.spring_project.lombok;

import org.junit.jupiter.api.*;

public class JUniTotalTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@AfterAll");
    }
}
