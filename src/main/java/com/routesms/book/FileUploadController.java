package com.routesms.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	//handler method
	@PostMapping("/upload-file")
	public ResponseEntity<String>  uploadFileHandler(@RequestParam("file") MultipartFile file) {
		
		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		
		
		try {
		
		//validation of request if request does not contains file then will response as below
		if(file.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
		
		if(!file.getContentType().equals("image/jpeg")) {
			
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG content allow file");
		}
		
		boolean isUpload = fileUploadHelper.uploadFile(file);
		
		if(isUpload) {
			
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
					.path(file.getOriginalFilename()).toUriString());
		}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong please try again later");
	}

}
