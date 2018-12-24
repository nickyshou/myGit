<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<%@ page import="util.*" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table.history
{ font-family: verdana,arial,sans-serif; font-size:11px; color:#333333; border-width: 1px; border-color: #666666; border-collapse: collapse;}
 table.history th { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #dedede;}
 table.history td { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #ffffff;}
 </style>
</head>
<body>
<% DBdao da=new DBdao();
	ArrayList<HistoryBean> list=(ArrayList<HistoryBean>)request.getAttribute("list");
	//ArrayList<TestCaseBean> list=da.SeleCasePage(page);
	HistoryBean bean=null;
%>
	<table class="history" border="1" align="center" style="border-collapse: collapse;">
		<tr>
			<td>历史记录ID</td>
			<td>用例名称</td>
			<td>执行时间</td>
			<td>执行结果</td>
			<td>失败信息</td>
			<td colspan="2"></td>
		</tr>
		<tr>
		<%for(int i=0;i<list.size();i++){
		bean=list.get(i);%>
		<td><%=bean.getCaseListID()%></td>
		<td><%=bean.getCaseName()%></td>
		<td><%=bean.getRunTime() %></td>
		<td><%=bean.getResult() %></td>
		<td><%=bean.getFailures() %></td>
		</tr>
		<%} %>
		  <tr>
              <td align="center" colspan="5">
                  <%=request.getAttribute("bar") %>
              </td>
          </tr>
</body>
</html>