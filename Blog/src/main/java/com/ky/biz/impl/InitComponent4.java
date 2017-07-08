 package com.ky.biz.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ky.bean.Blog;
import com.ky.bean.BlogType;
import com.ky.bean.Blogger;
import com.ky.bean.Link;
import com.ky.biz.BlogBiz;
import com.ky.biz.BlogTypeBiz;
import com.ky.biz.BloggerBiz;
import com.ky.biz.LinkBiz;

/**
 * 初始化组件   在服务期开始就加载   存在Application  全局作用域
 * @author Administrator
 * 实现了servlet  中的ServletContextListener
 * 实现了spring  中的ApplicationContextAware 
 */

@Component
public class InitComponent4 implements ServletContextListener,ApplicationContextAware {

	//spring 提供的 ApplicationContext  
	//定义  再设值
	private static ApplicationContext applicationContext;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	@Override 
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	
	/**
	 * 因为在主页面上  有一块博主信息每次加载页面的时候都会显示，不管在那个页面都会显示，所有把它存在application中
	 * 服务器启动的时候 初始化  就加载它   提高效率响应时间快
	 */
	@Override//初始化       一开始就会调用
	public void contextInitialized(ServletContextEvent sce) {
		//在这个方法里面放信息 开始的时候调用
		
		//获取application
		ServletContext application=sce.getServletContext();
		//通过 applicationContext bean biz  dao 获取上下文
		BloggerBiz bloggerBiz=(BloggerBiz) applicationContext.getBean("bloggerBizImpl");
		Blogger blogger=bloggerBiz.find(); //获取博主信息
		blogger.setPassword(null); //将密码清空  安全
		application.setAttribute("blogger", blogger);
		
		LinkBiz linkBiz=(LinkBiz) applicationContext.getBean("linkBizImpl");
		List<Link>linkList=linkBiz.list(null);
		application.setAttribute("linkList", linkList);
		
		BlogTypeBiz blogTypeBiz=(BlogTypeBiz) applicationContext.getBean("blogTypeBizImpl");
		List<BlogType> blogTypeCountList=blogTypeBiz.countList();//查询博客类别以及博客数量
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		BlogBiz blogBiz=(BlogBiz)applicationContext.getBean("blogBizImpl");
		List<Blog> DateList=blogBiz.groupList()	;//根据日期分组查询博客
		application.setAttribute("DateList", DateList);
		
	}

	

}
