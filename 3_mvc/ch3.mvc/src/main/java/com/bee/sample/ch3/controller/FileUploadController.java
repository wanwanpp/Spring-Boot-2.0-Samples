package com.bee.sample.ch3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

	/**
	 * 多文件上传时使用MultipartFile[] files
	 * @param name
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/form")
	@ResponseBody
	public String handleFormUpload(@RequestParam("name") String name, 
			@RequestParam("file") MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			InputStream ins = file.getInputStream();
			
			// 处理上传内容
			return "success";
		}
		return "failure";
	}
}
