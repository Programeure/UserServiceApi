package com.wadson.usersevice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wadson.usersevice.domain.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {

	Role findByRolename(String name);
}
