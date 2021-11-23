package com.icr7.factsparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icr7.factsparrow.model.FsUser;
import com.icr7.factsparrow.service.impl.LoginServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginInController {
	@Autowired
	LoginServiceImpl loginServiceImpl;

	@GetMapping("/getUserDetails/{email}/{password}")
	public FsUser getUserDetailsByLogin(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		return loginServiceImpl.getUserDetailByLogin(email, password);
	}

	@GetMapping("/GenerateOtp/{email}")
	public void genrateOtp(@PathVariable("email") String email) {
		loginServiceImpl.genrateOTP(email);
	}

	@GetMapping("/getOtp/{email}")
	public String getOtp(@PathVariable("email") String email) {
		return loginServiceImpl.getOtp(email);
	}

	@GetMapping("/loginByOtp/{email}/{otp}")
	public FsUser loginByOtp(@PathVariable("email") String email, @PathVariable("otp") String otp) {
		return loginServiceImpl.loginByOtp(email, otp);
	}
}
