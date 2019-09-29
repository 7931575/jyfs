<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div id="ho">
		<jsp:include page="index.jsp"></jsp:include>
		<jsp:include page="top.jsp"></jsp:include>

		<div class="box2">
			<a href="AllUserLimit.jsp">所有用户权限</a> <span onclick="sho()">详细查询</span>

		</div>
	</div>
	<div id="searchDe" class="sd">
		<span class="clo" onclick="gb()">关闭</span>

		<form action="showOneLimit.jsp" method="post">

			<div class="sele">
				部门: <select>
					<option>---请选择---</option>
				</select><br /> 职位: <select>
					<option>---请选择---</option>
				</select><br /> 员工编号: <select>
					<option>---请选择---</option>
				</select><br /> <input type="submit" value="确定" class="stj" />
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