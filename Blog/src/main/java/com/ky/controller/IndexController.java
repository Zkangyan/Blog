package com.ky.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ky.Util.CryptographyUtil;
import com.ky.Util.StringUtil;
import com.ky.bean.Blog;
import com.ky.bean.Blogger;
import com.ky.bean.PageBean;
import com.ky.biz.BlogBiz;
import com.ky.biz.BloggerBiz;

/**
 * 前台 博主 controller
 * @author Administrator
 *
 */
@Controller
public class IndexController {
	
	private BlogBiz blogBiz;

	@Resource(name="blogBizImpl")
	public void setBlogBiz(BlogBiz blogBiz) {
		this.blogBiz = blogBiz;
	}
	
	
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required=false)String page){
		ModelAndView mav=new ModelAndView();
		if(StringUtil.isEmpty(page)){
			page="1";//初始化
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),10);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Blog> blogList=this.blogBiz.list(map);
		mav.addObject("blogList", blogList);
		mav.addObject("pageTitle", "java个人博客系统");
		mav.addObject("mainPage", "foreground/blog/list.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}

	
}
