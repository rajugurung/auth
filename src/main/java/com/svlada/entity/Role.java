package com.svlada.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name="\"ROLE\"")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"ID\"")
	private Integer id;

	@Column(name="\"DESCRIPTION\"")
	private String description;

	@Column(name="\"NAME\"")
	private String name;

	//bi-directional many-to-one association to UserRole
//	@OneToMany(mappedBy="role")
//	private List<UserRole> userRoles;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<>();

	public Role() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

//	public List<UserRole> getUserRoles() {
//		return this.userRoles;
//	}
//
//	public void setUserRoles(List<UserRole> userRoles) {
//		this.userRoles = userRoles;
//	}

//	public UserRole addUserRole(UserRole userRole) {
//		getUserRoles().add(userRole);
//		userRole.setRole(this);
//
//		return userRole;
//	}
//
//	public UserRole removeUserRole(UserRole userRole) {
//		getUserRoles().remove(userRole);
//		userRole.setRole(null);
//
//		return userRole;
//	}
	

}