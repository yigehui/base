<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <%@include file="/admin/head.jspf" %>
    <!-- 实现搜索窗体的位置 -->
    <style type="text/css">
		   .searchbox {
			  margin: -3px;
		}
    	
    </style>
 
	<script type="text/javascript">
		$(function(){
			
			$('#dg').datagrid({    
				//请求数据的url地址Category_queryJoinAccount.action
			    url:'Category_queryJoinAccount.action',  
			    
			    loadMsg:'请等待......',
			    //指明标识字段
			    idField:'id',
			    //发送额外的参数
			    queryParams: {type:''},
			    //分页
			    pagination:true,
			    pageSize:5,
			    pageList:[5,10,15,20,25],
			    //自适应，设置此属性，没有滚动条
			    fitColumns:true,
			    //斑马线
			    striped:true,
			    //添加类别
			    toolbar: [{
					iconCls: 'icon-add',
					handler: function(){
						parent.$("#win").window({
							width:350,
							height:250,
							title:'添加类别',
							content:'<iframe frameborder="0" height="100%" width="100%" src="send_category_add.action" />'
						});
						},
			    	text:'添加类别'
				},'-',{
					iconCls: 'icon-remove',
					handler: function(){
						//判断是否选中一条记录
						var rows = $('#dg').datagrid("getSelections");
							//rows表示当前选中的行数
							if(rows.length!=1)
							{
								//显示提示框
								$.messager.show({
								title:'系统信息',
								msg:'一次只能更新一条信息',
								timeout:2000,
								showType:'slide'
							});
							}else{
								//实现更新逻辑 如果删除完成也会出现这个页面，首先关闭删除的选中
								//首先跳转update页面
								parent.$("#win").window({
									width:400,
									height:300,
									title:'更新类别',
									content:'<iframe frameborder="0" height="100%" width="100%" src="send_category_update" />'
								});
							}
						
					
					},
					text:'更新类别'
				},'-',{
						iconCls: 'icon-remove',
						handler: function(){
							var rows = $('#dg').datagrid("getSelections");
							//rows表示当前选中的行数
							if(rows.length==0)
							{
								//显示提示框
								$.messager.show({
								title:'系统信息',
								msg:'请选中信息后操作',
								timeout:2000,
								showType:'slide'
							});
							}else{
								//执行删除逻辑
								
								$.messager.confirm('确认对话框', '是否要删除选中记录？', function(r){
									if (r){
										//1,获取要删除的索引集合
										var ids = "";
										for(var i=0;i<rows.length;i++)
											{
											ids += rows[i].id + ',';
											}
										//2,拼接 2,3,4,5
										ids = ids.substring(0, ids.lastIndexOf(","));
								
										//3,发送ajax请求
										$.post("Category_deleteById.action",{ids:ids},function(result){
											if(result == "true")
											{
												alert("删除成功！");
												$('#dg').datagrid('reload');
												//取消选中
												$('#dg').datagrid('uncheckAll');  
											}else{
												alert("删除失败！");
											}
											
										},"text");
									
										
									}
								});


							}	
								
						},
						text:'删除类别'
				},'-',{
					text:"<input id='ss' name='search'/>"
				}],

			    //显示json数据
			    rowStyler: function(index,row){
			    		console.info("index" + index + "row" + row);
			    		}
			    	,
			  	//配置dg的列字段 field：列字段的名称，与json的key捆绑
			    frozenColumns:[[ 
			                     {field:'ygh',checkbox:true,width:100},
			                    {field:'id',title:'编号',width:100}
			                   
			                    ]],
			    columns:[[    
			          
			        {field:'type',title:'商品类别',width:100,
			        	//用来格式化当前数据，返回相应的值
			        	formatter: function(value,row,index){
							return "<span title =" + value + "> "+ value + "</span>" ;
						}

			        },    
			        {field:'hot',title:'热点',width:100,align:'right',
			        	//添加复选框
			        	formatter: function(value,row,index){
			        		if(value)
							{return "<input type = 'checkbox' checked='checked' disabled='true'>" ;
							}else{
								return "<input type = 'checkbox'  disabled='false'>";
							}
						}},   
			        {field:'account.login',title:'管理员',width:100,align:'right',
			        	//输出管理员
			        	formatter: function(value,row,index){
			        		if(row.account != null && row.account.login!= null)
							{return row.account.login ;
							}else{
								return '此类别没有管理员';
							}
						}	
			        } 
			    ]]    
			}); 
			$('#ss').searchbox({ 
				//触发查询事件
				searcher:function(value,name){ 
					//获取文本内容实现查询
					$('#dg').datagrid('load',{
						type: value
					});
				}, 
				
				prompt:'极品飞车' 
				}); 
		});
	
	</script>
  </head>
  
  <body>
  	
	<table id="dg"></table>  
	
  </body>
</html>
    	
 