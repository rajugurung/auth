package com.svlada.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the "USER" database table.
 * 
 */
@Entity
@Table(name="USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name="user_id_generator", sequenceName = "user_sequence")
	private Integer id;

	@Column(name="\"PASSWORD\"")
	private String password;

	@Column(name="\"USER_NAME\"")
	private String userName;

	@ManyToMany
	@JoinTable(name="user_role"
			, joinColumns={@JoinColumn(name="user_id")}
			, inverseJoinColumns={@JoinColumn(name="role_id")}
			)
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String password, String userName) {
		this.password = password;
		this.userName = userName;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }
 
    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }
 
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + "]";
	}
	
}