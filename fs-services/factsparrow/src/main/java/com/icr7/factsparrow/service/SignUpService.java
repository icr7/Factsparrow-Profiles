package com.icr7.factsparrow.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.icr7.factsparrow.model.FsUser;

public interface SignUpService { 

	public void saveNewUser(FsUser fsUser);
	public String uploadDp(MultipartFile file, String email) throws IOException;
	public String getFsUserDp(String email);
}
