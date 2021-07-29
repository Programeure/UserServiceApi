package com.wadson.usersevice.api;

import java.net.URI;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wadson.usersevice.domain.Role;
import com.wadson.usersevice.domain.User;
import com.wadson.usersevice.service.UserService;

 

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	private  UserService userService;

	@GetMapping("/users")
	public ResponseEntity<java.util.List<User>> getUSers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	 
	@PostMapping("/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	
	@PostMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
		return ResponseEntity.created(uri).body(userService.SaveRole(role));
	}
	
	
	@PostMapping("/role/addtouser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm){
		userService.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRolename());
		return ResponseEntity.ok().build();
	}
	
	
	
}

class RoleToUserForm{
	private String username;
	private String rolename;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
}
