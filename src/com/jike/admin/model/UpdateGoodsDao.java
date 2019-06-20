package com.jike.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jike.Utils.JdbcUtil;
import com.jike.admin.pojo.Goods;

public class UpdateGoodsDao {

	public int updatedao(Goods good) {

		try {

			Connection conn = JdbcUtil.getInstace().getConn();
			String sql = "update goods set title = ?, oldMoney = ?,money = ? , goodNumber = ? , goodIntroduction = ? , "
					+ "sellNumber =? , images = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, good.getTitle());
			ps.setString(2, good.getOldMoney());
			ps.setString(3, good.getMoney());
			ps.setString(4, good.getGoodNumber());
			ps.setString(5, good.getGoodIntroduction());
			ps.setString(6, good.getSellNumber());
			ps.setString(7, good.getImages());
			ps.setInt(8, good.getId());
			int res = ps.executeUpdate();
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
