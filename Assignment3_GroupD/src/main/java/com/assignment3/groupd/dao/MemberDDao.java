package com.assignment3.groupd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
 * This class has methods to register,show update and delete the members from the database
 */
public class MemberDDao {

	//This method is used to register  using member table
	public void RegisterMember(MemberD obj) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "insert into member (Name, Address, Memb_type, Memb_date, Expiry_date) values (?, ?, ?, ?, ?);";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getName());
			st.setString(2, obj.getAddress());
			st.setString(3, obj.getType());
			st.setDate(4, obj.getJoin_date());
			st.setDate(5, obj.getExpire());

			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//This method is used to display the mebers from the member table
	public ArrayList<MemberD> ShowMember() {
		ArrayList<MemberD> members = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "select * from member;";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				MemberD obj = new MemberD();
				obj.setName(rs.getString("Name"));
				obj.setAddress(rs.getString("Address"));
				obj.setType(rs.getString("Memb_type"));
				obj.setJoin_date(rs.getDate("Memb_date"));
				obj.setExpire(rs.getDate("Expiry_date"));
				obj.setMember_id(rs.getInt("Memb_id"));
				members.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return members;
	}

	//This method is used to update the members in the member table
	public void UpdateMember(MemberD obj) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "manpreet")) {
			String sql = "update member set Name = ?, Address = ?, Memb_type = ?, Memb_date = ?, Expiry_date = ? where memb_id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getName());
			st.setString(2, obj.getAddress());
			st.setString(3, obj.getType());
			st.setDate(4, obj.getJoin_date());
			st.setDate(5, obj.getExpire());
			st.setInt(6, obj.getMember_id());

			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
