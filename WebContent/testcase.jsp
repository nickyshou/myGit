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
body {background-color:#e5e5e5}
table.caselist
{ font-family: verdana,arial,sans-serif; font-size:11px; color:#333333; border-width: 1px; border-color: #666666; border-collapse: collapse;}
 table.caselist th { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #dedede;}
 table.caselist td { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #ffffff;}
 </style>
</head>
<body>
<% DBdao da=new DBdao();
	ArrayList<TestCaseBean> list=(ArrayList<TestCaseBean>)request.getAttribute("list");
	//ArrayList<TestCaseBean> list=da.SeleCasePage(page);
	TestCaseBean bean=null;
%>
	<table class="caselist" border="1" align="center" style="border-collapse: collapse;">
		<tr>
			<td>用例ID</td>
			<td>功能名称</td>
			<td>功能模块</td>
			<td>用例名称</td>
			<td>说明</td>
			<td colspan="2"></td>
		</tr>
		<tr>
		<%for(int i=0;i<list.size();i++){
		bean=list.get(i);%>
		<td><%=bean.getCaseID()%></td>
		<td><%=bean.getDescrip()%></td>
		<td><%=bean.getModelName() %></td>
		<td><%=bean.getTestCaseName() %></td>
		<td><%=bean.getInterpret() %></td>
		</tr>
		<%} %>
		  <tr>
              <td align="center" colspan="5">
                  <%=request.getAttribute("bar") %>
              </td>
          </tr>
	</table>
	</body>
</html>