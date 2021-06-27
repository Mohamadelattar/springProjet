package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.beans.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findRoleByNomRole(String roleName);

}
