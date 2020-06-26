<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- Servlet側で項目チェックを実行した場合 --%>
<h2>Servletで実行した場合</h2>
年齢チェック：
<%= request.getAttribute("message") %>
<%-- JSP側で実行する場合 --%>
<h2>JSPで実行する場合</h2>

<%
String param = request.getParameter("age");

try {
	int age = Integer.parseInt(param);
	String message;
	if (age < 20) {
		message = "こどもです";
	} else if (age <= 60) {
		message = "おとなです";
	} else {
		message = "おじいちゃんです";
	}
%>
	<%=message %>
<%

} catch(NumberFormatException e) {
%>
	空です
<%} %>

</body>
</html>