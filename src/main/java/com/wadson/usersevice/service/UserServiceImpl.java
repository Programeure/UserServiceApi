package com.wadson.usersevice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.wadson.usersevice.domain.Role;
import com.wadson.usersevice.domain.User;
import com.wadson.usersevice.repo.RoleRepo;
import com.wadson.usersevice.repo.UserRepo;

 
 

@Service  @Transactional  
public class UserServiceImpl implements UserService{

	private final UserRepo userRepo ;
	private final RoleRepo roleRepo ; 
	 
	
	
	public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo) {
		super();
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}

	@Override
	public User saveUser(User user) {
		 
		return userRepo.save(user);
	}

	@Override
	public Role SaveRole(Role role) {
		 
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		 
		 
		 User user=userRepo.findByUsername(username);
		 Role role=roleRepo.findByRolename(roleName);
		 user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {
	 
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		 
		return userRepo.findAll();
	}

}
