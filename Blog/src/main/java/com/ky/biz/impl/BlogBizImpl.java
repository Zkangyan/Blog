package com.ky.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.bean.Blog;
import com.ky.biz.BlogBiz;
import com.ky.dao.BaseDao;

@Service
public class BlogBizImpl implements BlogBiz {

	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Blog> countList() {
		Blog blog=new Blog();
		return this.baseDao.findAll(blog, "countList");
		 
	}

	@Override
	public List<Blog> list(Map<String, Object> map) {
		Blog blog=new Blog();
		return this.baseDao.findAll(blog, map, "list");
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		Blog blog=new Blog();
		List list=this.baseDao.findAll(blog, map, "getTotal");
		 return (long) list.size();
	}
}
