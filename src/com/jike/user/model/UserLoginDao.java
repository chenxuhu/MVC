package com.jike.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.user.pojo.User;

public class UserLoginDao {

	
	public boolean UserDao(User user){
		
		
		try {
			
			Connection conn = JdbcUtil.getInstace().getConn();
			
			String sql = "select * from user where account = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,user.getAccount() );
			ps.setString(2, user.getPassword());
			
			ResultSet res = ps.executeQuery();
			
			return res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
