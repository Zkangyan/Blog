package com.ky.biz;

import java.util.List;

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

}
