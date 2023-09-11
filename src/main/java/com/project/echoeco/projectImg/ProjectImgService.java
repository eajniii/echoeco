package com.project.echoeco.projectImg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.groovy.parser.antlr4.util.StringUtils;

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
		
		if(!StringUtils.isEmpty(oriName)) {
			name = fileService.uploadFile(path, oriName, img.getBytes());
			return url = "/images/project/"+name;
		}
		
		return null;
		
	}
}
