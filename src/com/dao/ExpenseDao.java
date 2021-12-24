package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	public ArrayList<ExpenseBean> getAllExpense(int userId) {

		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select *,c.categoryname from expense e ,category c where e.userid = ? and e.categoryid = c.categoryid");) {

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			ArrayList<ExpenseBean> exp = new ArrayList<>();
			while (rs.next()) {

				ExpenseBean eb = new ExpenseBean();
				eb.setExpenseId(rs.getInt("expenseid"));
				eb.setAmount(rs.getInt("amount"));
				eb.setCategoryId(rs.getInt("categoryid"));
				eb.setCategoryName(rs.getString("categoryname"));
				exp.add(eb);
			}

			return exp;
		} catch (Exception e) {
			System.out.println("someting went wrong --- creating expense............");
			e.printStackTrace();
		}

		return null;

	}

}
