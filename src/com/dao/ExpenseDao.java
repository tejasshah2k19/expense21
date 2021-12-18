package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.ExpenseBean;
import com.util.DbConnection;

public class ExpenseDao {

	public void addExpense(ExpenseBean expenseBean) {
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into expense (categoryid,subcategoryid,title,amount,expensedate,userid) values (?,?,?,?,?,?)");) {

			pstmt.setInt(1, expenseBean.getCategoryId());
			pstmt.setInt(2, expenseBean.getSubCategoryId());
			pstmt.setString(3, expenseBean.getTitle());
			pstmt.setInt(4, expenseBean.getAmount());
			pstmt.setString(5, expenseBean.getExpenseDate());
			pstmt.setInt(6, expenseBean.getUserId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("someting went wrong --- creating expense............");
			e.printStackTrace();
		}

	}
}
