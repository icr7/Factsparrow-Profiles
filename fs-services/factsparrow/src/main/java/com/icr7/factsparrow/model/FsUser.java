package com.icr7.factsparrow.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="fs_user",uniqueConstraints = @UniqueConstraint(columnNames = {"first_name","fk_address_id"}))
public class FsUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fs_id;
	

	@Column(name="email", nullable=false,length=30, unique=true)
	private String email;
	
	@Column(name="password", nullable=false )
	private String password;
	
	@Column(name="first_name",length=30)
    private String firstName;
	
	@Column(name="last_name")
    private String lastName;
	
	@Column(name="mobile_no")
    private String mobileNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_address_id", referencedColumnName="address_id")
    private UserAddress address;
    
	@Column(name="profile_pic")
	private String profilePic;

	public long getFs_id() {
		return fs_id;
	}

	public void setFs_id(long fs_id) {
		this.fs_id = fs_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "FsUser [user_id=" + fs_id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", address=" + address + ", profilePic=" + profilePic
				+ "]";
	}
	
	
}
