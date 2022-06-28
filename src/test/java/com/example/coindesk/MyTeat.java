package com.example.coindesk;

import org.junit.jupiter.api.*;

public class MyTeat {

    @BeforeEach //(常用)執行每個@Test前會先走一次
    public void beforeEach(){
        System.out.println("執行beforeEach");
    }

    @AfterEach //(常用)執行每個@Test後會再走一次
    public void afterEach(){
        System.out.println("執行afterEach");
    }

    @BeforeAll //(很少用)在執行第一個@Test前會走一次，且需宣告為static
    public static void beforeAll(){
        System.out.println();
    }

    @AfterAll //(很少用)在執行最後一個@Test後會走一次，且需宣告為static
    public static void AfterAll(){
        System.out.println();
    }

    @Test
    public void test1(){
        System.out.println("執行1");
    }

    @DisplayName("測試執行2") //自定義測試名稱
     @Test
    public void test2(){
        System.out.println("執行2");
    }

    @Disabled // 此測試會被略過
    @Test
    public void test3(){
        System.out.println("執行3");
    }
}
