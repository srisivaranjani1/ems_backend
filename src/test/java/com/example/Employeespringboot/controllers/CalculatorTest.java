package com.example.Employeespringboot.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc=new Calculator();
        int result=calc.add(5, 3);
        System.out.println("Add: "+result);
        assertEquals(8,result);
    }
    @Test
    public void testSubtract() {
        Calculator calc=new Calculator();
        int result=calc.subtract(10,4);
        System.out.println("Subtract: " +result);
        assertEquals(6,result);
    }
    @Test
    public void testMultiply() {
        Calculator calc=new Calculator();
        int result=calc.multiply(6,7);
        System.out.println("Multiply: "+result);
        assertEquals(42, result);
    }
    @Test
    public void testDivide() {
        Calculator calc=new Calculator();
        int result=calc.divide(20,5);
        System.out.println("Divide: "+result);
        assertEquals(4,result);
    }

}