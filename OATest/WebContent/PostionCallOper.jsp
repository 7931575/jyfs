<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
<link rel="stylesheet" href="css/PostCall.css" />
<script type='text/javascript' src='/OATest/dwr/engine.js'></script>
<script type='text/javascript' src='/OATest/dwr/interface/departmentDwr.js'></script>
<script type='text/javascript' src='/OATest/dwr/interface/postionDwr.js'></script>
<script type='text/javascript' src='/OATest/dwr/interface/EmployeeDwr.js'></script>
<style type="text/css">
.end{
	width: 360px;
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
    .dy{
  display: inline-block;
  margin-right: 200px;
  }
</style>
</head>
<body >

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
					<a href="postionCallServer?op=showAll" style="background-color: #ccc" class="dy">岗位调动记录</a>
					<a href="PostionCallOper.jsp"  style="background-color: #ccc">员工岗位调动</a>
				
				</div>
				
				 
				<div class="end">
				<form action="postionCallServer?op=insert" method="post">
				      部门:<select id="department" onclick="employeebh()" name="departmentId">
				 
				      </select>
				      
				        
					  员工编号:<select id="employeeAccount" onclick="employeexm()" name="employeeId">
				
				      </select><br>
				      员工姓名:<select id="employeeName" name="employeeName" onmouseup="opo()">
				      
				      </select><br>
				   调到:<select id="part" onclick="jo()" name="newDepartmentName">
				   <option>---请选择---</option>
				      </select>
				   职位:<select id="job" name="newJobName">
				   
				     </select>
				     <br>
				        <br>
				       	   <span class="in">原因:</span><textarea rows="10" cols="40" name="desc"></textarea>
				       	     <input type="submit" value="确定" class="qud"/>
				       </form>
				      
				       </div>
				       
			
				</div>
				  
			</div>
		
			
		
		<div class="right"></div>
				<script type="text/javascript">
											
				window.onload=function(){
					var op=document.getElementById("department");
					
				
             
					departmentDwr.getDepartment(function(data){	
						
						for(var i=0;i<data.length;i++){
							var opt=document.createElement("option");
							opt.innerHTML=data[i].departmentName;
							opt.setAttribute("value",data[i].departmentId);
						
									
							op.appendChild(opt);							
						}
					})
                       
				
					
				}
				
				
				
					function employeebh(){
						var op=document.getElementById("department");
						
						
						EmployeeDwr.getEmployeeObj(op.value,function(data) {
							var oa=document.getElementById("employeeAccount");
						oa.options.length=0;
						for(var i=0;i<data.length;i++){
							var opt=document.createElement("option");
							opt.innerHTML=data[i].employeeAccount;
							opt.setAttribute("value",data[i].employeeId);
							
							oa.appendChild(opt);
						
						}
					})
					var name=document.getElementById("employeeName");
						name.options.length=0;
						
						}
					
				function employeexm() {
					var oa=document.getElementById("employeeAccount");
					EmployeeDwr.getEmployeeO(oa.value,function(data){
						
						var name=document.getElementById("employeeName");
						name.options.length=0;
						for(var i=0;i<1;i++){
							var opt=document.createElement("option");
							opt.innerHTML=data.employeeName;
							opt.setAttribute("value",data.employeeId);
							
							name.appendChild(opt);
						}
					
					})
					
					
				}
			function jo(){
				var part=document.getElementById("part");
			
				postionDwr.getPostionObj(part.value,function(data){
					var job=document.getElementById("job");
					job.options.length=0;
					for(var i=0;i<data.length;i++){
						var opt=document.createElement("option");
						opt.innerHTML=data[i].jobName;
						opt.setAttribute("value",data[i].jobId);
						
						job.appendChild(opt);
					}
				})
				
			}
			function opo() {
				var part=document.getElementById("part");
				part.options.length=0;
				  departmentDwr.getDepartment(function(data){	
						
						for(var i=0;i<data.length;i++){
							var optt=document.createElement("option");
							optt.innerHTML=data[i].departmentName;
							optt.setAttribute("value",data[i].departmentId);
						
					   
							part.appendChild(optt);							
						}
					})
			}
				
		
				
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