<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
<style type="text/css">
 .recode{
 margin-top: 50px;
 
 }

</style>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
		<div class="content">
			<div class="left">
				<a href="deparementServer?op=show">部门管理</a>
			<a href="PostionMan.jsp">职务管理</a>
			<a href="EmplyeeMan.jsp">员工信息管理</a>
			<a href="PostionCall.jsp">岗位调用管理</a>
			<a href="InforSelect.jsp">信息查询管理</a>
			<a href="Infor_Analyst.jsp">信息分析管理</a>	
			</div>
			<div class="rightb">
				<p>岗位调用管理</p>
				<div class="one">
					<form method="post" action="postionCallServer?op=searchByName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字搜索"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="postionCallServer?op=showAll" style="background-color: #ccc;margin-right: 50px">岗位调动记录</a>
					<a href="PostionCallOper.jsp" style="background-color: #ccc">员工岗位调动</a>
		
				</div>
				<div class="recode">
				<c:if test="${! empty requestScope.position}">
				<span>原部门:${requestScope.position.oldDepartmentName}</span>	<br />
					<span>原职位:${requestScope.position.oldJobName}</span><br />
					
						<span>现在部门:${requestScope.position.newDepartmentName}</span><br />
						<span>现在职位:${requestScope.position.newJobName}</span><br>
						<span>更改时间:${requestScope.position.postionCreateTime}</span><br>
						<span>原因:${requestScope.position.postionDescribe}</span>
					</c:if>
				</div>
				
				  
			</div>
		
			
		</div>
		<script type="text/javascript">
		var sub = document.getElementById("sub");
		function b() {
			var bb = false;
			var nr = sub.value;
			if (nr.length == 0) {
				alert("不能为空");

			} else {
				bb = true;
			}
			return bb;
		}
		</script>
</body>
</html>