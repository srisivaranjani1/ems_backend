package com.example.Employeespringboot.controllers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HelloTest {
    @Test
    public void tesHelloTest(){
        Hello hell=new Hello();
        String str=hell.helloTest();
        System.out.println(str);
        assertEquals("Hello Test",str);
    }
}