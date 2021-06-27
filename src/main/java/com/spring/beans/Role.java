package com.spring.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Role {

	@Id @GeneratedValue
    private Long idRole;
    private String nomRole;
	public Role(Long idRole, String nomRole) {
		super();
		this.idRole = idRole;
		this.nomRole = nomRole;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
    
    
}
