package org.wq.ssm.web.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author wangqiang
 *
 */
@Controller
@RequestMapping("/file")
public class FileController {
	
	//上传文件
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public String upload(@RequestParam("uploadFile")MultipartFile multipartFile){
		
	 if(!multipartFile.isEmpty()){
		 File newFile = new File("e://wqwqwqqwqwq.txt");
		 try {
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
		
		return "list";
		
	}
	
	

}
