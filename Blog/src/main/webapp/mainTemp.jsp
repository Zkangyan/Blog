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
<title>${pageTitle }-Powered by 黑幽灵</title>
<style type="text/css">
	body{
		padding-top: 10px;
		padding-bottom: 40px;
	}
</style>
</head>
<body>

<div class="container">
	<jsp:include page="/foreground/common/head.jsp"></jsp:include>
	<jsp:include page="/foreground/common/menu.jsp"></jsp:include>


	<!-- bodly块 -->
	<div class="row">
		<div class="col-md-9">
	  	<jsp:include page="${mainPage }"></jsp:include>
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
	
	<jsp:include page="/foreground/common/foot.jsp"></jsp:include>

</div>
</body>
</html>