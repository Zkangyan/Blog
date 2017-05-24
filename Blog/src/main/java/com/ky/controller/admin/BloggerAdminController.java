package com.ky.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ky.biz.BloggerBiz;

/**
 * 博主管理员controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	private BloggerBiz bloggerBiz;

	@Resource(name="bloggerBizImpl")
	public void setBloggerService(BloggerBiz bloggerBiz) {
		this.bloggerBiz = bloggerBiz;
	}
	
}
