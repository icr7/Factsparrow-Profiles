package com.icr7.factsparrow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icr7.factsparrow.model.FsOtp;
import com.icr7.factsparrow.model.FsUser;
import com.icr7.factsparrow.repository.OtpRepository;
import com.icr7.factsparrow.repository.UserRepository;
import com.icr7.factsparrow.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public OtpRepository otpRepository;

	@Override
	public FsUser getUserDetailByLogin(String email, String password) {
		FsUser tempFsUser = userRepository.findIdByEmail(email).get(0);

		if (tempFsUser.getPassword().equals(password)) {
			return tempFsUser;
		} else
			return null;
	}

	@Override
	public void genrateOTP(String email) {
		if (otpRepository.findByEmail(email).size() == 0) {
			int randomCode = (int) (Math.random() * (10000));
			long userId = userRepository.findIdByEmail(email).get(0).getFs_id();

			otpRepository.save(new FsOtp(userId, email, randomCode));
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			otpRepository.deleteByEmail(email);
			;
		} else {
			System.out.println("wait");
		}

	}

	@Override
	public String getOtp(String email) {
		Integer otp;
		try {
			otp = otpRepository.findByEmail(email).get(0).getOtpCode();
			return otp.toString();
		} catch (IndexOutOfBoundsException e) {
			return "Time Out";
		}

	}

	@Override
	public FsUser loginByOtp(String email, String otp) {
		if (getOtp(email).equals(otp)) {
			return userRepository.findIdByEmail(email).get(0);
		} else
			return null;
	}

}
