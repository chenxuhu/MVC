package com.jike.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.admin.pojo.Admin;

public class AdminRegisterDao {

	
	public int adminRegister(Admin admin){
		
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql = "insert into admin(user_name,account,user_password,user_phone) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, admin.getUser_name());
			ps.setString(2, admin.getAccount());
			ps.setString(3, admin.getUser_password());
			ps.setString(4, admin.getUser_phone());
			int res = ps.executeUpdate();
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
