<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<div id="ho">

	<jsp:include page="index.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="box2">
		<span onclick="dep()">部门权限检索</span> <span onclick="sho()">部门职务权限</span>

	</div>

</div>

<div id="departmentSearch" class="sd">
	<span class="clo" onclick="cl()">关闭</span>

	<form action="showOneLimit.html" method="post">

		<div class="sele">
			部门: <select>
				<option>---请选择---</option>
			</select><br /> <br /> <input type="submit" value="确定" class="stj" />
		</div>
	</form>
</div>
<div id="searchDe" class="sd">
	<span class="clo" onclick="gb()">关闭</span>

	<form action="departmentLimitList.html" method="post">

		<div class="sele">
			部门: <select>
				<option>---请选择---</option>
			</select><br /> 职位: <select>
				<option>---请选择---</option>
			</select><br /> <input type="submit" value="确定" class="stj" />
		</div>
	</form>

</div>


<div class="right"></div>
</body>
<script type="text/javascript">
	function dep() {
		var p = document.getElementById("departmentSearch");
		var ho = document.getElementById("ho");
		ho.className = "hid";
		p.className = "s";
	}

	function cl() {
		var departmentSearch = document.getElementById("departmentSearch");
		var ho = document.getElementById("ho");
		departmentSearch.className = "sd"
		ho.className = "yb";
	}

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

	var btn = document.getElementsByClassName("btn")[0];
	var right = document.getElementsByClassName("right")[0];
	var i = 0;
	btn.onclick = function() {
		i++;
		if (i % 2 != 0) {
			right.style.right = "0px";
		} else {
			right.style.right = "-200px";
		}

	}
</script>


</html>