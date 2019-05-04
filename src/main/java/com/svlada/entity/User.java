package com.svlada.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="APP_USER")
public class User {
    @Id @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
    private List<UserRole2> roles2;
    
    public User() { }
    
    public User(Long id, String username, String password, List<UserRole2> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles2 = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

	public List<UserRole2> getRoles2() {
		return roles2;
	}

	public void setRoles2(List<UserRole2> roles2) {
		this.roles2 = roles2;
	}
    
}
