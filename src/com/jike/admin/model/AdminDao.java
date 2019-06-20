package com.jike.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.admin.pojo.Admin;

public class AdminDao {

	public boolean adminDao(Admin user) {

		
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql = "select * from admin where user_name =? and user_password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_password());
			
			
			ResultSet res = ps.executeQuery();
			return res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}