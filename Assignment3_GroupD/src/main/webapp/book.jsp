<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.assignment3.groupd.model.BookD"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink !important">
	<h2>Add Book</h2>
	<form action="BookServlet" method="post">
		<input type="hidden" name="action" value="insert" /> Title : <input
			type="text" name="title" /> <br>Author : <input type="text"
			name="author" /> <br>Availability : <input type="text"
			name="available" /> <br>Price : <input type="text" name="price" />
		<br> Publisher ID : <input type="text" name="pub-id" /> <br>
		<input type="submit" value="insert" />
	</form>
	<br>
	<br>
	<h2>Update Book</h2>
	<br>
	<form action="BookServlet" method="post">
		<input type="hidden" name="action" value="update" />Book ID : <input
			type="text" name="book-id" /> <br> Title : <input type="text"
			name="title" /> <br>Author : <input type="text" name="author" />
		<br>Availability : <input type="text" name="available" /> <br>Price
		: <input type="text" name="price" /> <br> Publisher ID : <input
			type="text" name="pub-id" /> <br> <input type="submit"
			value="update" />
	</form>
	<br>
	<h2>Delete Book</h2>
	<br>
	<form action="BookServlet" method="post">
		<input type="hidden" name="action" value="delete" /> Book ID : <input
			type="text" name="book-id"
			placeholder="Please enter the book id to delete" /> <input
			type="hidden" name="action" value="delete" /> <br> <input
			type="submit" value="remove" />
	</form>
	<br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Available</th>
				<th>Price</th>
				<th>Publisher ID</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<BookD> books = (ArrayList<BookD>) session.getAttribute("books");
			if (books != null) {
				for (int i = 0; i < books.size(); i++) {
					BookD obj = books.get(i);
			%>
			<tr>
				<td><%=obj.getBookId()%></td>
				<td><%=obj.getTitle()%></td>
				<td><%=obj.getAuthor()%></td>
				<td><%=obj.getAvailable()%></td>
				<td><%=obj.getPrice()%></td>
				<td><%=obj.getPubId()%></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>