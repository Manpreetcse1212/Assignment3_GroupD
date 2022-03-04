package com.assignment3.groupd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment3.groupd.dao.MemberDDao;
import com.assignment3.groupd.model.MemberD;

/**
 * Date: 23.02.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This servlet is used to handle post and get methods for creating, updating  members
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
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

		MemberDDao dao = new MemberDDao(); //instance of MemberDDao
		ArrayList<MemberD> members = dao.ShowMember();
		HttpSession session = request.getSession();
		session.setAttribute("members", members);

		response.sendRedirect("member.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action.equals("insert")) { //handling member insertion
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String type = request.getParameter("type");
			String joinDate = request.getParameter("join-date");
			String expireDate = request.getParameter("expire-date");

			MemberD obj = new MemberD();
			obj.setName(name);
			obj.setAddress(address);
			obj.setType(type);
			obj.setJoin_date(java.sql.Date.valueOf(joinDate));
			obj.setExpire(java.sql.Date.valueOf(expireDate));

			MemberDDao dao = new MemberDDao();
			dao.RegisterMember(obj);
		} else {  
			String id = request.getParameter("member-id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String type = request.getParameter("type");
			String joinDate = request.getParameter("join-date");
			String expireDate = request.getParameter("expire-date");

			MemberD obj = new MemberD();
			obj.setMember_id(Integer.parseInt(id));
			obj.setName(name);
			obj.setAddress(address);
			obj.setType(type);
			obj.setJoin_date(java.sql.Date.valueOf(joinDate));
			obj.setExpire(java.sql.Date.valueOf(expireDate));

			MemberDDao dao = new MemberDDao();
			dao.UpdateMember(obj);
		}

		doGet(request, response);
	}

}
