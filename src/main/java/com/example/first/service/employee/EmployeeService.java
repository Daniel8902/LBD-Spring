package com.example.first.service.employee;

import com.example.first.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List findAll();
    public String etEmployeeNickname(String  firstName,  String lastName);

    public void save(Employee employee);
    public List<Employee>  findByName(String nameOrSurname);
}
