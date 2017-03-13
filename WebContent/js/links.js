//默认
function mylinks(){
	
	document.getElementById("add_upd").style.display="none";
	document.getElementById("del_but").style.display="none";
	//checkbox
	var controls=document.getElementsByName("check_box"); 
	for(var i=0;i<controls.length;i++)
	{ 
		controls[i].style.display="none"; 
	}
	//update
	var controls=document.getElementsByName("upd_a"); 
	for(var i=0;i<controls.length;i++)
	{ 
		controls[i].style.display="none";   
	}
	
}
//添加
function add(){
	document.getElementById("form_add_upd").action="/JavaWeb/AddLinks";
	document.getElementById("sub_but").value="添加";
	document.getElementById("sub_but").style.color="#17C6A3";	
	mylinks();
	document.getElementById("add_upd").style.display="block"; 
	//show_hide(document.getElementById("add_upd"));

}
//删除
function del(){
	//隐藏add_upd
	//document.getElementById("add_upd").style.display="none";
	//del_but
	//show_hide(document.getElementById("del_but"));
	mylinks();
	document.getElementById("del_div").style.display="block"; 
	document.getElementById("del_but").style.display="block"; 
	//checkbox
	var d=document.getElementsByName("check_box"); 
	for(var i=0;i<d.length;i++)
	{ 
		//show_hide(d[i]);
		d[i].style.display="block"; 
	}
}
//执行批量删除
function go_del()
{
	if(confirm("删除所选内容？"))
		{
		//jq获取checkbox
			var ids="";
			$(":checkbox").each(function(){ 
			
				if (this.checked) 
				{ 
					ids += $(this).attr('value')+','; 
				} 
				});
				//拼接完的ids存入hide
				if(ids!="")
					{
						document.getElementById("ids").value=ids;
						return true;
					}
				else
					{
						return false;
					}
		}
		else
		{
			return false;
		}
			
		
    //---
}
//更新
function upd(){
	mylinks();
	//更改表单提交目标
	document.getElementById("form_add_upd").action="/JavaWeb/Update";	
	document.getElementById("sub_but").value="更新";
	document.getElementById("sub_but").style.color="#6fc5ee";
	document.getElementById("add_upd").style.display="block";
	var d = document.getElementsByName("upd_a"); 
	for(var i=0;i<d.length;i++)
	{ 	
				d[i].style.display="block";
	}
}
//捕获编辑项的现有内容
function upd_set(v)
{
	document.getElementById("HideId").value=v;
	document.getElementById("LinkName").value=document.getElementById(v).innerText;
	document.getElementById("LinkA").value=document.getElementById(v);

}
//交替显示隐藏, 
function show_hide(d)
{
	
	if(d.style.display=="none")
	{
		d.style.display="block"; 
	}
	else
	{
		d.style.display="none"; 
	}
}
