package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.CategoryBean;
import com.util.DbConnection;

public class CategoryDao {


	public ArrayList<CategoryBean> getAllCategories(){
		
		ArrayList<CategoryBean> categories = new ArrayList<>();

		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from category");) {

			ResultSet rs = pstmt.executeQuery();// id fn em pass

			while (rs.next()) {

				CategoryBean cb = new CategoryBean();
				cb.setCategoryId(rs.getInt("categoryid"));
				cb.setCategoryName(rs.getString("categoryname"));
				
				categories.add(cb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return categories;
	}
}
