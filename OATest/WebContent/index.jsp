<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
		<div class="header">
			<img class="logo" src="img/ia_100000000.png" />
			<div class="navlist">
				<a href="#">我的桌面，Ian</a>
				
			</div>
			<div class="rightnav">
				<i class="icon1"></i>
				<i class="icon2"></i>
				<i class="icon3 btn"></i>
			</div>
		</div>
		<div class="box1">
			<span >你好,${sessionScope.employee.employeeName}</span> <a href="limitIndex.jsp" style="display: inline-block; margin-left: 1180px;text-decoration: none">权限管理</a>
		</div>
		<ul class="leftnav">
			<li>
				<i></i>
				<a href="#">管理中心</a>
			</li>
			<li>
				<i></i>
				<a href="#">管理中心</a>
			</li>
			<li>
				<i></i>
				<a href="#">管理中心</a>
			</li>
			<li>
				<i></i>
				<a href="#">管理中心</a>
			</li>
			<li>
				<i></i>
				<a href="#">管理中心</a>
			</li>
			<li>
				<i></i>
				<a href="#">管理中心</a>
			</li>
			<li>
				<i></i>
				<a href="#">管理中心</a>
			</li>
		</ul>
		<div class="notice1">
			<p class="p1">最新公告：</p>
			<div class="notice2">
				<p>旅游经营服务七类行为 或将列入“严重失信”</p>
				<p>中国成为纽约市第二大境外旅游客源国</p>
				<p>旅游经营服务七类行为 或将列入“严重失信”</p>
			</div>
		</div>

		<div class="right"></div>
	</body>
	<script type="text/javascript">
		var btn = document.getElementsByClassName("btn")[0];
		var right = document.getElementsByClassName("right")[0];
		var i = 0;
		btn.onclick =function(){
			i++;
			if(i%2!=0){
				right.style.right= "0px";
			}else{
				right.style.right= "-200px";
			}
			
		}
	</script>
</html>
