package com.ky.biz;

import com.ky.bean.Blogger;

public interface BloggerBiz {
	
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
	//查询博主信息
	public Blogger find();
	
	/**
	 * 跟新博主信息
	 */
	public Integer update(Blogger blogger);
	
}
