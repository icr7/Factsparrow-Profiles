package com.icr7.factsparrow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fs_otp")
public class FsOtp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fs_otp_id")
	public int otpId;

	@Column(name="fs_user_id")
	public long userId;
	
	@Column(name="email")	
	public String email;

	@Column(name = "otp_code")
	public int otpCode;

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOtpCode() {
		return otpCode;
	}

	public void setOtpCode(int otpCode) {
		this.otpCode = otpCode;
	}

	public FsOtp(long userId2, String email, int otpCode) {
		super();
		this.userId = userId2;
		this.email = email;
		this.otpCode = otpCode;
	}
	
	public FsOtp() {}

	@Override
	public String toString() {
		return "FsOtp [otpId=" + otpId + ", userId=" + userId + ", email=" + email + ", otpCode=" + otpCode + "]";
	}

	

}
