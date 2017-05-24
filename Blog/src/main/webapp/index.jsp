<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	/*机顶网址  防止路径出错    只有jsp特有*/
	String path=request.getContextPath();  //  /douban
	//                    http           ://      localhost            :       8080                /douban /       
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<base href="<%=basePath %>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="static/css/blog.css">
<script src="static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="static/bootstrap3/js/bootstrap.min.js"></script>
<title>博客主页</title>
<style type="text/css">
	body{
		padding-top: 10px;
		padding-bottom: 40px;
	}
</style>
</head>
<body>

<div class="container">
	<!-- bootstrap栅格   行   分 一份四(放的log)    一份八(引入天气的代码) -->
	<div class="row">
	  <div class="col-md-4">
	  	<img alt="黑幽灵个人博客系统" src="static/images/logo.png">
	  </div>
	  <div class="col-md-8">
	  	<iframe style="float: right;" width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
	  </div>
	</div>
	
	<!--导航栏  -->
	<div class="row">
		<div class="col-md-12" style="padding-top: 10px">
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#"><font color="black"><strong>首页</strong></font></a>
			      <a class="navbar-brand" href="#"><font color="black"><strong>关于博主</strong></font></a>
			      <a class="navbar-brand" href="#"><font color="black"><strong>本站源码下载</strong></font></a>
			    </div>
			
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">    
			       <!--  <li><a href="#"><font color="black"><strong>关于博主</strong></font></li>
			        <li><a href="#"><font color="black"><strong>本站源码下载</strong></font></li> -->
			      </ul>
			      <!-- 搜索框 -->
			      <form class="navbar-form navbar-right" role="search">
			        <div class="form-group">
			          <input type="text" class="form-control" placeholder="请输入要查询的关键字...">
			        </div>
			        <button type="submit" class="btn btn-default">搜索</button>
			      </form>
			    </div>
			  </div>
			</nav>
		</div>
	</div>

	<!-- bodly块 -->
	<div class="row">
		<div class="col-md-9">
	  	<div class="data_list">
	  		<div class="data_list_title">
			<img src="static/images/list_icon.png"/>
			最新博客
			</div>
			
			<!-- 发布的博客信息 -->
			<div class="datas">
	  			<ul>
	  				<li style="margin-bottom: 30px">
	  					<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/52.html">2016年02月15日</a></span>
					  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/52.html">使用CXF开发WebService客户端</a></span>
					  	<span class="summary">摘要: 前面一讲开发了webservice服务器端接口，今天的话，我们来开发webservice客户端，让大家来体验下过程；首先建一个Maven项目，项目名字，WS_Client；然后我们要用CXF给我们提供的工具wsdl2java 来根据请求的url生成客户端代码；wsdl2java工具在CXF开发包里；开发下载地...</span>
					  	<span class="img">
					  		
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/a.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203213.jpg" src="${pageContext.request.contextPath}/static/userImages/b.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/c.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
					  		
					  	</span>
					  	<span class="info">发表于 2016-02-15 21:06 阅读(71) 评论(5) </span>
	  					
	  				</li>
	  				 <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
	  				
	  				<li style="margin-bottom: 30px">
	  					<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/52.html">2016年02月15日</a></span>
					  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/52.html">使用CXF开发WebService客户端</a></span>
					  	<span class="summary">摘要: 前面一讲开发了webservice服务器端接口，今天的话，我们来开发webservice客户端，让大家来体验下过程；首先建一个Maven项目，项目名字，WS_Client；然后我们要用CXF给我们提供的工具wsdl2java 来根据请求的url生成客户端代码；wsdl2java工具在CXF开发包里；开发下载地...</span>
					  	<span class="img">
					  		
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/a.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203213.jpg" src="${pageContext.request.contextPath}/static/userImages/b.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/c.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
					  		
					  	</span>
					  	<span class="info">发表于 2016-02-15 21:06 阅读(71) 评论(5) </span>
	  					
	  				</li>
	  				 <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
	  				
	  				
	  				<li style="margin-bottom: 30px">
	  					<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/52.html">2016年02月15日</a></span>
					  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/52.html">使用CXF开发WebService客户端</a></span>
					  	<span class="summary">摘要: 前面一讲开发了webservice服务器端接口，今天的话，我们来开发webservice客户端，让大家来体验下过程；首先建一个Maven项目，项目名字，WS_Client；然后我们要用CXF给我们提供的工具wsdl2java 来根据请求的url生成客户端代码；wsdl2java工具在CXF开发包里；开发下载地...</span>
					  	<span class="img">
					  		
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/a.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203213.jpg" src="${pageContext.request.contextPath}/static/userImages/b.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/c.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
					  		
					  	</span>
					  	<span class="info">发表于 2016-02-15 21:06 阅读(71) 评论(5) </span>
	  					
	  				</li>
	  				 <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
	  			</ul>
	  		</div>
	  	</div>
	  </div>
	  
	  <!-- 博主信息 -->
	  <div class="col-md-3">
	  		<div class="data_list">
				<div class="data_list_title">
					<img src="static/images/user_icon.png"/>
					博主信息
				</div>
				<div class="user_image">
					<img src="static/userImages/${blogger.imageName }"/>
				</div>
				<div class="nickName">${blogger.nickName }</div>
				<div class="userSign">(${blogger.sign })</div>
			</div>
			<!-- 类别 -->
			<div class="data_list">
				<div class="data_list_title">
					<img src="static/images/byType_icon.png"/>
					按日志类别
				</div>
				<div class="datas">
					<ul>
							<c:forEach var="blogTypeCount" items="${blogTypeCountList}">
								<li><span><a href="#">${blogTypeCount.typeName}(${blogTypeCount.blogCount})</a></span></li>
							</c:forEach>
					</ul>
				</div>
			</div>
			
			<!-- 日期 -->
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
					按日志日期
				</div>
				<div class="datas">
					<ul>
							<c:forEach var="blogCount" items="${blogCountList}">
								<li><span><a href="#">${blogCount.releaseDateStr}(${blogCount.blogCount})</a></span></li>
							</c:forEach>
					</ul>
				</div>
			</div>
			
			<!-- 友情链接 -->
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
					友情链接
				</div>
				<div class="datas">
					<ul>
							<c:forEach var="link" items="${linkList}">
								<li><span><a href="${link.linkUri}" target="_blank">${link.linkName}</a></span></li>
							</c:forEach>
						
					</ul>
				</div>
			</div>
	  </div>
	</div>
	<!-- bodly -->
	
	<!-- 底部 -->
	<div class="row">
		<div class="col-md-12" >
			<div align="center" style="padding-top: 120px" >
				<span style="float: left;">Create by <a  href="http://www.heiyouling.com" target="_blank">heiyouling</a> V1.0</span>
				  Copyright © 2016-2017 黑幽灵 版权所有
			</div>
		</div>
	</div>

</div>
</body>
</html>