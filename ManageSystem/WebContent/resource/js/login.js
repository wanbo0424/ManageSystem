function login(path){
	var user=$("#loginname").val()||'';
	var pwd=$("#password").val()||'';
	var sign=new Date().getTime();
	console.info(user+" and  "+pwd);
	pwd=hex_md5(user,hex_md5(pwd));
	
	console.info(pwd);
	$.ajax({
		url: path+'/userlogin',
		type:'post',
		data:{
			loginName:user,
			password:pwd,
			sign:sign
		},
	success:function(data){
		if(data=='success')
			window.location=path+"/home";
		else if(data=='none'){
			alert("该用户不存在");
		}
		else{
			alert("密码错误");
		}
	},
	error:function(data){
		alert(data);
	}
		
	});
	
}

