package com.ky.biz;

import java.util.List;
import java.util.Map;

import com.ky.bean.Link;

public interface LinkBiz {
	
	/**
	 * 查找友情链接
	 */
	
	public List<Link> list(Map<String,Object>map);
	
}
