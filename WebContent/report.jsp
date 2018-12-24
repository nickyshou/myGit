<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <title>这是第一个fusionChart 图形</title>
       
        <script language="JavaScript" src="FusionCharts/FusionCharts.js"></script>
        <script>
            function showData(value){
                alert(value);
            }        
        </script>
    </head>
    <body bgcolor="#ffffff">
     <h1 align="center">每月执行用例数图</h1>
     
        <div id="chartdiv_01" align="center"></div>
        <script type="text/javascript">   
            var myChart = new FusionCharts("FusionCharts/Column3D.swf", "myChartId_01", "600", "500");    
        myChart.setDataURL("xmlFile/mouthData.xml");    
        myChart.render("chartdiv_01");    
        </script> 
       <h1 align="center">执行结果图</h1>
        <div id="chartdiv_02" align="center"></div>
        <script type="text/javascript">   
          var myChart = new FusionCharts("FusionCharts/Doughnut3D.swf", "myChartId_02", "600", "500");    
        myChart.setDataURL("xmlFile/resultData.xml");    
        myChart.render("chartdiv_02");    
        </script> 
        
    </body>

</html>