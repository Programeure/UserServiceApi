package com.wadson.usersevice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wadson.usersevice.domain.User;

public interface UserRepo extends JpaRepository<User,Long> {

	User findByUsername(String username);
}
