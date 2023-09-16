package com.project.echoeco.config.Auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String pictureUrl;
	
	private String roles;
	
	public Account(String firstName,String lastName, String email,String pictureUrl) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pictureUrl = pictureUrl;
	}
}
