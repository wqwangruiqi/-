package org.wq.ssm.service.management;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wq.ssm.dao.lasw.LaswNewsTitleDao;
import org.wq.ssm.dao.management.UserInfoDao;
import org.wq.ssm.entity.lasw.LaswNewsTitle;
import org.wq.ssm.entity.management.UserInfo;

@Service
public class ManagementService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 注入Service依赖 可以使用注解 @Resource @Inject 等j2ee规范注解
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private  LaswNewsTitleDao laswNewsTitleDao;
 
	public int  userInfoInsert(UserInfo userInfo){
		return userInfoDao.insert(userInfo);
	}
	
	public int  laswNewsTitleInsert(LaswNewsTitle laswNewsTitle){
		return laswNewsTitleDao.insert(laswNewsTitle);
	}
	
	public List<UserInfo> queryAll(){
		return userInfoDao.queryAll();
	}
	
	
	/**
	 * 使用注解控制事务方法的优点: 1 开发团队打成一致的约定 明确标注事务方法的编程风格。 看见注解就知道是事务 2
	 * 保证事务方法的执行时间尽可能短,不要穿插其他的网络操作 如:RPC/HTTP请求 或者将这些类似的时间较长的方法剥离到事务方法外部 3
	 * 不是所有的方法都需要事务 如只有一条修改操作 或者只读操作 不需要事务控制
	 */
	
	public void testTeansactinal(UserInfo userInfo,LaswNewsTitle laswNewsTitle){
		userInfoDao.insert(userInfo);
		laswNewsTitleDao.insert(laswNewsTitle);
	}


}
