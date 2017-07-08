package com.ky.biz;

import java.util.List;
import java.util.Map;

import com.ky.bean.BlogType;
import com.ky.biz.BlogTypeBiz;


/**
 * 博客类型
 * @author Administrator
 *
 */
public interface BlogTypeBiz {
	
	/**
	 * 查询所有博客类型 以及对应的博客数量
	 * @return
	 */
	public List<BlogType>countList();
	
	/**
	 * 通过 ID 查找博客类型实体
	 */
	public BlogType findById(Integer id);
	
	
	//后台
	
	/**
	 * 分页查询类别
	 * @param map
	 * @return
	 */
	public List<BlogType>list(Map<String,Object>map);
	
	
	/**
	 * 获取总记录数
	 */
	public Long getTotal(Map<String,Object>map);
	
	
	/**
	 * 后台添加
	 */
	public Integer add(BlogType blogType);
	
	/**
	 * 后台修改
	 */
	public Integer update(BlogType blogType);
	
	//删除博客类吧
	public void delete(Integer id);
}
