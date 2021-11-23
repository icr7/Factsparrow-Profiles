package com.icr7.factsparrow.service;

import com.icr7.factsparrow.model.FsUser;

public interface LoginService {
   
	public FsUser getUserDetailByLogin(String email, String password);
	
	public void genrateOTP(String email);
	public String getOtp(String email);
	public FsUser loginByOtp(String email,String otp);

}
