package com.ky.biz;

import java.util.List;
import java.util.Map;

import com.ky.bean.Blog;

public interface BlogBiz {

	/**
	 * 根据日期分月分组查询
	 * @return
	 */
	public List<Blog>groupList();
	
	
	/**
	 * 分页查询博客
	 */
	public List<Blog>list(Map<String,Object>map);
	
	
	/**
	 * 获取总记录数
	 */
	public Long getTotal(Map<String,Object>map);
	
	/**
	 * 根据ID查找实体
	 * @param id
	 * @return
	 */
	public Blog findById(Integer id);
	
	/**
	 * 跟新博客系统
	 * @param blog
	 * @return
	 */
	public Integer update(Blog blog);
	
	/**
	 * 获取上一个博客
	 */
	public Blog getLastBlog(Integer id);
	
	/**
	 * 获取下一个博客
	 * @return
	 */
	public Blog getNextBlog(Integer id);
	
	/**
	 * 后台添加
	 */
	public Integer add(Blog blog);
	
	/**
	 * 后台删除
	 */
	public void delete(Integer id);
	
	
	/**
	 * 查询指定的博客类别下的博客数量
	 * @param typeId
	 * @return
	 */
	public Integer getBlogByTypeId(Integer typeId);
	
}
