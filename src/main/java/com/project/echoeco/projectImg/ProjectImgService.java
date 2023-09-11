package com.project.echoeco.projectImg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectImgService {

	@Value("${projectImgLocation}")
	private String path;
	
	private final FileService fileService;
	
	public String projectImg(MultipartFile img) throws Exception{
		
		String oriName = img.getOriginalFilename();
		String name ="";
		String url = "";
		
		return null;
		
	}
}
