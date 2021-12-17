package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.SubCategoryBean;
import com.util.DbConnection;

public class SubCategoryDao {

	public ArrayList<SubCategoryBean> getAllSubCatByCategoryId(int categoryId)

	{
		ArrayList<SubCategoryBean> subCategories = new ArrayList<>();

		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from subcategory where categoryid = ? ");) {
			pstmt.setInt(1, categoryId);

			ResultSet rs = pstmt.executeQuery();// id fn em pass

			while (rs.next()) {

				SubCategoryBean sb = new SubCategoryBean();

				sb.setCategoryId(categoryId);
				sb.setSubCategoryId(rs.getInt("subcategoryid"));
				sb.setSubCategoryName(rs.getString("subcategoryname"));
				subCategories.add(sb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return subCategories;
	}
}
