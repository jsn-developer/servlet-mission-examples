<%@page import="java.util.List"%>
<%@page import="jp.co.solxyz.lessons.servlet.dao.q01.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<CustomerDto> custList = (List<CustomerDto>) request.getAttribute("CUST_LIST");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<table border="1">
		<thead>
			<tr>
				<th>名前</th>
				<th>かな</th>
				<th>性別</th>
				<th>電話番号</th>
				<th>携帯電話</th>
				<th>メールアドレス</th>
				<th>住所</th>
				<th>年齢</th>
				<th>都道府県</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (CustomerDto cust : custList) {
				//for (int i=0; i<10; i++) {
			%>
			<tr>
				<td><%=cust.getName()%></td>
				<td><%=cust.getKana()%></td>
				<td><%=cust.getSex()%></td>
				<td><%=cust.getTel()%></td>
				<td><%=cust.getMobile()%></td>
				<td><%=cust.getMail()%></td>
				<td><%=cust.getPostal()%></td>
				<td><%=cust.getAge()%></td>
				<td><%=cust.getState()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>