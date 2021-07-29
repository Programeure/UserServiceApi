package com.wadson.usersevice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wadson.usersevice.domain.Role;
import com.wadson.usersevice.domain.User;
import com.wadson.usersevice.service.UserService;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner  run(UserService userservice) {
	 return args ->{
		 userservice.SaveRole(new Role(null,"ROLE_USER"));
		 userservice.SaveRole(new Role(null,"ROLE_MANAGER"));
		 userservice.SaveRole(new Role(null,"ROLE_ADMIN"));
		 userservice.SaveRole(new Role(null,"ROLE_SUPER_ADMIN"));
		 
		 userservice.saveUser(new User(null, "Wadson Dutervil", "wadson", "1234", new ArrayList<>()));
		 userservice.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
		 userservice.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
		 userservice.saveUser(new User(null, "John Doe", "jhon", "1234", new ArrayList<>()));
		 
//		 userservice.addRoleToUser("wadson", "ROLE_USER");
//		 userservice.addRoleToUser("wadson", "ROLE_ADMIN");
//		 userservice.addRoleToUser("wadson", "ROLE_SUPER_ADMIN");
//		 userservice.addRoleToUser("jim", "ROLE_MANAGER");
//		 userservice.addRoleToUser("will", "ROLE_USER");
		 
		 
		 
	 };
	}

}
