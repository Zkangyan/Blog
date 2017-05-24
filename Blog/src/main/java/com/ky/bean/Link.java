package com.ky.bean;

import java.io.Serializable;

/**
 * 友情链接实体
 * @author Administrator
 *
 */
public class Link implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String linkName;
	private String linkUri;
	private Integer orderNo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUri() {
		return linkUri;
	}
	public void setLinkUri(String linkUri) {
		this.linkUri = linkUri;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "Link [id=" + id + ", linkName=" + linkName + ", linkUri=" + linkUri + ", orderNo=" + orderNo + "]";
	}
	
}
