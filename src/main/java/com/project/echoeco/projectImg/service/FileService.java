package com.project.echoeco.projectImg.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class FileService {

	public String uploadFile(String uploadPath,String originalFileName, byte[] fileData)throws Exception{
		//랜덤으로 이름 작성
		UUID uuid = UUID.randomUUID();
		//저장될 파일의 형식 ex).png, .jpg 등등
		String extension=originalFileName.substring(originalFileName.lastIndexOf("."));
		//ex)랜덤으로 부여된 이름.png
		String savedFileName = uuid.toString()+extension;
		//ex) ubuntu/echoeco/랜덤부여이름.png 파일의 경로를 저장
		String fileUploadFullUrl = uploadPath +"/"+savedFileName;
		//파일을 바이트 단위로 쪼개서 저장할 수 있게 해주는 역할
		FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
		//바이트 단위로 쪼개진 이미지 파일을 지정된 폴더에 저장할 수 있게 끔 해준다.
		fos.write(fileData);
		fos.close();
		return savedFileName;
	}
	
	public void deleteFile(String filePath) throws Exception{
		File deleteFile = new File(filePath);
		if(deleteFile.exists()) {
			deleteFile.delete();
			log.info("파일을 삭제하였습니다.");
		}else{
			log.info("파일이 존재하지 않습니다.");
		}
	}
}
