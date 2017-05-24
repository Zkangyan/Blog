package com.ky.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.bean.Blogger;
import com.ky.bean.Link;
import com.ky.biz.BloggerBiz;
import com.ky.biz.LinkBiz;
import com.ky.dao.BaseDao;

/**
 * 博主实现类
 * @author Administrator
 *
 */
@Service
public class LinkBizImpl implements LinkBiz {
	
	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Link> list(Map<String, Object> map) {
		Link link=new Link();
		return this.baseDao.findAll(link, map, "list");
	}

	
		
		
	

}
