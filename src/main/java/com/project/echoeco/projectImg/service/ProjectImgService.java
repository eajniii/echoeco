package com.project.echoeco.projectImg.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.funding.Funding;
import com.project.echoeco.projectImg.entity.ActivityImg;
import com.project.echoeco.projectImg.entity.FundingImg;
import com.project.echoeco.projectImg.repository.ActivityImgRepository;
import com.project.echoeco.projectImg.repository.ProjectImgRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectImgService {

	@Value("${fundingImgLocation}")
	private String fundingPath;
	
	@Value("${activityImgLocation}")
	private String activityPath;
	
	private final FileService fileService;
	private final ProjectImgRepository projectImgRepository;
	private final ActivityImgRepository activityImgRepository;
	
	public void FundingImg(MultipartFile img, Funding funding,String YorN) throws Exception{
		
		String oriName = img.getOriginalFilename();
		String name ="";
		String url = "";
		if(!StringUtils.isEmpty(oriName)){
	           name = fileService.uploadFile(fundingPath, oriName,
	                   img.getBytes());
	           url = "/echoeco/img" + name;
	    }
		
		FundingImg projectImg = FundingImg.builder().name(name).oriName(oriName).funding(funding).imgurl(url).YorN(YorN).build();
		this.projectImgRepository.save(projectImg);
	}
	
	public void ActivityImg(MultipartFile img, Activity activity,String YorN) throws Exception{
		
		String oriName = img.getOriginalFilename();
		String name ="";
		String url = "";
		if(!StringUtils.isEmpty(oriName)){
	           name = fileService.uploadFile(activityPath, oriName,
	                   img.getBytes());
	           url = "/echoeco/img" + name;
	    }
		
		ActivityImg projectImg = ActivityImg.builder().name(name).oriName(oriName).activity(activity).imgurl(url).YorN(YorN).build();
		this.activityImgRepository.save(projectImg);
	}
}
