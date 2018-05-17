<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/admin/head.jspf" %>
    <style type="text/css">
    	form div {
    	margin: 5px;
    	}
    </style>
    <script type="text/javascript">
    	$(function(){
    		
    		$("input[name=type]").validatebox({
    			required:true,
    			missingMessage:'请输入类别名称'
    		});
    		//窗体弹出默认时紧止验证
    		$("#ff").form("disableValidation");
    		//注册button事件
    		$("#btn").click(function(){
    			//1.开启验证
        		$("#ff").form("enableValidation");
        		//2.如果验证成功提交数据
        		if($("#ff").form("validate")){
        			//提交数据
        			$('#ff').form('submit', {
        				url:'Category_add.action',
        				success: function(){
        					parent.$("#win").window('close');	// 如果提交成功则关闭窗口
        					//刷新dg窗口
        					parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid('reload');
        					
        				}
        			});
        			}
    		});
    		
    	}
 );
    </script>
  </head>
  
  <body>
 	<form id="ff" method="post">   
    <div>   
        <label for="type">类别名称:</label>   
        <input type="text" name="type"/>   
    </div>   
    <div>   
        <label for="hot">热点:</label>   
		        热点：<input type="radio" name="hot" value="true"/>   
		        非热点：<input type="radio" name="hot" value="false" checked="checked"/> 
    </div>   
    <div>
    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加类别</a>  
    </div>
</form> 
 
  </body>
</html>
    	
 