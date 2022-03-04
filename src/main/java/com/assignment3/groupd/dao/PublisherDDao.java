/**
 * 
 */
package com.assignment3.groupd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.assignment3.groupd.model.PublisherD;

/**
 * Date: 23.02.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This class has methods for adding, updating and show publisher
 */
public class PublisherDDao {

	//This method is used to add Publisherin publisher table
	public void AddPublisher(PublisherD obj) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "insert into publisher (Name, Address) values (?, ?);";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getName());
			st.setString(2, obj.getAddress());

			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//This method is used to update publisher in the publisher table
	public void UpdatePublisher(PublisherD obj) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "update publisher set Name = ?, Address = ? where Pub_id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getName());
			st.setString(2, obj.getAddress());
			st.setInt(3, obj.getId());

			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//This method is used to display the publishers from publisher table
	public ArrayList<PublisherD> ShowPublishers() {
		ArrayList<PublisherD> publishers = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "select * from publisher;";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				PublisherD obj = new PublisherD();
				obj.setName(rs.getString("Name"));
				obj.setAddress(rs.getString("Address"));
				obj.setId(rs.getInt("pub_id"));
				publishers.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return publishers;
	}

}
