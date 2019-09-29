<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<body>
		<div id="ho">
	            <jsp:include page="index.jsp"></jsp:include>
	            <jsp:include page="top.jsp"></jsp:include>
			<div class="box3">
				<a href="AllUserLimit.jsp">所有用户权限</a>
				<span onclick="sho()">详细查询</span>

			</div>
			<div class="updat">
				<span>账号:12345</span>
				<span>姓名:张三</span>
				<span>部门:技术部</span>
				<span>职位:员工</span>
                <form >
                	
               
                 	权限:<div class="shoLi">
                 		<input type="checkbox" name="" />增加职务<br />
                 		<input type="checkbox" name="" />增加部门<br />
                 		<input type="checkbox" name="" />增加档案<br />
                 		<input type="checkbox" name="" />增加新员工<br />
                 		
                 		<input type="checkbox" name="" />允许分配权限<br />
                 		<input type="checkbox" name="" />允许查看员工信息权限<br />
                 		
                 		<input type="checkbox" name="" />允许修改登录密码<br />
                 		<input type="checkbox" name="" />允许修改头像<br />
                 			<input type="checkbox" name="" />增加档案<br />
                 		<input type="checkbox" name="" />增加新员工<br />
                 		
                 		<input type="checkbox" name="" />允许分配权限<br />
                 		<input type="checkbox" name="" />允许查看员工信息权限<br />
                 		
                 		<input type="checkbox" name="" />允许修改登录密码<br />
                 		<input type="checkbox" name="" />允许修改头像<br />
                 			<input type="checkbox" name="" />增加档案<br />
                 		<input type="checkbox" name="" />增加新员工<br />
                 		
                 		<input type="checkbox" name="" />允许分配权限<br />
                 		<input type="checkbox" name="" />允许查看员工信息权限<br />
                 		
                 		<input type="checkbox" name="" />允许修改登录密码<br />
                 		<input type="checkbox" name="" />允许修改头像<br />
                 		
                 	</div>
                 	 <input type="submit" value="确定"  class="bn"/>
                 </form>
			</div>

		</div>

		<div id="searchDe" class="sd">
			<span class="clo" onclick="gb()">关闭</span>

			<form>

				<div class="sele">
					部门:
					<select>
						<option>---请选择---</option>
					</select><br /> 职位:
					<select>
						<option>---请选择---</option>
					</select><br /> 员工编号:
					<select>
						<option>---请选择---</option>
					</select><br />
					<input type="submit" value="确定" class="stj" />
				</div>
			</form>

		</div>

		<div class="right"></div>
	</body>
	<script type="text/javascript">
		function sho() {
			var searchDe = document.getElementById("searchDe");
			var ho = document.getElementById("ho");
			ho.className = "hid";
			searchDe.className = "s";

		}

		function gb() {
			var searchDe = document.getElementById("searchDe");
			var ho = document.getElementById("ho");
			searchDe.className = "sd"
			ho.className = "yb";
		}

	
	</script>

</html>