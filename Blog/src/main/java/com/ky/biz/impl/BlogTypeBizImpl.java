package com.ky.biz.impl;

import java.util.List;
import java.util.Map;

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
		List<BlogType>list=this.baseDao.findAll(blogType, "findById");
		return list.get(0);
	}

	@Override
	public List<BlogType> list(Map<String, Object> map) {
		BlogType bt=new BlogType();
		return this.baseDao.findAll(bt, map,"list");
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		BlogType bt=new BlogType();
		double size=this.baseDao.findFunc(bt, "getTotal");
		return (long)size;
	}

	@Override
	public Integer add(BlogType blogType) {
		this.baseDao.add(blogType, "add");
		return null;
	}

	@Override
	public Integer update(BlogType blogType) {
		this.baseDao.update(blogType, "update");
		return null;
	}

	@Override
	public void delete(Integer id) {
		BlogType blogType=new BlogType ();
		this.baseDao.delete(blogType, "delete");
		
	}
}
