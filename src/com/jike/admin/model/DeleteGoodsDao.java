package com.jike.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.admin.pojo.Goods;

public class DeleteGoodsDao {

	public int deletegoods(String id){
		
		
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			
			String sql = "delete from goods where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			int res = ps.executeUpdate();
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
