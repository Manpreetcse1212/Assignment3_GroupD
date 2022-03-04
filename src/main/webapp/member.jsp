<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.assignment3.groupd.model.MemberD"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink !important">
	<h2>Add Member</h2>
	<form action="MemberServlet" method="post">
		<input type="hidden" name="action" value="insert" /> Name : <input
			type="text" name="name" /> <br>Address : <input type="text"
			name="address" /> <br>Type : <input type="text" name="type" />
		<br>Join : <input type="date" name="join-date" /> <br>Expiry
		: <input type="date" name="expire-date" /> <br> <input
			type="submit" value="insert" />
	</form>
	<br>
	<br>
	<h2>Update Member</h2>
	<br>
	<form action="MemberServlet" method="post">
		<input type="hidden" name="action" value="update" />ID : <input
			type="text" name="member-id" /><br> Name : <input type="text"
			name="name" /> <br>Address : <input type="text" name="address" />
		<br>Type : <input type="text" name="type" /> <br>Join : <input
			type="date" name="join-date" /> <br>Expiry : <input type="date"
			name="expire-date" /> <br> <input type="submit" value="update" />
	</form>
	<br>
	<br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Type</th>
				<th>JoinDate</th>
				<th>ExpireDate</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<MemberD> members = (ArrayList<MemberD>) session.getAttribute("members");
			if (members != null) {
				for (int i = 0; i < members.size(); i++) {
					MemberD obj = members.get(i);
			%>
			<tr>
				<td><%=obj.getMember_id()%></td>
				<td><%=obj.getName()%></td>
				<td><%=obj.getAddress()%></td>
				<td><%=obj.getType()%></td>
				<td><%=obj.getJoin_date()%></td>
				<td><%=obj.getExpire()%></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>