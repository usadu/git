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
		//1.��ȡ����ͨԪ��
		System.out.println("��ͨ��Ԫ���ļ�˵��:"+fileRemark);
		
		//2.��ȡ�ϴ����ļ���
		String filename=myfile.getOriginalFilename();
		
		//3.�ϴ�Ŀ¼
		File file=new File("E:\\upload\\"+filename);
		//4.�ƶ� ���ļ��ƶ���ָ����path��
		myfile.transferTo(file);
		
		return "success";
	}
}
