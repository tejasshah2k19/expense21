package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<>();

		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users");) {

			ResultSet rs = pstmt.executeQuery();// id fn em pass

			while (rs.next()) {
				UserBean user = new UserBean();

				user.setUserId(rs.getInt("userid"));// userId column -> table ==>db
				user.setFirstName(rs.getString("firstname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getInt("role"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	public void insertUser(UserBean user) {

		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into users (firstname,email,password,role) values (?,?,?,?)");) {
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, 1);// 1 = user

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean authenticate(String email, String password) {
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select * from users where email = ? and password = ?");) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				UserBean user = new UserBean();
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("firstname"));
				user.setPassword(rs.getString("password"));
				user.setUserId(rs.getInt("userid"));
				user.setRole(rs.getInt("role"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
