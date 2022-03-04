/**
 * 
 */
package com.assignment3.groupd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
 * This class is having methods for addBorrow and showBorrow to add to the borrowlist and to display the borrow list
 */
public class BorrowDDao {
	//This method is to add Borrow to borrow table
	public void addBorrow(BorrowD obj) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "insert into borrow (borrow_book_id, borrow_member_id, Due_date, issue_date, Return_date) values (?, ?, ?, ?, ?);";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, obj.getBookId());
			st.setInt(2, obj.getMemberId());
			st.setDate(3, obj.getDueDate());
			st.setDate(4, obj.getIssueDate());
			st.setDate(5, obj.getReturnDate());

			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//This method is to display Borrow from ShowBorrow table
	public ArrayList<BorrowD> ShowBorrow() {
		ArrayList<BorrowD> borrows = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "select * from borrow;";

			PreparedStatement stBook = null;
			ResultSet rsBook = null;

			PreparedStatement stMember = null;
			ResultSet rsMember = null;

			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				BorrowD obj = new BorrowD();
				obj.setBookId(rs.getInt("borrow_book_id"));
				obj.setMemberId(rs.getInt("borrow_member_id"));

				sql = "select title from book where book_id = ?";
				stBook = con.prepareStatement(sql);
				stBook.setInt(1, obj.getBookId());

				rsBook = stBook.executeQuery();

				if (rsBook.next()) {
					obj.setBookName(rsBook.getString("title"));
				}

				sql = "select name from member where memb_id = ?";
				stMember = con.prepareStatement(sql);
				stMember.setInt(1, obj.getMemberId());

				rsMember = stMember.executeQuery();

				if (rsMember.next()) {
					obj.setMemberName(rsMember.getString("name"));
				}

				obj.setIssueDate(rs.getDate("issue_date"));
				obj.setReturnDate(rs.getDate("Return_date"));
				obj.setDueDate(rs.getDate("Due_date"));
				borrows.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return borrows;
	}
}
