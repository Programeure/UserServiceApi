package com.wadson.usersevice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wadson.usersevice.domain.Role;
import com.wadson.usersevice.domain.User;
import com.wadson.usersevice.repo.RoleRepo;
import com.wadson.usersevice.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRepo userRepo;
	private final RoleRepo roleRepo;

	public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo) {
		super();
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not found in the Database");
		}
		java.util.Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
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

		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
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
