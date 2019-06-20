package com.jike.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.user.pojo.User;

public class UserRegisterDao {

	
	public int userDao(User user){
		
		
		try {
			
			Connection conn = JdbcUtil.getInstace().getConn();
			
			String sql = "insert into user(account,password,email) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			
			int res = ps.executeUpdate();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
