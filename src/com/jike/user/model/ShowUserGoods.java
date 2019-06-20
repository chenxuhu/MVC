package com.jike.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jike.Utils.JdbcUtil;
import com.jike.user.pojo.Goods;

public class ShowUserGoods {

	public List<Goods> showgood() {

		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql = "select * from goods";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet res = ps.executeQuery();
			List<Goods> list = new ArrayList<Goods>();
			while (res.next()) {
				int id = res.getInt("id");
				String title = res.getString("title");
				String oldMoney = res.getString("oldMoney");
				String money = res.getString("money");
				String goodNumber = res.getString("goodNumber");
				String goodIntroduction = res.getString("goodIntroduction");
				String sellNumber = res.getString("sellNumber");
				String images = res.getString("images");
				Goods good = new Goods();
				good.setId(id);
				good.setTitle(title);
				good.setOldMoney(oldMoney);
				good.setMoney(money);
				good.setGoodNumber(goodNumber);
				good.setGoodIntroduction(goodIntroduction);
				good.setSellNumber(sellNumber);
				good.setImages(images);
				list.add(good);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
