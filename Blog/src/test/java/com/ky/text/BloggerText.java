package com.ky.text;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ky.biz.BloggerBiz;

public class BloggerText {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	BloggerBiz biz = (BloggerBiz) ac.getBean("bloggerBizImpl");
	
	@Test
	public void test4() throws Exception {
		System.out.println(biz.find());
	}

	
}
