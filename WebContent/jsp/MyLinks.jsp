<%@page import="java.util.ArrayList"%>
<%@page import="JDBC.Links"%>
<%@page import="sun.awt.image.ImageWatched.Link"%>
<%@page import="JDBC.DaoClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyLinks</title>
<link type="text/css" rel="stylesheet" href="/JavaWeb/css/index.css">
<script src="/JavaWeb/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/JavaWeb/js/links.js"></script>

</head>
<body id="ebody">
	<div class="screen_shade"></div>
   
    <!-- heaher -->
    <div class="header_cont">
    	<div class="page_title"><%= session.getAttribute("UserName") %>のLinks</div>
    </div>
    
    <!--main-->
    <div class="main_cont">
    	<!--搜索框-->
        <div class="baidu_ser">
            <form action="http://www.baidu.com/baidu" target="_blank" class="baidu_ser_cont">
                <table><tr><td>
                    <input name="tn" type="hidden" value="SE_zzsearchcode_shhzc78w">
                    <span class="ser_title">Baidu</span>
                    <input id="serach_input"  type="text"  name="word" size="30" baiduSug="1" class="serach_input"  placeholder="" autocomplete="off">
                    <input type="submit"  value="搜索" class="serach_buttton int_button">
                </td></tr></table>
            </form>
        </div>        
        
                
        <div class="linkscont" >
 
            <!--links-->
            <div class="link_normal_cont">
                <div class="model_tab">
                    <ul>
                        <li><a href="javascript:mylinks()" class="model_selt model">MyLinks</a> </li>
                        <li><a href="javascript:upd()" class="model">编辑</a> </li>
                        <li><a href="javascript:add()" class="model">添加</a> </li>
                        <li><a href="javascript:del() " class="model">删除</a> </li>
                    </ul>
                </div>
                
                <div class="diy_links color_change">
                	<ul>
                    	<li style="display:none;"></li>

                    	<% 
                    		//循环创建、填充 <li><a>标题</a></li>
                    		DaoClass dao = new DaoClass();
                    		Links links = new Links();
                    		ArrayList<Links> alist = dao.linksQuery((String)session.getAttribute("Email"));
                    		
                    	%>
       	                      
				        <%                   	
						for(int i=0;i<alist.size();i++)
							{
								links = (Links)alist.get(i);
						%>
							<!-- li start -->
								<li>
								<a  id=<%=links.getLinkid() %>
									href=<%= links.getLinka() %> 
									target="_blank" class="links">
									<%= links.getLinkname() %>
								</a>
								<a name="upd_a"  class="links_upd" href="javascript:upd_set(<%= links.getLinkid() %>)">编辑</a>
								
								<input name="check_box" class="check_box" type="checkbox" value="<%=links.getLinkid() %>">
				                </li>
				                
							<!-- li   end -->	
						<%
							}
						%>                     
                    	</ul>
                     </div>
                     <!-- 添加/更新 框 -->
                     <div id="add_upd" class="add_links">
	                     <form id="form_add_upd" action="/JavaWeb/AddLinks" method="get">
	                     	<input id="HideId" type="hidden" name="LinkId">
	                     	<div class="add_link_name">名称：<input type="text" id="LinkName" name="LinkName" class="add_link_name_text_box"></div>
	                     	<div class="add_link_a">地址：<input type="text" id="LinkA" name="LinkA" class="add_link_a_text_box"></div>
	                     	<div class="add_link_submit"><input type="submit" id="sub_but"   value="添加" class="int_button add_link_submit_button"></div>
	                     </form>	
                     </div>
                     <!-- 删除 -->
                     <div id="del_div" class="del_div">
	                     <form action="/JavaWeb/DeleteLinks" onsubmit="return go_del()" method="post">
	                     	<input id="ids" name="ids"  type="hidden">
	                     	<input id="del_but" type="submit"  value="删除" class="int_button del_but">
	                     </form>
                     </div>

            </div>
            

                        
            
        </div>
    </div>
    
    
    <!--footer-->
    <div class="footer_cont">
        <div class="footer">
    
    <p class="logo_sm"><b><i>MyLinks</i></b> 简单，导航</p>
    <p class="last_footer">beta v1.0</p>
        
</div>    </div>
    
    <div class="top"  style="display:none;"><i class="fa fa-arrow-up" aria-hidden="true"></i></div>
</html>