<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/postionMan.css" />
<style type="text/css">
table tr {
	height: 25px;
	text-align: left;
	letter-spacing:2px;
	margin-top: 10px;
}
span{
 font-size: 16px;
 font-weight: 800;
}
</style>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<a href="deparementServer?op=show">部门管理</a> <a href="PostionMan.jsp">职务管理</a>
			<a href="EmplyeeMan.jsp">员工信息管理</a> <a href="PostionCall.jsp">岗位调用管理</a>
			<a href="InforSelect.jsp">信息查询管理</a> <a href="Infor_Analyst.jsp">信息分析管理</a>
		</div>
		<div class="rightb">
			<p>员工信息管理</p>
			<div class="one">
				<form method="post" action="archivesServer?op=searchByName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字查询档案" id="sub" name="employeeName" /> <input
						type="submit" value="确定" class="bt" />
				</form>
				<form method="post" action="archivesServer?op=searchByDepartName" onsubmit="return bb()">
					<input type="text" class="inp" placeholder="按部门查询档案" id="part"  name="departmentName"/> <input
						type="submit" value="确定" class="bt" />
				</form>
				<a href="archivesServer?op=showAll">所有员工档案</a> <a
					href="AddRecord.jsp">添加档案</a>


			</div>
			<div style="width: 50%; margin: 0 auto;">
				<table>
				<c:if test="${! empty requestScope.archives}">
					<tr>
						<td><span>员工编号:</span>${requestScope.archives.employeeId}</td>
					</tr>
					<tr>
						<td><span>时间:</span>${requestScope.archives.createTime}</td>
					</tr>
					<tr>
						<td><span>标题:</span>${requestScope.archives.title}</td>
					</tr>
					<tr>
						<td><span>内容:</span>${requestScope.archives.content}</td>
					</tr>
					</c:if>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
			var subb= document.getElementById("sub");
			var partt= document.getElementById("part");
			        
			 function b(){
				 var c=false;
				 
				 if(subb.value.length==0){
					
					 alert("不能为空");
				 }else{
					 c=true;
				 }
				 return c;
			 }
			 function bb(){
				 var cc=false;
				 if(partt.value.length==0){
					 alert("不能为空");
				 }else{
					
					 cc=true;
				 }
				 return cc;
			 }

		</script>
</body>
</html>