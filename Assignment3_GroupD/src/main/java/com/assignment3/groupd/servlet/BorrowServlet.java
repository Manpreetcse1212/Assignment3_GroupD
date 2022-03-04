package com.assignment3.groupd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment3.groupd.dao.BorrowDDao;
import com.assignment3.groupd.model.BorrowD;

/**
 * Date: 23.02.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This servlet is used to handle post and get methods for creating, showing borrow details 
 */
@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowServlet() {
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

		BorrowDDao dao = new BorrowDDao(); //instance of BorrowDDao
		ArrayList<BorrowD> borrow = dao.ShowBorrow();
		HttpSession session = request.getSession();
		session.setAttribute("borrows", borrow);

		response.sendRedirect("borrow.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		String issueDate = request.getParameter("issueDate");
		String returnDate = request.getParameter("returnDate");
		String dueDate = request.getParameter("dueDate");

		BorrowD obj = new BorrowD();
		obj.setBookId(bookId);
		obj.setMemberId(memberId);
		obj.setIssueDate(java.sql.Date.valueOf(issueDate));
		obj.setReturnDate(java.sql.Date.valueOf(returnDate));
		obj.setDueDate(java.sql.Date.valueOf(dueDate));

		BorrowDDao dao = new BorrowDDao();
		dao.addBorrow(obj); //calling Dao method for adding borrow request

		doGet(request, response);
	}

}
