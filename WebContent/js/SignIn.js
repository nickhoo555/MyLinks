function test(v)
{
	alert(v.Email.value);
}


//验证表单，提交表单
 function SignIn()
 {
 	//调用check，返回check结果
 	//判断check结果 y: 提交 , n: no
	 if(check_Email() & check_UserName() & check_Password() & check_AgianPassword())
	 {
		 //验证通过，提交表单
		 return true;
	 }
	 else
	 {
	 	return false;
	 }
 }   




//验证电子邮件
 function  check_Email()
 {

	  var checkEmailflag=false;
       var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
       var email=document.getElementById("Email").value;
       if(!myreg.test(email)){
             checkEmailflag=false;
             document.getElementById("email_warn").style.color='red';
             document.getElementById("email_warn").innerHTML = "  × 邮箱格式不符合规范";
         } else {
             checkEmailflag=true;
             document.getElementById("email_warn").style.color='green';
             document.getElementById("email_warn").innerHTML = "√ 邮箱格式正确";
         }
       return checkEmailflag;
 }


//验证用户名
 function check_UserName()
 {
	
	 var checkUserNameflag=false;
	 var zz = /^[A-Za-z0-9]{6,}$/;
	 var username = document.getElementById("UserName").value;
	 
	    if (!zz.test(username)) {
	    	document.getElementById("user_name_warn").style.color='red';
	    	document.getElementById("user_name_warn").innerHTML = "  × 用户名不符合规范";
	        checkUserNameflag=false;
	    } else {
	    	document.getElementById("user_name_warn").style.color='green';
	    	document.getElementById("user_name_warn").innerHTML = "√ 用户名可用";
	        checkUserNameflag=true;
	    }
	    return checkUserNameflag;
 }
//验证密码
 function check_Password()
 {
 	var checkPasswordflag=false;
 	var password1 = document.getElementById("PassWord").value;
    if (password1.length >= 6 && password1.length <= 15) {
        checkPasswordflag = true;
       	document.getElementById("pass_word_warn").style.color='green';
        document.getElementById("pass_word_warn").innerHTML = "  √ 密码可用 ";
    } else {
        checkPasswordflag = false;
       	document.getElementById("pass_word_warn").style.color='red';
       	document.getElementById("pass_word_warn").innerHTML = "  × 密码至少为 6 个字符 ";
    }
	return checkPasswordflag;
 }
 //确认密码
 function check_AgianPassword()
 {
 	var checkPasswordAgianflag=false;
	var password1 = document.getElementById("PassWord").value;
    var password2 = document.getElementById("PassWordAgian").value;
    if (password2 == "") 
    {
        	document.getElementById("pass_word_agian_warn").style.color='red';
            document.getElementById("pass_word_agian_warn").innerHTML = "  × 请确认密码 ";
            checkPasswordAgianflag = false;
            
   }
	    else if (password1 == password2) 
	    {
	       document.getElementById("pass_word_agian_warn").style.color='green';
	        document.getElementById("pass_word_agian_warn").innerHTML = "√ 密码已确认";
	        checkPasswordAgianflag = true;
	    } else {
	        checkPasswordAgianflag = false;
        	document.getElementById("pass_word_agian_warn").style.color='red';
	        document.getElementById("pass_word_agian_warn").innerHTML = "  × 两次密码输入不同 ";
	        
	    }

	    return checkPasswordAgianflag;
 }
