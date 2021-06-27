package com.spring.service;

import com.spring.beans.Auteur;
import com.spring.beans.Role;

public interface AccountService {
	
	public Auteur saveAuteur(Auteur auteur);
	
	public Role saveRole(Role role);
	
	public void addRoleToUser(String username,String roleName);
	
	public Auteur findAuteurByUsername(String username);

}
