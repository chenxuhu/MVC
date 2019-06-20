package com.jike.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.admin.pojo.Goods;

public class AddGoodsDao {

	public int addGoods(Goods goods){
		
		
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql = "insert into goods(title,oldMoney,money,goodNumber,goodIntroduction,sellNumber,images) "
					+ "values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getTitle());
			ps.setString(2, goods.getOldMoney());
			ps.setString(3, goods.getMoney());
			ps.setString(4, goods.getGoodNumber());
			ps.setString(5, goods.getGoodIntroduction());
			ps.setString(6, goods.getSellNumber());
			ps.setString(7, goods.getImages());
			
			int res = ps.executeUpdate();
			
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
