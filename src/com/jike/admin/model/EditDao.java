package com.jike.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.admin.pojo.Goods;

public class EditDao {

	
	public Goods editdao(String good_id){
		
		Goods good;
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql = "select * from goods where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, good_id);
			
			ResultSet res = ps.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String title = res.getString("title");
				String oldMoney = res.getString("oldMoney");
				String money = res.getString("money");
				String goodNumber = res.getString("goodNumber");
				String goodIntroduction = res.getString("goodIntroduction");
				String sellNumber = res.getString("sellNumber");
				String images = res.getString("images");
				good = new Goods();
				
				good.setId(id);
				good.setTitle(title);
				good.setOldMoney(oldMoney);
				good.setMoney(money);
				good.setGoodNumber(goodNumber);
				good.setGoodIntroduction(goodIntroduction);
				good.setSellNumber(sellNumber);
				good.setImages(images);
				return good;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
