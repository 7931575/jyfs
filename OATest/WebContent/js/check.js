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
