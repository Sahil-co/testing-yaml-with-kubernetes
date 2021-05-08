package com.cg.login.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "user_name")
	private String username;

	private String password;

	private String isEnabled;

	 @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id")
,inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles=new HashSet<>() ;

	public User() {

	}

	public User(Integer userId, String userName, String password, String isEnabled) {
		super();
		this.userId = userId;
		this.username = userName;
		this.password = password;
		this.isEnabled = isEnabled;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String isEnabled() {
		return isEnabled;
	}

	public void setEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
