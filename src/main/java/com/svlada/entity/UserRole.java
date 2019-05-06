package com.svlada.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "USER_ROLE" database table.
 * 
 */
@Entity
@Table(name="USER_ROLE")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="\"ID\"")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_generator")
	@SequenceGenerator(name="user_role_generator", sequenceName = "user_role_sequence")
	private Integer id;

	@Column(name="\"ROLE_ID\"")
	private Integer roleId;

	@Column(name="\"USER_ID\"")
	private Integer userId;

	//bi-directional many-to-one association to Role
//	@ManyToOne
//	@JoinColumn(name = "ROLE_ID", insertable=false, updatable=false)
//	private Role role;
//
//	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name = "USER_ID", insertable=false, updatable=false)
//	private User user;

	public UserRole() {
	}
	public UserRole(Integer id, Integer roleId, Integer userId) {
		this.id = id;
		this.roleId = roleId;
		this.userId = userId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

//	public Role getRole() {
//		return this.role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	public User getUser() {
//		return this.user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

}