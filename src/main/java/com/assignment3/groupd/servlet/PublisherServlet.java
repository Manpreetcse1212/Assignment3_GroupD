package com.assignment3.groupd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment3.groupd.dao.PublisherDDao;
import com.assignment3.groupd.model.PublisherD;

/**
 /**
 * Date: 23.02.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This servlet is used to handle post and get methods for creating, updating publisher
 */
@WebServlet("/PublisherServlet")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublisherServlet() {
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
		PublisherDDao dao = new PublisherDDao(); //instance of PublisherDDao
		ArrayList<PublisherD> publishers = dao.ShowPublishers();
		HttpSession session = request.getSession();
		session.setAttribute("publishers", publishers);

		response.sendRedirect("publisher.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action.equals("insert")) { //handling publisher insertion
			String name = request.getParameter("name");
			String address = request.getParameter("address");

			PublisherD obj = new PublisherD();
			obj.setName(name);
			obj.setAddress(address);

			PublisherDDao dao = new PublisherDDao();
			dao.AddPublisher(obj);
		} else {
			String id = request.getParameter("pub-id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");

			PublisherD obj = new PublisherD();
			obj.setId(Integer.parseInt(id));
			obj.setName(name);
			obj.setAddress(address);

			PublisherDDao dao = new PublisherDDao();
			dao.UpdatePublisher(obj);
		}

		doGet(request, response);
	}

}
