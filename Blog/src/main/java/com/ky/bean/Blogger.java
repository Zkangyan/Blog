package com.ky.bean;

import java.io.Serializable;

/**
 * 博主用户实体类
 * @author Administrator
 *
 */
public class Blogger implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  userName;
	private String  password;
	private String profile;//个人简介   描述
	private String nickName;//昵称
	private String sign;  //个性签名
	private String imageName;  //图片路径
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "Blogger [id=" + id + ", userName=" + userName + ", password=" + password + ", profile=" + profile
				+ ", nickName=" + nickName + ", sign=" + sign + ", imageName=" + imageName + "]";
	}

}
