package com.icr7.factsparrow.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.icr7.factsparrow.model.FsUser;
import com.icr7.factsparrow.repository.UserRepository;
import com.icr7.factsparrow.service.SignUpService;
import com.amazonaws.services.s3.model.ObjectMetadata;


@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	private AmazonS3Client awsS3Client;

	String classpath = System.getProperty("java.class.path");
	String[] classpathEntries = classpath.split(File.pathSeparator);

	//public final String UPLOAD_DIR = "src/main/resources/photos";

	@Override
	public void saveNewUser(FsUser fsUser) {
		userRepository.save(fsUser);
	}

	@Override
	public String uploadDp(MultipartFile multipartFile, String email) throws IOException {

		long fsId = userRepository.findIdByEmail(email).get(0).getFs_id();
		String fsUserPicName = "fs_dp_" + fsId;
		String key=fsUserPicName+ ".jpg";

		ObjectMetadata metaData = new ObjectMetadata();
		metaData.setContentLength(multipartFile.getSize());
		metaData.setContentType(multipartFile.getContentType());

//		Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR + "\\" + fsUserPicName + ".jpg"),
//				StandardCopyOption.REPLACE_EXISTING);
		userRepository.SaveProfilePicByEmail(fsUserPicName, email);
//		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/photo/")
//				.path(fsUserPicName + ".jpg").toUriString());

		try {
			awsS3Client.putObject("fsphotobucket", key, multipartFile.getInputStream(), metaData);
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occured while uploading the file");
		}

		awsS3Client.setObjectAcl("fsphotobucket", key, CannedAccessControlList.PublicRead);

		return awsS3Client.getResourceUrl("fsphotobucket", key);

	}

	@Override
	public String getFsUserDp(String email) {
		long fsId = userRepository.findIdByEmail(email).get(0).getFs_id();
		String key = "fs_dp_" + fsId+".jpg";
//		String absolutePath=null;
//		try {
//
//			File file = new File("resources/photos/"+fsUserPicName);
//			 absolutePath = file.getAbsolutePath();
//			;
//			System.out.println("Absolute  path: "
//					+ absolutePath);
//		}
//		catch (Exception e) {
//			System.err.println(e.getMessage());
//		}

		return awsS3Client.getResourceUrl("fsphotobucket", key);
	}

}
