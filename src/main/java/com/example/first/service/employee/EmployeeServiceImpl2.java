package com.example.first.service.employee;

import com.example.first.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

@Profile("dev")
public class EmployeeServiceImpl2 implements EmployeeService {

    private static final Logger LOG=  LoggerFactory.getLogger(EmployeeServiceImpl2.class) ;
    public Map<Long, Employee> simpleMap= new HashMap<>();
    @Value("${my.before}")
    String prefix;
    @Value("${my.after}")
    String suffix;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String adEmployeeNickname(String firstName, String lastName) {
        LOG.info(firstName+" "+lastName);

        String result = prefix +" "+ firstName.substring(0, 3) +" " +lastName.substring(0, 3) +" "+ suffix;
        LOG.info(result);
        return result;
    }

    @Override
    public void save(Employee employee) {
        if (employee == null) return;
        simpleMap.put((long) simpleMap.size(), employee);
    }

    @Override
    public List<Employee> findByNameOrSurname(String nameOrSurname) {
        List<Employee> employees = new ArrayList<>();
        for(Employee client:simpleMap.values()){
            if(client.toString().contains(nameOrSurname)){
                employees.add(client);
            }
        }
        return employees;


    }



}