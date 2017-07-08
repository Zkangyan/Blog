package com.ky.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 博客实体
 * @author Administrator
 *
 */
public class Blog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; //编号
	private String title; // 博客标题
	private String summary;  //摘要
	private Date releaseDate;  //发布时间
	
	private Integer clickHit; //点击次数
	private Integer replyHit; // 回复次数
	private String content;//博客内容
	private String contentNoTag; //博客内容和    没有网页标签  Lucene分词用到
	
	private BlogType blogType; //博客类型
	
	private String keyWord;// 关键字 空格隔开来划分关键字
	private Integer typeId;
	private Integer blogCount;//博客数量  非博客实际字段 主要是根据发布日期归档查询数量用 
	private String  releaseDateStr;//发布日期的字符串  只去年和月
	
	private List<String> imageList=new LinkedList<String>(); // 博客里存在的图片，主要用于列表展示的缩略图
	
	public List<String> getImageList() {
		return imageList;
	}
	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}
	
	public String getContentNoTag() {
		return contentNoTag;
	}
	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getClickHit() {
		return clickHit;
	}
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}
	public Integer getReplyHit() {
		return replyHit;
	}
	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BlogType getBlogType() {
		return blogType;
	}
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	public String getReleaseDateStr() {
		return releaseDateStr;
	}
	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", summary=" + summary + ", releaseDate=" + releaseDate
				+ ", clickHit=" + clickHit + ", replyHit=" + replyHit + ", content=" + content + ", contentNoTag="
				+ contentNoTag + ", blogType=" + blogType + ", keyWord=" + keyWord + ", typeId=" + typeId
				+ ", blogCount=" + blogCount + ", releaseDateStr=" + releaseDateStr + ", imageList=" + imageList + "]";
	}

}
