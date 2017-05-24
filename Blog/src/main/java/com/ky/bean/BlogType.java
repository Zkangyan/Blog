package com.ky.bean;

import java.io.Serializable;

public class BlogType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id; // 编号
	private String typeName; // 博客类型名称
	private Integer orderNo; // 排序序号 从小到大排序
	private Integer blogCount; // 类别后面的数量数量   另加的属性
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	@Override
	public String toString() {
		return "BlogType [id=" + id + ", typeName=" + typeName + ", orderNo=" + orderNo + ", blogCount=" + blogCount
				+ "]";
	}

}
