<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/PartMan.css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script>


$(function(){
	
	$("#chform").validate({
		rules:{
			departmentName:{
				required:true
			}
			
		},
		messages:{
			departmentName:{
				required:"必填"
			}
			
		}
		
	})
	}
	)


</script>
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
			<p>部门管理</p>
			<a href="PartAdd.jsp" class="add">添加部门</a>
			<div class="addPart">
				<form action="${pageContext.request.contextPath}/deparementServer?op=add"
					method="post" id="chform">
					<span> 部门名称：<input type="text" name="departmentName" /></span><br />
					<span> 部门描述：
					<textarea cols="40" rows="10" name="departmentDesc"></textarea>
					</span> <input type="submit" value="确定" class="sub">
				</form>
			</div>

		</div>


	</div>
</body>
</html>