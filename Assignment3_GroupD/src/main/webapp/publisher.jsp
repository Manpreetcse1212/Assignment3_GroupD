<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.assignment3.groupd.model.PublisherD"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink !important">
	<h2>Add Publisher</h2>
	<form action="PublisherServlet" method="post">
		<input type="hidden" name="action" value="insert" /> Name : <input
			type="text" name="name" /> <br>Address : <input type="text"
			name="address" /> <br> <input type="submit" value="insert" />
	</form>
	<br>
	<br>
	<h2>Update Publisher</h2>
	<br>
	<form action="PublisherServlet" method="post">
		<input type="hidden" name="action" value="update" />ID : <input
			type="text" name="pub-id" /><br> Name : <input type="text"
			name="name" /> <br>Address : <input type="text" name="address" />
		<br> <input type="submit" value="update" />
	</form>
	<br>
	<br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<PublisherD> publishers = (ArrayList<PublisherD>) session.getAttribute("publishers");
			if (publishers != null) {
				for (int i = 0; i < publishers.size(); i++) {
					PublisherD obj = publishers.get(i);
			%>
			<tr>
				<td><%=obj.getId()%></td>
				<td><%=obj.getName()%></td>
				<td><%=obj.getAddress()%></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>