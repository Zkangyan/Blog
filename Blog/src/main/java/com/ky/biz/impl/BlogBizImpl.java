package com.ky.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.bean.Blog;
import com.ky.biz.BlogBiz;
import com.ky.dao.BaseDao;
import com.ky.dao.impl.BaseDaoMybatisImpl;

@Service
public class BlogBizImpl implements BlogBiz {

	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	
	@Override
	public List<Blog> groupList() {
		Blog blog=new Blog();
		/*List<Blog> list=this.baseDao.findAll(blog, "countListDate");
		for(Blog b:list){
			System.out.println(b.getReleaseDateStr());//null
		}*/
		return this.baseDao.findAll(blog, "countListDate");
		 
	}

	@Override
	public List<Blog> list(Map<String, Object> map) {
		Blog blog=new Blog();
		return this.baseDao.findAll(blog, map, "list");
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		Blog blog=new Blog();
		double size=this.baseDao.findFunc(blog, "getTotal");
		return (long)size;
	}

	@Override
	public Integer add(Blog blog) {
		return this.baseDao.add(blog, "add");
	}


	@Override
	public Blog findById(Integer id) {
		Blog blog=new Blog();
		blog.setId(id);
		List<Blog> list=this.baseDao.findAll(blog, "findById");
		System.out.println(list);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public Integer update(Blog blog) {
		return this.baseDao.update(blog, "update");
	}


	@Override
	public Blog getLastBlog(Integer id) {
		Blog blog=new Blog();
		blog.setId(id);
		List<Blog> list=this.baseDao.findAll(blog, "getLastBlog");
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}


	@Override
	public Blog getNextBlog(Integer id) {
		Blog blog=new Blog();
		blog.setId(id);
		List<Blog> list=this.baseDao.findAll(blog, "getNextBlog");
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}


	@Override
	public void delete(Integer id) {
		Blog blog=new Blog();
		blog.setId(id);
		this.baseDao.delete(blog, "delete");
	}


	@Override
	public Integer getBlogByTypeId(Integer typeId) {
		Blog blog=new Blog();
		blog.setTypeId(typeId);
		double size=this.baseDao.findFunc(blog, "getBlogByTypeId");
		return (int) size;
	}
	
}
