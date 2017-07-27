package org.wq.ssm.dao.management;

import java.util.List;

import org.wq.ssm.annotation.DataSourceAnnotatin;
import org.wq.ssm.entity.management.UserInfo;

@DataSourceAnnotatin(dataSource="slave")
public interface UserInfoDao{
	List<UserInfo> queryAll();
	int insert(UserInfo userInfo);
}
