/**
 * 
 */
package com.assignment3.groupd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
 * This class is having methods to issue books, show books, update books and delete books
 * 
 */
public class BookDDao {

	//This method is inserting the records of issuing books to the book table
	public void IssueBook(BookD obj) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")){// id : root and password:manpreet {
			String sql = "insert into book (Title, Author, Available, Price, Pub_id) values (?, ?, ?, ?, ?);"; 
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getTitle());
			st.setString(2, obj.getAuthor());
			st.setString(3, obj.getAvailable());
			st.setDouble(4, obj.getPrice());
			st.setInt(5, obj.getPubId());

			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//ShowBooks method displays the books from book table
	public ArrayList<BookD> ShowBooks() {
		ArrayList<BookD> books = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "select * from book;";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				BookD obj = new BookD();
				obj.setBookId(rs.getInt("Book_id"));
				obj.setTitle(rs.getString("Title"));
				obj.setAuthor(rs.getString("Author"));
				obj.setAvailable(rs.getString("Available"));
				obj.setPrice(rs.getDouble("Price"));
				obj.setPubId(rs.getInt("Pub_id"));
				books.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return books;
	}

	//updateBook method updates the books from book table
	public void UpdateBook(BookD obj) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {

			String sql = "update book set Title = ?, Author = ?, Available = ?, Price = ?, Pub_id = ? where Book_id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getTitle());
			st.setString(2, obj.getAuthor());
			st.setString(3, obj.getAvailable());
			st.setDouble(4, obj.getPrice());
			st.setInt(5, obj.getPubId());
			st.setInt(6, obj.getBookId());

			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//DeleteBook method deletes the books from book table
	public void DeleteBook(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {

			String constraintSQL = "delete from borrow where borrow_book_id = ?";
			PreparedStatement constSt = con.prepareStatement(constraintSQL);
			constSt.setInt(1, id);
			constSt.executeUpdate();

			String sql = "delete from book where Book_id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
