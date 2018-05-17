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
			    url:'Product_queryJoinCategory.action',  
			    
			    loadMsg:'请等待......',
			    //指明标识字段
			    idField:'id',
			    //发送额外的参数
			    queryParams: {name:''},
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
							width:500,
							height:550,
							title:'添加类别',
							content:'<iframe frameborder="0" height="100%" width="100%" src="send_product_save.action" />'
						});
						},
						
			    	text:'添加商品'
				},'-',{
					iconCls: 'icon-edit',
					handler: function(){
						
						alert("===更新商品===");
					},
					text:'更新商品'
				},'-',{
						iconCls: 'icon-remove',
						handler: function(){alert("===删除商品===");								
					},
						text:'删除商品'
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
			                    {field:'id',title:'商品编号',width:100}
			                   
			                    ]],
			    columns:[[    
			          
			        {field:'name',title:'商品名称',width:100
	
			        },    
			        {field:'remark',title:'简单介绍',width:100,align:'right'},
			          
			        {field:'category.type',title:'所属类别',width:100,align:'right',
			        	//输出管理员
			        	formatter: function(value,row,index){
			        		if(row.category != null && row.category.type!= null)
							{return row.category.type;}
						}	
			        } 
			    ]]    
			}); 
			$('#ss').searchbox({ 
				//触发查询事件
				searcher:function(value,name){ 
					//获取文本内容实现查询
					$('#dg').datagrid('load',{
						name: value
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
    	
 