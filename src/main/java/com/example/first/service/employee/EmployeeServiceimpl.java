package com.example.first.service.employee;

import com.example.first.entity.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile("prod")
public class EmployeeServiceimpl implements EmployeeService {

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String adEmployeeNickname(String firstName, String lastName) {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public List<Employee> findByNameOrSurname(String nameOrSurname) {
        return null;
    }


}
