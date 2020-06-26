<%@page import="java.util.List"%>
<%@page import="jp.co.solxyz.lessons.servlet.dao.q03.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CustomerDto customer = (CustomerDto) request.getAttribute("CUSTOMER");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><%=customer.getName()%>さんの詳細情報
	</h1>

	<table border="1">
		<thead>
		</thead>
		<tbody>

			<tr>
				<td>名前</td>
				<td><%=customer.getName()%></td>
			</tr>
			<tr>
				<td>カナ</td>
				<td><%=customer.getKana()%></td>
			</tr>
			<tr>
				<td>性別</td>
				<td><%=customer.getSex()%></td>
			</tr>
			<tr>
				<td>電話</td>
				<td><%=customer.getTel()%></td>
			</tr>
			<tr>
				<td>携帯</td>
				<td><%=customer.getMobile()%></td>
			</tr>
			<tr>
				<td>email</td>
				<td><%=customer.getMail()%></td>
			</tr>
			<tr>
				<td>年齢</td>
				<td><%=customer.getAge()%></td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td><%=customer.getPostal()%></td>
			</tr>
			<tr>
				<td>都道府県</td>
				<td><%=customer.getState()%></td>
			</tr>
			<tr>
				<td>市区町村</td>
				<td><%=customer.getCity()%></td>
			</tr>
			<tr>
				<td>区画</td>
				<td><%=customer.getStreet()%></td>
			</tr>
			<tr>
				<td>番地</td>
				<td><%=customer.getAddressline1()%></td>
			</tr>

			<tr>
				<td>建物・部屋</td>
				<td><%=customer.getAddressline2()%></td>
			</tr>

		</tbody>
	</table>
</body>
</html>