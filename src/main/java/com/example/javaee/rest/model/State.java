package com.example.javaee.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "state")
public class State {

	@Id
	@GeneratedValue
	@Column(name = "state_id")
	private Integer id;
	
	@Column(name = "phone_code", nullable = false)
	private String phoneCode;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	public State() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneCode == null) ? 0 : phoneCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneCode == null) {
			if (other.phoneCode != null)
				return false;
		} else if (!phoneCode.equals(other.phoneCode))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "State [id=" + id + ", phoneCode=" + phoneCode + ", name=" + name + "]";
	}
	
}
