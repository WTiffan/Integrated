$(function(){
	console.log("猪猪");
	//表单验证
	$("#submit").click(function(){
		// console.log($("#username input").val());
		// console.log($("#inputpsw input").val());
		// return false;
		var username = $("#username input").val();
		var password = $("inputpsw input").val();
		if(username == "" && password == null){
			$("#username").css({
				border: "0.5px solid red"
			});
			$("#inputpsw").css({
				border: "0.5px solid red"
			});
			alert("输入错误！");
			console.log("未输入用户名和密码");
			return false;
		}
		else if(username == ""){
			$("#username").css({
				border: "0.5px solid red"
			});
			alert("用户名错误！");
			console.log("用户名为空");
			return false;
		}
		else if(password == null || password.length() <8){
			$("#inputpsw").css({
				border: "0.5px solid red"
			});
			alert("密码错误！");
			console.log("密码不正确");
			return false;
		}
	})
})