package com.mohamed265.weatherchecker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author mohamed265
 *
 */
@Entity
@Table(name = "user")
@NamedQueries({ @NamedQuery(name = "User.getAll", query = "SELECT e FROM User e"),
		@NamedQuery(name = "User.getUserById", query = "SELECT e FROM User e WHERE e.id = :ID"),
		@NamedQuery(name = "User.deleteUser", query = "DELETE FROM User e WHERE e.id = :ID"),
		@NamedQuery(name = "User.loginEmail", query = "SELECT e FROM User e WHERE e.email = :EMAIL and e.password = :PASSWORD"),
		@NamedQuery(name = "User.selectUserByEmail", query = "SELECT e FROM User e WHERE e.email = :EMAIL")})
public class User {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "isAdmin")
	private Boolean isAdmin;

	public User() {
	}

	public User(int id, String name, String password, String email, Boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", isAdmin="
				+ isAdmin + "]";
	}

}
