package com.assignment3.groupd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment3.groupd.dao.BookDDao;
import com.assignment3.groupd.model.BookD;

/**
 * Date: 23.02.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This servlet is used to handle post and get methods for creating, updating and deleting books 
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		BookDDao dao = new BookDDao(); //instance of BookDDao
		ArrayList<BookD> books = dao.ShowBooks();
		HttpSession session = request.getSession();
		session.setAttribute("books", books);
		response.sendRedirect("book.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action"); 

		if (action.equals("insert")) { //handles new book requests
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String available = request.getParameter("available");
			String price = request.getParameter("price");
			String pubId = request.getParameter("pub-id");

			BookD obj = new BookD();
			obj.setTitle(title);
			obj.setAuthor(author);
			obj.setAvailable(available);
			obj.setPrice(Double.parseDouble(price));
			obj.setPubId(Integer.parseInt(pubId));

			BookDDao dao = new BookDDao();
			dao.IssueBook(obj);
		} else if (action.equals("delete")) { //handles delete request for books 
			int id = Integer.parseInt(request.getParameter("book-id"));
			BookDDao dao = new BookDDao();
			dao.DeleteBook(id);

		} else {  //handles update requests for books
			String bookId = request.getParameter("book-id");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String available = request.getParameter("available");
			String price = request.getParameter("price");
			String pubId = request.getParameter("pub-id");

			BookD obj = new BookD();
			obj.setBookId(Integer.parseInt(bookId));
			obj.setTitle(title);
			obj.setAuthor(author);
			obj.setAvailable(available);
			obj.setPrice(Double.parseDouble(price));
			obj.setPubId(Integer.parseInt(pubId));

			BookDDao dao = new BookDDao();
			dao.UpdateBook(obj);
		}

		doGet(request, response);
	}

}
