package com.ky.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ky.Util.PageUtil;
import com.ky.Util.StringUtil;
import com.ky.bean.Blog;
import com.ky.bean.PageBean;
import com.ky.biz.BlogBiz;

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
	public ModelAndView index(@RequestParam(value="page",required=false)String page,@RequestParam(value="typeId",required=false)String typeId,@RequestParam(value="releaseDateStr",required=false)String releaseDateStr,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		if(StringUtil.isEmpty(page)){
			page="1";//初始化
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),10);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("typeId", typeId);
		map.put("releaseDateStr", releaseDateStr);
		List<Blog> blogList=this.blogBiz.list(map);
		for(Blog blog:blogList){
			List<String> imageList=blog.getImageList();
			String blogInfo=blog.getContent();//获取博客内容
			Document doc=Jsoup.parse(blogInfo);//jsoup解析博客内容
			Elements jpgs=doc.select("img[src$=.jpg]");//设置图片格式
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				imageList.add(jpg.toString());
				if(i==2){
					break;
				}
			}
		}
		mav.addObject("blogList", blogList);
		StringBuffer param=new StringBuffer();//参数       request.getContextPath()获取根目录
		if(StringUtil.isNotEmpty(typeId)){
			param.append("typeId="+typeId+"&");
		}
		
		if(StringUtil.isNotEmpty(releaseDateStr)){
			param.append("releaseDateStr="+releaseDateStr+"&");
		}
		mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogBiz.getTotal(map), Integer.parseInt(page), 10, param.toString()));
		mav.addObject("pageTitle", "java个人博客系统");
		mav.addObject("mainPage", "foreground/blog/list.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}
	
	/**
	 * 项目简介
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/aboutProject")
	public ModelAndView download()throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("pageTitle", "项目简介");
		mav.addObject("mainPage", "foreground/system/aboutProject.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}
}
