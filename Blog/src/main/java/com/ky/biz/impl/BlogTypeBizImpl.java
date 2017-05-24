package com.ky.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.bean.BlogType;
import com.ky.biz.BlogTypeBiz;
import com.ky.dao.BaseDao;

@Service
public class BlogTypeBizImpl implements BlogTypeBiz {

	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<BlogType>countList(){
		BlogType blogType=new BlogType();
		return this.baseDao.findAll(blogType, "countList");
		
	}

	@Override
	public BlogType findById(Integer id) {
		BlogType blogType=new BlogType();
		blogType.setId(id);
		this.baseDao.findAll(blogType, "");
		return null;
	}
}
