<%@page import="java.util.List"%>
<%@page import="jp.co.solxyz.lessons.servlet.dao.q02.dto.CustomerDto"%>
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

	<div>
		<form action="dao02list" method="POST">
			<select name="sort">
				<option value="">選択してください</option>
				<option value="ASC">年齢昇順</option>
				<option value="DESC">年齢降順</option>
			</select> <br> <input type="text" name="state" placeholder="所在地" /><br>
			<input type="text" name="mobile" placeholder="携帯電話" /> <br> <input
				type="submit" value="送信" />
		</form>
	</div>

	<br>


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