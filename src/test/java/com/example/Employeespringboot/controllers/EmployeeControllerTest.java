package com.example.Employeespringboot.controllers;

import com.example.Employeespringboot.models.RegisterDetails;
import com.example.Employeespringboot.models.UserDetailsDto;
import com.example.Employeespringboot.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute(){
        String result = employeeController.route();
        //System.out.println(result); // it store the route returnng value.
        assertEquals("Welcome to SpringBoot Security",result);
    }

    @Test
    void testGetMethod(){
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();

        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result = employeeController.getMethod();
        assertEquals(2,result.size());

    }

    @Test
    void testGetEmployeeById() {
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpId(1);
        emp.setName("Sri");

        when(employeeService.getEmployeeById(1)).thenReturn(emp);

        RegisterDetails result = employeeController.getEmployeeById(1);
        assertEquals("Sri", result.getName());
        assertEquals(1, result.getEmpId());
    }

    @Test
    void testPostMethod() {
        UserDetailsDto dto = new UserDetailsDto();
        dto.setName("Sri");

        when(employeeService.addNewEmployee(dto)).thenReturn("Employee Added Successfully");

        String result = employeeController.postMethod(dto);
        assertEquals("Employee Added Successfully", result);
    }

    @Test
    void testPutMethod() {
        when(employeeService.updateEmployee(1)).thenReturn("Employee Updated Successfully");

        String result = employeeController.putMethod(1);
        assertEquals("Employee Updated Successfully", result);
    }

    @Test
    void testDeleteMethod() {
        when(employeeService.deleteEmployeeById(1)).thenReturn("Employee Deleted Successfully");

        String result = employeeController.deleteMethod(1);
        assertEquals("Employee Deleted Successfully", result);

    }

}