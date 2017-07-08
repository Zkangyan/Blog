<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/*机顶网址  防止路径出错    只有jsp特有*/
	String path=request.getContextPath();  //  /douban
	//                    http           ://      localhost            :       8080                /douban /       
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
	<!--导航栏  -->
	
	<script type="text/javascript">
		function checkData(){
			var q=document.getElementById("q").value.trim();
			if(q==null || q==""){
				alert("请输入您要查询的关键字！");
				return false;
			}else{
				return true;
			}
		}
	</script>
	
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
			      <a class="navbar-brand" href="index.html"><font color="black"><strong>首页</strong></font></a>
			      <a class="navbar-brand" href="aboutMe.html"><font color="black"><strong>关于博主</strong></font></a>
			      <a class="navbar-brand" href="aboutProject.html"><font color="black"><strong>项目简介</strong></font></a>
			    </div>
			
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">    
			       <!--  <li><a href="#"><font color="black"><strong>关于博主</strong></font></li>
			        <li><a href="#"><font color="black"><strong>本站源码下载</strong></font></li> -->
			      </ul>
			      <!-- 搜索框 -->
			      <form action="q.html" class="navbar-form navbar-right" role="search" method="post" onsubmit="return checkData()">
			        <div class="form-group"> 
			          <input type="text" id="q" name="q" value="${q }" class="form-control" placeholder="请输入要查询的关键字...">
			        </div>
			        <button type="submit" class="btn btn-default">搜索</button>
			      </form>
			    </div>
			  </div>
			</nav>
		</div>
	</div>