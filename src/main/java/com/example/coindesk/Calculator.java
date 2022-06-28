package com.example.coindesk;

public class Calculator {

    public int add(int a,int b){
        return a + b;
    }

    public int minus(int a,int b){
        return a - b;
    }

    public int multiple(int a,int b){
        return a * b;
    }

    public int divide(int a,int b){
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calculatorTest = new Calculator();
    }
}
