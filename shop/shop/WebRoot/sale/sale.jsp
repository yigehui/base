<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/admin/head.jspf" %>
    <script type="text/javascript" src="<%=path%>/jquery-easyui-1.3.5/jquery-1.3.1.js"></script>
    <script type="text/javascript" src="<%=path%>/jquery-easyui-1.3.5/jscharts.js"></script>
    <script type="text/javascript">
    	$(function(){
    		var color = ['#44A622','#A7B629','#CAD857','#E4DB7B','#ECDE49','#ECC049','#EC9649','#D97431','#D95531','#A7B629'];
    		$("#submit").click(function(){
    			//发送数据给后台查询 
    			//alert("-----");	
    			$.post($("#sale").val(),{number:$("#number").val()},function(data){
    				var myChart = new JSChart('chart_container', $("#chart").val(), '');
    				myChart.setDataArray(data);
    				myChart.colorize(color.slice(0, data.length));
    				myChart.setSize(100*$("#number").val(), 300);
    				myChart.setBarValues(false);
    				myChart.setBarSpacingRatio(45);
    				myChart.setBarOpacity(1);
    				myChart.setBarBorderWidth(0);
    				myChart.setTitle('Home broadband penetration');
    				myChart.setTitleFontSize(10);
    				myChart.setTitleColor('#607985');
    				myChart.setAxisValuesColor('#607985');
    				myChart.setAxisNameX('商品名称', false);
    				myChart.setAxisNameY('销量', false);
    				myChart.setGridOpacity(0.8);
    				myChart.set3D(true);
    				myChart.setAxisNameFontSizeX(10);
    				myChart.setAxisNameFontSizeY(10);
    				myChart.setAxisValuesPaddingBottom(30);
    				myChart.draw();
    				
    			},'json');
    		});
    		
    	});
    
    </script>
   
  </head>
  
 <body>
	<select id="sale">
 		<option value="Sorder_querySale.action">后台销售报表</option>
 	</select>
 	查询的数量：<select id="number">
			 		<option value="7">7</option>
			 		<option value="10">10</option>
			 		<option value="15">15</option>
			 	</select>
  	类型：<select id="chart" >
			 		<option value="bar">柱状图</option>
			 		<option value="line">线性图</option>
			 		<option value="pie">饼状图</option>
			 	</select>
 	<input type="button" id="submit" value="提交" />
<div id="chart_container">Loading chart...</div>
 
</body>
</html>
    	
 