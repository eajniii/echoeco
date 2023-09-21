package com.project.echoeco.projectImg;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectImgService {

  // @Value("${fundingImgLocation}")
  // private String fundingPath;
  //
  // @Value("${activityImgLocation}")
  // private String activityPath;
  //
  // private final FileService fileService;
  // private final ProjectImgRepository projectImgRepository;
  //
  // public void FundingImg(MultipartFile img, Funding funding,String YorN) throws
  // Exception{
  //
  // String oriName = img.getOriginalFilename();
  // String name ="";
  // String url = "";
  // if(!StringUtils.isEmpty(oriName)){
  // name = fileService.uploadFile(fundingPath, oriName,
  // img.getBytes());
  // url = "/echoeco/img" + name;
  // }
  //
  // ProjectImg projectImg =
  // ProjectImg.builder().funding(funding).imgurl(url).YorN(YorN).build();
  // this.projectImgRepository.save(projectImg);
  // }
}
