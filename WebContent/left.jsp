<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
	<style>
		body{background-color:#ececec}
		li {list-style:none;width:200px;heigh:50px;line-height:50px;background-color:#F3F3F3} 
		a {text-decoration:none}
		button{
			width: 140px;
			line-height: 38px;
			text-align: center;
			font-weight: bold;
			color: #fff;
			text-shadow:1px 1px 1px #333;
			border-radius: 5px;
			margin:0 20px 20px 0;
			position: relative;
			overflow: hidden;
}
	</style>
	   <script language="javascript">
    	function extCase() {
    	if (confirm("是否执行用例！")){
    		alter("执行用例程序在服务器启动执行")
    		location.href="ExtCase"
    		}
    	else{
    		return false;
    		}
    	}
    	</script>

<body>
  <ul> 
 	<li id="i1" ><a href="TestCaseList" target="main">测试用例显示</a></li>
	<li><a href="HistoryList" target="main">执行历史显示</a></li>
	<li><a href="PageCount" target="main">最新结果显示</a></li>	
	<li><a href="ReportList" target="main">执行报表列表显示</a></li>	
	<li><a href="NewReport" target="main">报表图显示</a></li>
	<li><a href="#"onclick="javascript:extCase()">执行用例</button></li>	
</ul>
</body>
</html>