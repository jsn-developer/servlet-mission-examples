<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter</title>
</head>
<body>

<%-- サーブレットで処理をした場合 --%>
<h2>Servletで実行した場合</h2>
<%= request.getAttribute("message") %>

<%-- JSP側で実行する場合 --%>
<h2>JSPで実行する場合</h2>
<%
String param = request.getParameter("number");

String message;

try {
	int number = Integer.parseInt(param);

	message = "" + number;

	for(int i = number -1; i >= 0; i--) {
		message = message + "," + i;
	}

} catch (NumberFormatException e) {
	// 空の場合はNumberFormatExceptionが出るのでここで空とする
	message = "空です";
}
%>
<%=message %>

</body>
</html>