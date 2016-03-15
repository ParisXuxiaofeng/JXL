<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="com.jftt.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String fname="学生信息";
	out.clearBuffer(); 
	out = pageContext.pushBody();

	OutputStream os=response.getOutputStream();
	response.reset();
	
	response.setCharacterEncoding("UTF-8");
	fname=java.net.URLEncoder.encode(fname,"UTF-8");
	response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
	response.setContentType("application/msexcel");
	JxlTest jxl=new JxlTest();
	jxl.createExcel(os);
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java excel</title>
</head>
<body>

</body>
</html>