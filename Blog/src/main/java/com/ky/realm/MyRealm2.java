package com.ky.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.ky.bean.Blogger;
import com.ky.biz.BloggerBiz;

/**
 * 自定义 Realm
 * @author Administrator
 *
 */
public class MyRealm2 extends AuthorizingRealm{
	
	
	private BloggerBiz bloggerBiz;
	
	@Resource(name="bloggerBizImpl")
	public void setBloggerService(BloggerBiz bloggerBiz) {
		this.bloggerBiz = bloggerBiz;
	}
	
	
	/**
	 * 为当前的登录的用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;  //如果复杂就要用到数据的角色和权限
	}
	/**
	 * 验证当前登录用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//这些数据从数据看获取
		String userName=token.getPrincipal().toString();//获取当前用户的name
		Blogger blogger=(Blogger) bloggerBiz.getByUserName(userName);
		if(blogger!=null){
			// 把当前用户信息存到session中  不确定是否是正确的用户  所有就是稍微浪费一点内存    
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger); 
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), "xxx");
			return authcInfo;
		}else{
			return null;			
		}
	}

}
