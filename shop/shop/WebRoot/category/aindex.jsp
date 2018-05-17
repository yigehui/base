<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
  	<%@include file="/admin/head.jspf" %>
  	<style type="text/css">
    	#menu {
    		width:200px;
    		/*border:1px solid red;*/
    	}
    	#menu ul {
    		list-style: none;
    		padding: 0px;
    		margin: 0px;
    	} 
    	#menu li {
    		border-bottom: 1px solid #fff;
    	}
    	#menu ul li a {
    	/* 设置 a标签的宽和内间距 则先转换为块元素  默认是行内元素 */
    		display: block;
    		background-color: #b7ba6b;
    		color: #fff;
    		padding: 5px;
    		text-decoration: none;
    		
    	}
    	#menu ul li a:HOVER {
    		background-color: #f173ac;
    	}
    		
    </style>
   <script type="text/javascript">
   		$(function() {
   			$("a[title]").click(function() {
   				
   				var text = $(this).text();
   				var href = $(this).attr("title");
   				//1.判断当前页面是否有tab
   				if($("#tt").tabs("exists",text)) {
   					$("#tt").tabs('select',text);
   				}else {//2.如果没有创建一个新的tab
   					$("#tt").tabs('add',{
   						title: text
   						,
   						closable: true
   						
   						,content: '<iframe frameborder="0" height="100%" width="100%" title='+ text +' src='+ href +' />'
   						
   						
   					});

   				}
   				
   			});
   		});
   </script>
	</head>

	<body class="easyui-layout">   
	    <div data-options="region:'north',title:'欢迎来到商城后台管理系统 ',split:true" style="height:100px;"></div>   
	    <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
	    	<!-- 此处显示系统菜单 -->
			<div id="aa" class="easyui-accordion"
				data-options="fit:true">
				<div  id="menu" title="基本操作">
					<ul>
						<li><a href="#" title="send_category_query.action">类别管理</a></li>
						<li><a href="#" title="send_product_query.action">商品管理</a></li>
					</ul>

				</div>
				<div id="menu" title="销售操作">
					<ul>
						<li><a href="#" title="send_sale_sale.action">销售管理</a></li>
					</ul>
				</div>
				
			</div>
		</div>   
	    <div data-options="region:'center',title:'后台操作页面'" style="padding:1px;background:#fff;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="系统缺省页面" style="padding:20px;">
			
			此处显示以后相关的系统信息（当前操作系统的信息，包括当前项目的域名，硬件的相关配置，报表等）
			</div>
			
		</div>
	<div id="win"   data-options="modal:true,collapsible:false,minimizable:false,maximizable:false">   </div>  
	</div>   
	</body>  
  
 
</html>
