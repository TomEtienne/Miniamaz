package com.example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="user")	
public class User implements UserDetails
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	private Long id;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="authorities")
	@OneToMany(fetch=FetchType.EAGER)
	private Collection<UserAuthorities> authorities;

	public User() {
		this.authorities = new ArrayList<>();
	}
	
	public User(String lastname, String firstname, String email, String password, Collection<UserAuthorities> authorities) {
		this.id = (long) 1;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public Long getUserId() {
		return id;
	}

	public void setUserId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = (Collection<UserAuthorities>) authorities;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + id +
				", lastname='" + lastname + '\'' +
				", firstname='" + firstname + '\'' +
				", email='" + email + '\'' +
				", password='" + password +
				'}';
	}
}
