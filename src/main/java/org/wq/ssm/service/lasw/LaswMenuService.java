package org.wq.ssm.service.lasw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wq.ssm.annotation.DataSourceAnnotatin;
import org.wq.ssm.dao.lasw.LaswMenuDao;
import org.wq.ssm.dto.lasw.MenuTreeUtil;
import org.wq.ssm.entity.lasw.LaswMenu;

//@Component  代表所有的组建  当不知道是哪个组建的时候 可以使用该注解
@Service
public class LaswMenuService {
	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LaswMenuDao laswMenuDao;

	/**
	 * @author wangqiang 联系邮箱:417297506@qq.com 2017年7月6日 下午2:52:55 方法的说明: TODO
	 *         该方法是根据数据库栏目对象生成tree对象 暂时不用 以后需要使用可以放开标注
	 * @return
	 *
	 */
	@Deprecated
	public List<Object> getMenuTree() {
		List<LaswMenu> list = laswMenuDao.queryAll();
		if (!list.isEmpty()) {
			// 组装tree对象
			MenuTreeUtil menuTree = new MenuTreeUtil();
			List<Object> objList = menuTree.menuList(list);
			return objList;
		}
		return null;
	}

	// 获取全部
	public List<LaswMenu> queryAll() {
		return laswMenuDao.queryAll();
	}

	// 根据id获取对象
	public LaswMenu queryById(long id) {
		return laswMenuDao.queryById(id);
	}

	// 获取第一层父类对象
	public List<LaswMenu> queryParentFirst() {
		return laswMenuDao.queryParentFirst();
	}

}
