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

	@Override
	public Long getTotal(Map<String, Object> map) {
		Link link=new Link();
		double size=this.baseDao.findFunc(link, "getTotalLink");
		return (long) size;
	}

	@Override
	public Integer add(Link link) {
		return this.baseDao.add(link, "addLink");
	}

	@Override
	public Integer update(Link link) {
		return this.baseDao.update(link, "updateLink");
	}

	@Override
	public void delete(Integer id) {
		Link link=new Link();
		link.setId(id);
		this.baseDao.delete(link, "deleteLink");
		
	}

	
		
		
	

}
