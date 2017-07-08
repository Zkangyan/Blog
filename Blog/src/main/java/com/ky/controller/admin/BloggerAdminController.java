package com.ky.controller.admin;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ky.Util.CryptographyUtil;
import com.ky.Util.DateUtil;
import com.ky.Util.ResponseUtil;
import com.ky.bean.Blogger;
import com.ky.biz.BloggerBiz;

import net.sf.json.JSONObject;

/**
 * 博主管理员controller
 * @author Administrator
 *
 */
@Controller
public class BloggerAdminController {

	private BloggerBiz bloggerBiz;

	@Resource(name="bloggerBizImpl")
	public void setBloggerService(BloggerBiz bloggerBiz) {
		this.bloggerBiz = bloggerBiz;
	}
	
	/**
	 * 查询博主信息
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/admin/blogger/find")
	public String find(HttpServletResponse response)throws Exception{
		Blogger blogger=bloggerBiz.find();
		JSONObject jsonObject=JSONObject.fromObject(blogger);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
	
	/**
	 * 修改博主信息
	 * @param imageFile
	 * @param blogger
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/admin/blogger/save")
	public String save(@RequestParam("imageFile") MultipartFile imageFile,Blogger blogger,HttpServletRequest request,HttpServletResponse response)throws Exception{
		//判断用户是否传图片
		if(!imageFile.isEmpty()){
			//如果图片不为空则获取(服务器)根路径
			String filePath=request.getServletContext().getRealPath("/");
			//获取当前日期   用户上传的文件名 拼接后缀
			String imageName=DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
			//放在static/userImages目录下   +  图片的名字
			imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
			blogger.setImageName(imageName);
		}
		int resultTotal=bloggerBiz.update(blogger);
		StringBuffer result=new StringBuffer();
		if(resultTotal>0){
			result.append("<script language='javascript'>alert('修改成功！');</script>");
		}else{
			result.append("<script language='javascript'>alert('修改失败！');</script>");
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 修改博主密码
	 * @param newPassword
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/admin/blogger/modifyPassword")
	public String modifyPassword(String newPassword,HttpServletResponse response)throws Exception{
		Blogger blogger=new Blogger();
		blogger.setPassword(CryptographyUtil.md5(newPassword,"heiyouling"));
		int resultTotal=bloggerBiz.update(blogger);
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/admin/blogger/logout")
	public String logout()throws Exception{
		//注销清除了session
		SecurityUtils.getSubject().logout(); 
		return "redirect:/login.jsp";
	}
	
}
