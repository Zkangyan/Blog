package com.ky.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.bean.Blogger;
import com.ky.biz.BloggerBiz;
import com.ky.dao.BaseDao;

/**
 * 博主实现类
 * @author Administrator
 *
 */
@Service
public class BloggerBizImpl implements BloggerBiz {
	
	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public Blogger getByUserName(String userName) {
		Blogger blogger=new Blogger();
		blogger.setUserName(userName);
		List<Blogger>list=this.baseDao.findAll(blogger, "getByUserName");
		if(list!=null && list.size()>0){
			return list.get(0);//解决类型转换出错
		}else{
			return null;
		}
		
		
	}

	@Override
	public Blogger find() {
		List<Blogger>list=this.baseDao.findAll(new Blogger(), "find");
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
