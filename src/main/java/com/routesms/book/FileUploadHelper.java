package com.routesms.book;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String uploadDirectory=new ClassPathResource("static/images/").getFile().getAbsolutePath();
    
	public FileUploadHelper() throws IOException{
		
	}
	
	
	public boolean uploadFile(MultipartFile multipartFile) {
    	
    	boolean f=false;
    	
    	try {
    		
//    		InputStream is=multipartFile.getInputStream();
//    		byte[] data=is.readAllBytes();
//    		
//    		FileOutputStream fos=new FileOutputStream(uploadDirectory+multipartFile.getOriginalFilename());
//    		fos.write(data);
//    		fos.flush();
//    		fos.close();
    		
    		//alternative of above code java new api
    		
    		Files.copy(multipartFile.getInputStream(),Paths.get(uploadDirectory+File.separator
    				+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
    		
    		f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return f;
    }
}
