package com.ky.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ky.Util.CryptographyUtil;
import com.ky.bean.Blogger;
import com.ky.biz.BloggerBiz;
import com.ky.dao.BaseDao;

/**
 * 前台 博主 controller
 * @author Administrator
 *
 */
@Controller
public class BloggerController {
	
	private BloggerBiz bloggerBiz;

	@Resource(name="bloggerBizImpl")
	public void setBloggerService(BloggerBiz bloggerBiz) {
		this.bloggerBiz = bloggerBiz;
	}
	
	@RequestMapping("/login")
	public String login(Blogger blogger,HttpServletRequest request){
		System.out.println("come in login");
		Subject subject=SecurityUtils.getSubject(); //获取当前登录的用户
		UsernamePasswordToken token=new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "heiyouling"));
		try{
			subject.login(token); // 登录验证		
			return "redirect:admin/main.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("blogger", blogger);
			request.setAttribute("errorInfo", "用户名或者密码错误！");
			return "login";
		}
	}
	
	@RequestMapping("/aboutMe")
	public ModelAndView aboutMe()throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("pageTitle", "关于博主");
		mav.addObject("mainPage", "foreground/blogger/info.jsp");
		mav.setViewName("mainTemp");
		return mav;
		
	}
	
}
