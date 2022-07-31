package com.springApp.springApp;

import com.springApp.springApp.Dto.Dtoo;
import com.springApp.springApp.service.SprintService;
import com.springApp.springApp.service.SprintServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);

		SprintServiceImpl tet = new SprintServiceImpl();



	}





}
