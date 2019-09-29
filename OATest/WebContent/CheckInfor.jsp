<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
		<link rel="stylesheet" href="css/postionShow.css" />
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
				<p>信息查询管理</p>
				<div class="one">
					<form method="post" action="inforSelect?op=searchByName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字搜索下属"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="inforSelect?op=endLine" class="a2">我的下属</a>
				<a href="inforSelect?op=allInfor" class="a1" >显示所有员工</a>
				
				<div class="xx">
				<c:if test="${! empty requestScope.details}">
					<span>姓名:${requestScope.details.employeeName}</span><br/>
					<span>编号:${requestScope.details.employeeAccount}</span><br/>
					<span>职务:${requestScope.details.jobName}</span><br/>
					<span>年龄:${requestScope.details.age}</span><br/>
					<span>工龄:${requestScope.details.workAge}</span><br/>
					<span>部门:${requestScope.details.departmentName}</span><br/>
					<span>电话:${requestScope.details.employeeIphone}</span><br/>
					</c:if>
				</div>
			 
				
				  
			</div>
		
			
		</div>
		</div>
		<script type="text/javascript">

		  var sub=document.getElementById("sub");
	     function b(){
	     	var bb=false;
	     	var nr=sub.value;
	     	if (nr.length==0) {
	     		alert("不能为空");
	     		
	     	} else{
	     		bb=true;
	     	}
	     	return bb;
	     }
	     </script>
</body>
</html>