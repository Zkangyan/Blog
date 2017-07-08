<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
 <%
	/*机顶网址  防止路径出错    只有jsp特有*/
	String path=request.getContextPath();  //  /douban
	//                    http           ://      localhost            :       8080                /douban /       
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <base href="<%=basePath %>"> 
<div class="data_list">
	  		<div class="data_list_title">
			<img src="static/images/list_icon.png"/>
			最新博客
			</div>
			<!-- 发布的博客信息 -->
			<div class="datas">
	  			<ul>
	  				<c:forEach var="blog" items="${blogList}">
		  				<li style="margin-bottom: 30px">
		  					<span class="date"><a href="articles/${blog.id }.html"><fmt:formatDate value="${blog.releaseDate}" type="date" pattern="yyyy年MM月dd日"/></a></span>
						  	<span class="title"><a href="articles/${blog.id }.html">${blog.title}</a></span>
						  	<span class="summary">摘要: ${blog.summary }...</span>
						  	 
						  	<span class="img">
							  		<c:forEach var="image" items="${blog.imageList }">
								  		<a href="/articles/${blog.id }.html">${image}</a>
								  		&nbsp;&nbsp;
							  		</c:forEach>
						  	</span>
						  
						  	<span class="info"><fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy-MM-dd HH:mm"/> 阅读(${blog.clickHit }) 评论(${blog.replyHit}) </span>
		  					
		  				</li>
		  				 <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
	  				</c:forEach>
	  			</ul>
	  		</div>
	  	</div>
	  	
	  	
<!--  bootstrap分页-->
<div>
	<nav>
	  <ul class="pagination pagination-sm">
	  		${pageCode }
	  </ul>
	</nav>
 </div>	  	
	  	
	  	
	  	