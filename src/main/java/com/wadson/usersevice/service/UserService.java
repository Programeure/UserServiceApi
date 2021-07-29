package com.wadson.usersevice.service;

import com.wadson.usersevice.domain.Role;
import com.wadson.usersevice.domain.User;

public interface UserService {

	User saveUser(User user);
	Role SaveRole(Role role);
	void addRoleToUser(String username,String roleName);
	User getUser(String username);
	java.util.List<User>getUsers();
}
