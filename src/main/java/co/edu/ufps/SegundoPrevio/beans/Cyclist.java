package co.edu.ufps.SegundoPrevio.beans;

import java.io.Serializable;

public class Cyclist implements Serializable{

private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String email;
	private String birthdate;  
	private String country;
	private String team;
	
	public Cyclist(String name, String email, String birthdate, String country, String team) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.country = country;
		this.team = team;
	}
	
	public Cyclist(int id, String name, String email, String birthdate, String country, String team) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.country = country;
		this.team = team;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
