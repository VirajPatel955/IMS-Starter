package com.qa.ims.persistence.domain;

public class Customer {

	private Long id;
	private String firstName;
	private String surname;
	private String address;
	private String post_code;
	private String email;
	

	public Customer(String firstName, String surname, String address, String post_code, String email) {
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setAddress(address);
		this.setPost_code(post_code);
		this.setEmail(email);
		
		
	}

	public Customer(Long id, String firstName, String surname, String address, String post_code, String email) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setAddress(address);
		this.setPost_code(post_code);
		this.setEmail(email);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "id:" + id + " first name:" + firstName + " surname:" + surname + "address:" + address + "Post Code:" + post_code + "Email" + email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((post_code == null) ? 0 : post_code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode()); 
		
		
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
		Customer other = (Customer) obj;
		if (getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		} else if (!getFirstName().equals(other.getFirstName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;		
		} else if (!address.equals(other.address))
			return false;
		if (post_code == null) {
			if (other.post_code != null )
		         return false;
		} else if (!post_code.equals(other.post_code))
			return false;
		if (email == null) {
			if (other.email != null )
		         return false;
		} else if (!email.equals(other.email))
			return false;
		
		return true;
	}

	

	

}
