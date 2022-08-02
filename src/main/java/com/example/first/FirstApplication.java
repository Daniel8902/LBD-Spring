package com.example.first;

import com.example.first.service.employee.EmployeeService;
import com.example.first.service.employee.EmployeeServiceImpl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FirstApplication {

	private EmployeeService employeeService;



	public FirstApplication(EmployeeService employeeService) {
		this.employeeService = employeeService;

	}
	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}
	@PostConstruct
	public void performOperations(){
		employeeService.findAll();
		employeeService.adEmployeeNickname("januszz", "kowladaa");

	}
}
