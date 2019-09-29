<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
<link rel="stylesheet" href="css/personInfo.css" />
<script type='text/javascript' src='/OATest/dwr/engine.js'></script>
<script type='text/javascript' src='/OATest/dwr/interface/departmentDwr.js'></script>
<script type='text/javascript' src='/OATest/dwr/interface/postionDwr.js'></script>
<script type='text/javascript' src='/OATest/dwr/interface/EmployeeDwr.js'></script>
<style type="text/css">
 .s{
  padding-right: 10px;
  border: solid 1px black;
  text-align: center;
   display:inline-block;
   position: absolute;
   right: 49%;
 }
</style>
</head>
<body>
	<jsp:include page="index.jsp" />
	<div class="content">
		<div class="left">
			<a href="deparementServer?op=show">部门管理</a> <a href="PostionMan.jsp">职务管理</a>
			<a href="EmplyeeMan.jsp">员工信息管理</a> <a href="PostionCall.jsp">岗位调用管理</a>
			<a href="InforSelect.jsp">信息查询管理</a> <a href="Infor_Analyst.jsp">信息分析管理</a>
		</div>
		<div class="rightb">
			<p>员工信息管理</p>
			<div class="one">
					<form method="post" action="employeeServer?op=searchName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字查询"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>			
					<form method="post" action="employeeServer?op=searchByDepartmentName" onsubmit="return ba()">
						<input type="text" class="inp" placeholder="按部门查询"  id="part" name="departmentName"/>
						<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="employeeServer?op=show">所有员工信息</a>
						<a href="AddPersonInfo.jsp">添加员工</a>
							<a href="employeeServer?op=personInfor">个人信息</a>
				</div>
			<form action="${pageContext.request.contextPath}/employeeServer?op=addEmployee" method="post" onsubmit="return ckform()" enctype="multipart/form-data">
			<div class="per">
				<table border="0px" cellpadding="0" cellspacing="0">
					<tr>

						<td>姓名:<input type="text" name="employeeName">
						</td>
						<td>民族:<input type="text" name="employeeNation">
						</td>
					</tr>
					<tr>
						<td>账号:<input type="text" name="employeeAccount"  onblur="checkpa()" id="word">
						</td>
						<td>密码:<input type="text" name="employeePassWord">
						</td>
					</tr>
					<tr>
						<td>生日:<input type="date" name="employeeBirthday">
						</td>
						<td>性别:<input type="radio" name="sex" value="1" checked="checked">男 <input
							type="radio" name="sex" value="0">女
						</td>
					</tr>
					<tr>
						<td>电话:<input type="text" name="employeeIphone">
						</td>
						<td>身份证:<input type="text" name="employeeIdNumber">
						</td>
					</tr>
					<tr>
						<td>毕业院校:<input type="text" name="employeeGraduateSchool">
						</td>
						<td>居住地址:<input type="text" name="employeeAddress">
						</td>
					</tr>
					<tr>
						<td>结婚信息:<input type="radio" name="jh" value="1" checked="checked"> 是 <input
							type="radio" name="jh" value="0">否
						</td>
						<td>学历:<select name="employeeEduBackground">
					         	<option value="初中">---初中---</option>
								<option value="高中">---高中---</option>
								<option value="大专">---大专---</option>
								<option value="本科">---本科---</option>
								<option value="研究生">---研究生---</option>
								<option value="博士">---博士---</option>
						</select>
						</td>

					</tr>
					<tr>

						<td>部门:<select id="op" name="departmentId" onclick="ck()">
                         <option value="7931578">---请选择---</option>
						</select></td>

						<td>职位: <select id="pos" name="jobId">

						</select></td>
					</tr>
					<tr>

						<td>进入公司时间:<input type="date" name="employeeEntryTiime">
						</td>
						<td>头像:<input type="file" name="myFile" /></td>
					</tr>

				</table>
				<input type="submit" value="确定"  class="s">
			</div>
           </form>
		</div>


	</div>
	
		
	<script type="text/javascript">
	function checkpa(){
		var word=document.getElementById("word");
		EmployeeDwr.isExit(word.value,function(data){
			if(data!=0){
				alert("该账号已经被占用");
			}
		})
	}
	function ckform() {
		
	var p=	document.getElementsByTagName("input");
	for(var i=3;i<p.length;i++){
		if(p[i].value.length==0){
			alert("请填完数据")
			return false;
		}
	}
		var jobI=document.getElementById("pos");
	
			if(jobI.value.length==0){
				alert("请选择职位");
				return false;
			}
		
	
	
	}
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

	
		window.onload=function(){
			
			var selec=document.getElementById("op");
			departmentDwr.getDepartment(function(data){
				
				for(var i=0;i<data.length;i++){
					var opt=document.createElement("option");
					opt.innerHTML=data[i].departmentName;
					opt.setAttribute("value",data[i].departmentId);
					selec.appendChild(opt);
				}
			});
	
		
		
		}
		function ck() {
			var sele=document.getElementById("pos");
			sele.options.length=0
			var selec=document.getElementById("op").value;
			postionDwr.getPostionObj(selec,function(data){
				
				for(var i=0;i<data.length;i++){
					var opt=document.createElement("option");
					opt.innerHTML=data[i].jobName;
					opt.setAttribute("value",data[i].jobId);
					sele.appendChild(opt);
				}
				
				
			})
		}
	     </script> 
</body>
</html>