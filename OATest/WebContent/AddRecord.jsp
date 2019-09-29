<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
<style type="text/css">
   .end{
	width: 380px;
	border: 0px solid black;
	margin: 20px auto 20px;
	text-align: left;
    }
    .end select{
     display: inline-block;
     margin-top: 10px;
    }
    .in{
     display: inline-block;
     vertical-align: top;
    }
   .put{
   height: 25px;
   width: 250px;
   }
</style>
<script type='text/javascript' src='/OATest/dwr/engine.js'></script>
 <script type='text/javascript' src='/OATest/dwr/interface/departmentDwr.js'></script>
 <script type='text/javascript' src='/OATest/dwr/interface/EmployeeDwr.js'></script>
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
					<form method="post" action="archivesServer?op=searchByName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字查询档案"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>			
					<form  method="post" action="archivesServer?op=searchByDepartName" onsubmit="return bb()">
						<input type="text" class="inp" placeholder="按部门查询档案"  id="part" name="departmentName"/>
						<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="archivesServer?op=showAll">所有员工档案</a>
						<a href="AddRecord.jsp">添加档案</a>
						
				</div>
				 
				<div class="end">
				      部门:<select id="department" onclick="employeebh()">
				   <option value="79898984">---请选择---</option>
				      </select>
				       <form action="archivesServer?op=addArchives" method="post" onsubmit="return checkForm()">
				        
					  员工编号:<select id="employeeAccount" onclick="employeexm()" name="employeeId">
				
				      </select><br>
				      员工姓名:<select id="employeeName">
				      
				      </select><br><br>
				   
				     
				       	  标题:<input class="put" type="text" class="o"  name="title" id="til"/><br/><br>
				       	   <span class="in">内容:</span><textarea rows="10" cols="40" name="context"></textarea>
				       	     <input type="submit" value="确定" class="qud"/>
				       </form>
				       </div>
				       
				</div>
					</div>
					<script type="text/javascript">
					function checkForm() {
						var Name=document.getElementById("employeeAccount");
						if(Name.value.length==0){
							alert("编号必选");
							return false;
						}else{
							var til=document.getElementById("til");
							if(til.value.length==0){
								alert("标题必填");
								return false;
							}else{
								
								var employeeName=document.getElementById("employeeName");
								if(employeeName.value.length==0){
									alert("姓名必选");
									return false;
								}else{
									return true;
								}
							}
						}
						
					}
					
					
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

			
					window.onload=function(){
						departmentDwr.getDepartment(function(data){
							var depart=document.getElementById("department");
							for(var i=0;i<data.length;i++){
							var opt=document.createElement("option");
							opt.innerHTML=data[i].departmentName;
							opt.setAttribute("value",data[i].departmentId);
							depart.appendChild(opt);
								
							}
							
						})
					}
					function employeebh() {
						var depart=document.getElementById("department");
						EmployeeDwr.getEmployeeObj(depart.value,function(data) {
						var Name=document.getElementById("employeeAccount");
						Name.options.length=0;
						
							for(var i=0;i<data.length;i++){
								var opt=document.createElement("option");
								opt.innerHTML=data[i].employeeAccount;
								
								opt.setAttribute("value",data[i].employeeId);
								Name.appendChild(opt);
									
								}
							var employeeAcc=document.getElementById("employeeName");
							employeeAcc.options.length=0;
							
						})
						
					}
					function employeexm() {
						var employeeId=document.getElementById("employeeAccount");
					
						EmployeeDwr.getEmployeeO(employeeId.value,function(data) {
						var employeeAcc=document.getElementById("employeeName");
						employeeAcc.options.length=0;
						
						
								
								var opt=document.createElement("option");
								opt.innerHTML=data.employeeName;
							
								opt.setAttribute("value",data.employeeId);
								employeeAcc.appendChild(opt);
									
								
						
							
						})
						
					}
					</script>
					
				    
</body>
</html>