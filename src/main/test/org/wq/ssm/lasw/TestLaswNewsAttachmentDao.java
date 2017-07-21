package org.wq.ssm.lasw;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.dao.lasw.LaswNewsAttachmentDao;
import org.wq.ssm.entity.lasw.LaswNewsAttachment;


/**
 * 首先需要配置spring和junit整合  为了junit启动时加载spring ioc容器
 * @author wangqiang
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration(("classpath:spring/spring-dao.xml"))
public class TestLaswNewsAttachmentDao {
	//注入dao实现类依赖
	@Resource
	private LaswNewsAttachmentDao  dao;
	
	
	 
	@Test
	public void testQueryById(){
		LaswNewsAttachment  laswNewsAttachment = dao.queryById(1);
		System.out.println(laswNewsAttachment.toString());
	}
	
	@Test
	public void testQueryByContentId(){
		List<LaswNewsAttachment> list=dao.queryByContentId(2);
		System.out.println(list);
	}

	
	
	 
	  
	
	
	@Test
	public void testInsert(){
		LaswNewsAttachment attachment=new LaswNewsAttachment();
		attachment.setFileName("tttttttt.abc");
		attachment.setFilePath("/ab/ab/bbb/af/tttttttt.abc");
		attachment.setFileSize(1234657L);
		attachment.setFileType("txt");
		attachment.setLaswnewsContentid(2);
		/*int ABC = dao.insert(attachment);
		System.out.println(ABC);*/
	}
	
	
	@Test
	public void testUpdate(){
		LaswNewsAttachment attachment=new LaswNewsAttachment();
		attachment.setFileName("ttttUUUtttt.abc");
		attachment.setFilePath("/ab/ab/bbb/af/tttttttt.abc");
		attachment.setFileSize(1234657L);
		attachment.setFileType("txt");
		attachment.setLaswnewsContentid(2);
		attachment.setId(4);
		int ABC = dao.update(attachment);
		System.out.println(ABC);
	}
	
	
	@Test
	public void TestDelete(){
		int ABC = dao.delete(4);
		System.out.println(ABC);
	}
	
	
	 
	

}
