package com.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.Auteur;
import com.spring.beans.Role;
import com.spring.dao.AuteurRepository;
import com.spring.dao.RoleRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
		
	@Autowired
	private AuteurRepository auteurRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Auteur saveAuteur(Auteur auteur) {
		auteur.setPassword(auteur.getPassword());
		return auteurRepository.save(auteur);	
	}
	
	@Override
	public Role saveRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Role role=roleRepository.findRoleByNomRole(roleName);
		Auteur auteur =auteurRepository.findAuteurByUsername(username);
		auteurRepository.save(auteur);
	}

	@Override
	public Auteur findAuteurByUsername(String username) {
		// TODO Auto-generated method stub
		return auteurRepository.findAuteurByUsername(username);
	}

}
