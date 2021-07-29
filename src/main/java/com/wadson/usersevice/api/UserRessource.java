package com.wadson.usersevice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wadson.usersevice.domain.User;
import com.wadson.usersevice.service.UserService;

 

@RestController
@RequestMapping("/api")
public class UserRessource {
	
	@Autowired
	private  UserService userService;

	@GetMapping("/users")
	public ResponseEntity<java.util.List<User>> getUSers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	 

}
