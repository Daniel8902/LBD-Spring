package com.example.first.service.employee;

import com.example.first.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImpl2Test2 {
    @Autowired
    EmployeeService employeeService;




    List<Employee> employees = new ArrayList<>();

    @Test
    public void teest(){
      employeeService.save(new Employee(2,"dan","dkds",877768,435534,555434));
      employees.addAll(employeeService.findByName("dan"));
        System.out.println(employees.get(0));
    }


}