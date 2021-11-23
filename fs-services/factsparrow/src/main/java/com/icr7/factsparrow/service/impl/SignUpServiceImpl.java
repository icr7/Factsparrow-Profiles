package com.icr7.factsparrow.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.icr7.factsparrow.model.FsUser;
import com.icr7.factsparrow.repository.UserRepository;
import com.icr7.factsparrow.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	ResourceLoader resourceLoader;

	public final String UPLOAD_DIR = "C:\\Users\\ishwa\\Project\\Project-Factsparrow\\fs-services\\factsparrow\\target\\classes\\static\\photo";

	@Override
	public void saveNewUser(FsUser fsUser) {
		userRepository.save(fsUser);
	}

	@Override
	public void uploadDp(MultipartFile multipartFile, String email) throws IOException {

		long fsId = userRepository.findIdByEmail(email).get(0).getFs_id();
		String fsUserPicName = "fs_dp_" + fsId;
		Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR + "\\" + fsUserPicName + ".jpg"),
				StandardCopyOption.REPLACE_EXISTING);
		userRepository.SaveProfilePicByEmail(fsUserPicName, email);
		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/photo/")
				.path(fsUserPicName + ".jpg").toUriString());

	}

	@Override
	public String getFsUserDp(String email) {
		long fsId = userRepository.findIdByEmail(email).get(0).getFs_id();
		String fsUserPicName = "fs_dp_" + fsId;
		String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/photo/").path(fsUserPicName + ".jpg")
				.toUriString();
		return url;
	}

}
