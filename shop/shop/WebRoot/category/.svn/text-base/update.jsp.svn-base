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
    		//取得当前的选中id  iframe中的dg对象
    		var dg = parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
    		var rows = dg.datagrid("getSelections");
    		
    		//完成数据的回显
    		$('#ff').form('load',{
    			'id':rows[0].id,
    			'type':rows[0].type,
    			'hot':rows[0].hot,
    			'account.id':rows[0].account.id
    		});
			//远程加载管理员
			$('#cc').combobox({    
			    url:'Account_query.action',    
			    valueField:'id',    
			    textField:'login',
			    panelHeight:'auto',
			    panelWidth:'150',
			    width:'150',
			    editable:false
			});  
			    		
    		
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
        				url:'Category_update.action',
        				success: function(){
        					parent.$("#win").window('close');	// 如果提交成功则关闭窗口
        					//刷新dg窗口
        					dg.datagrid('reload');
        					
        				}
        			});
        			};
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
        <label for="account">所属管理员:</label><%--   
        <select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
			    <option value="aa">aitem1</option>   
			    <option>bitem2</option>   
			    <option>bitem3</option>   
			    <option>ditem4</option>   
			    <option>eitem5</option>   
		</select>  
    	--%>
    <!-- 远程加载管理员数据 -->
    <input id="cc" name="account.id" />  
    </div>  
    <div>
    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新类别</a>
    	<!-- 添加隐藏域，id -->  
    	<input type="hidden" name="id"/>
    </div>
</form> 
 
  </body>
</html>
    	
 