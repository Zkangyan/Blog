package com.ky.biz;

import java.util.List;
import java.util.Map;

import com.ky.bean.Blog;

public interface BlogBiz {

	/**
	 * 根据日期分月分组查询
	 * @return
	 */
	public List<Blog>countList();
	
	
	/**
	 * 分页查询博客
	 */
	public List<Blog>list(Map<String,Object>map);
	
	
	/**
	 * 获取总记录数
	 */
	public Long getTotal(Map<String,Object>map);
	
	
}
