<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 引入公共的JSP片段 -->
	<%@ include file="/admin/head.jspf"%>
	<script type="text/javascript">
	//验证
		$(function(){
			//上传文件的自定义验证
			$.extend($.fn.validatebox.defaults.rules, {    
			    format: {    
			        validator: function(value, param){    
			              
			            //获取文件的后缀名
			              var ext = value.substring(value.lastIndexOf('.') + 1);
			              //获取支持的文件后缀名，比较即可
			              
			              var arr = param[0].split(",");
			              for(var i=0;i<arr.length;i++)
			          		 {
			            	  	if(ext == arr[i])
			            	  	return true;	
			            	  }
			              return false;
			        },    
			        message: '文件必须为 ：{0}'  
			    }    
			});
			$("input[name=name]").validatebox({
				required:true,
				missingMessage:'请输入商品名称'
			});
			$("input[name=price]").numberbox({
				required:true,
				missingMessage:'请输入商品价格',
				min:0,    
				precision:2,
				prefix:'￥'	
			});
			$("textarea[name=remark]").validatebox({
				required:true,
				missingMessage:'请输入商品简单描述'
			});
			$("textarea[name=xremark]").validatebox({
				required:true,
				missingMessage:'请输入商品详细描述'
			});
			//类别的回显
			$('#cc').combobox({    
			    url:'Category_query.action',    
			    valueField:'id',    
			    textField:'type',
			    panelHeight:'auto',
			    panelWidth:'150',
			    width:'150',
			    editable:false ,
			    required: true,
			    missingMessage:'请输入所属类别'
			});  
		
			$("input[name=upload]").validatebox({
				required:true,
				missingMessage:'请上传商品图片',
				validType:"format['jpg,jpeg,png,gif']"
			});
			
			$("input[name=upload]").change(function(){
				$(this).validatebox("validate");
				
			});
			//窗体弹出默认时紧止验证
    		$("#ff").form("disableValidation");
    		//注册button事件
    		$("#submit").click(function(){
    			//1.开启验证
        		$("#ff").form("enableValidation");
        		//2.如果验证成功提交数据
        		if($("#ff").form("validate")){
        			//提交数据
        			$('#ff').form('submit', {
        				url:'Product_add.action',
        				success: function(){
        					parent.$("#win").window('close');	// 如果提交成功则关闭窗口
        					//刷新dg窗口
        					parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg").datagrid('reload');
        				}
        			});
        			}
    		});
    		
    		//注册button事件
    		$("#reset").click(function(){
    			
        		$("#ff").form("reset");
    		});
		});
	
	
	</script>
	<style type="text/css">
		form div{
			margin: 10px;
		}
	</style>
</head>

<body>
<form title="添加商品" id="ff" method="post" enctype="multipart/form-data">
	<div>
		<label>商品名称:</label> <input type="text" name="name" />
	</div>
	<div>
		<label>商品价格:</label> <input type="text" name="price" />
	</div>
	<div>
		<label>图片上传:</label> <input type="file" name="fileimage.upload" />
	</div>
	<div>
		<label>所属类别：</label> 
		<input id="cc" name="category.id" />		
	</div>
	<div>
		<label>加入推荐:</label> 推荐:<input type="radio" name="commend"
			checked="checked" value="true" />  不推荐:<input type="radio"
			name="commend" value="false" /> 
	</div>
	<div>
		<label>是否有效:</label>
		上架:<input type="radio" name="open" checked="checked"value="true" />
		下架:<input type="radio" name="open" value="false" />
				
	</div>
	<div>
		<label>简单描述:</label>
		<textarea name="remark" cols="40" rows="4"></textarea>
	</div>
	<div>
		<label>详细描述:</label>
		<textarea name="xremark" cols="40" rows="8"></textarea>
	</div>
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
</form>
</body>
</html>
