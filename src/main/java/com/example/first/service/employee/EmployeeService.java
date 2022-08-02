package com.example.first.service.employee;

import com.example.first.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List findAll();
    public String adEmployeeNickname(String  firstName,  String lastName);

    public void save(Employee employee);
    public List<Employee>  findByNameOrSurname(String nameOrSurname);
}
