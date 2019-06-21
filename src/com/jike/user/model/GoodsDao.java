package com.jike.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.user.pojo.Goods;

public class GoodsDao {

public Goods selectGoodss(String id){
		
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql="select * from goods where goodNumber=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			System.out.println("112325346");
			while(rs.next()){
			Goods goods=new Goods();
			goods.setId(rs.getInt("id"));
			goods.setTitle(rs.getString("title"));
			goods.setOldMoney(rs.getString("oldMoney"));
			goods.setMoney(rs.getString("money"));
			goods.setGoodNumber(rs.getString("goodNumber"));
			goods.setGoodIntroduction(rs.getString("goodIntroduction"));
			goods.setSellNumber(rs.getString("sellNumber"));
			goods.setImages(rs.getString("images"));
			
			return goods;
			}
			
		} catch (SQLException e) {
			System.out.println("GoodsDao错误");
		}
		return null;
	}
}
