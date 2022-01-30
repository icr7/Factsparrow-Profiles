package com.icr7.factsparrow.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.icr7.factsparrow.model.FsUser;
import com.icr7.factsparrow.service.SignUpService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/signUp")
public class SignUpController {
	@Autowired
	private SignUpService signUpService;
	
//	public SignUpController(SignUpService signUpService) {
//		super();
//		this.signUpService=signUpService;
//	}
	
	@PostMapping("/saveNewUser")
	public void saveNewUser(@RequestBody FsUser fsUser){
		 signUpService.saveNewUser(fsUser);
	}
	
	@PostMapping("/uploadDp")
	public String uploadDp(@RequestParam("file") MultipartFile file,@RequestParam("email") String email) throws IOException{
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getName());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(email);
		return signUpService.uploadDp(file,email);
	}

	@GetMapping("/getDp/{email}")
	public String getDp(@PathVariable("email") String email) {
		return signUpService.getFsUserDp(email);
	}

}
