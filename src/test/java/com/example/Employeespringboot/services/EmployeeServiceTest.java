package com.example.Employeespringboot.services;


import com.example.Employeespringboot.models.RegisterDetails;
import com.example.Employeespringboot.models.Roles;
import com.example.Employeespringboot.models.UserDetailsDto;
import com.example.Employeespringboot.repository.RegisterDetailsRepository;
import com.example.Employeespringboot.repository.RolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {
    @Mock
    RegisterDetailsRepository registerDetailsRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    RolesRepository rolesRepository;

    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMethod(){
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result = employeeService.getMethod();
        assertEquals(2,result.size());

    }
    @Test
    void testGetEmployeeById() {
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpId(1);
        emp.setName("Sri");

        when(registerDetailsRepository.findById(1)).thenReturn(Optional.of(emp));

        RegisterDetails result = employeeService.getEmployeeById(1);
        assertEquals(1, result.getEmpId());
        assertEquals("Sri", result.getName());
    }
    @Test
    void testUpdateEmployee() {
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpId(2);

        when(registerDetailsRepository.findById(2)).thenReturn(Optional.of(emp));
        when(registerDetailsRepository.save(emp)).thenReturn(emp);

        String result = employeeService.updateEmployee(2);
        assertEquals("Employee Updated Successfully", result);
    }

    @Test
    void testDeleteEmployeeById() {
        doNothing().when(registerDetailsRepository).deleteById(4);

        String result = employeeService.deleteEmployeeById(4);
        assertEquals("Employee Deleted Successfully", result);
    }

    @Test
    void testAddNewEmployee() {
        UserDetailsDto dto = new UserDetailsDto();
        dto.setEmpId(10);
        dto.setName("Sri");
        dto.setEmail("sri@example.com");
        dto.setUserName("sri123");
        dto.setPassword("plainpass");
        dto.setRoleName(Set.of("ROLE_USER"));

        Roles role = new Roles();
        role.setRoleName("ROLE_USER");

        when(passwordEncoder.encode("plainpass")).thenReturn("hashedpass");
        when(rolesRepository.findByRoleName("ROLE_USER")).thenReturn(Optional.of(role));
        when(registerDetailsRepository.save(any())).thenReturn(new RegisterDetails());

        String result = employeeService.addNewEmployee(dto);
        assertEquals("Employee Added Successfully", result);
        System.out.println("**************TESTCASES IMPLEMENTED FOR ALL THE METHODS****************");
    }


}