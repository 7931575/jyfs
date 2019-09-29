<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
				<link rel="stylesheet" href="css/personInfo.css" />
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
				<p>员工信息管理</p>
				<div class="one">
					<form method="post" action="employeeServer?op=searchName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字查询"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>			
					<form method="post" action="employeeServer?op=searchByDepartmentName" onsubmit="return ba()">
						<input type="text" class="inp" placeholder="按部门查询"  id="part"  name="departmentName"/>
						<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="ShowPersonInfo.jsp">所有员工信息</a>
						<a href="AddPersonInfo.jsp">添加员工</a>
							<a href="employeeServer?op=personInfor">个人信息</a>
				</div>
				<form action="employeeServer?op=updatePass" method="post" class="fo" onsubmit="return ckk()">
					<span >输新密码:<input type="text" name="newPassWord" id="newPassWord"/></span>
					<span >确认密码:<input type="text" name="qdPassWord"  id="qdPassWord"/></span>
					<input type="submit"  class="su"/>
				</form>
				  
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
	var part = document.getElementById("part");
	function ba() {
		var bb = false;
		var nr = part.value;
		if (nr.length == 0) {
			alert("不能为空");

		} else {
			bb = true;
		}
		return bb;
	}
	var newPassWord = document.getElementById("newPassWord");
	var qdPassWord = document.getElementById("qdPassWord");
	  function ckk(){
		  var a=false;
		  var newp=newPassWord.value;
		  var qdnew=qdPassWord.value;
		  if(newp.length==0){
			  alert("密码不能为空");
		  }else if(qdnew.length==0){
			  alert("请确认密码");
		  }else if(qdnew.length!=0){
			  if(newp!=qdnew){
				  alert("密码不一致");
			  }else{
				  a=true;
			  }
		  }
		  return a;
	  }
	</script>
</body>
</html>