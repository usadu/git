package com.etc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {
	@RequestMapping("/uploadFile")
    public String upload(@RequestParam("fileRemark")String fileRemark,@RequestParam("myfile")MultipartFile myfile) throws IllegalStateException, IOException {
		//1.获取表单普通元素
		System.out.println("普通表单元素文件说明:"+fileRemark);
		
		//2.获取上传的文件名
		String filename=myfile.getOriginalFilename();
		
		//3.上传目录
		File file=new File("E:\\upload\\"+filename);
		//4.移动 将文件移动到指定的path下
		myfile.transferTo(file);
		
		return "success";
	}
}
