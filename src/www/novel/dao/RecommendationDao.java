package www.novel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import www.novel.entity.Novel;
import www.novel.util.DbHelp;

public class RecommendationDao {
	private Connection conn = null;
	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Novel novel = null;

	public RecommendationDao() {
		super();
		conn = DbHelp.getConnection();
	}

	public int getAllRecoNumer(String novelId) {
		String sql = "SELECT\r\n" + "tb_recommendation.novel_recommendation_count\r\n" + "FROM\r\n"
				+ "tb_recommendation\r\n" + "WHERE\r\n" + "tb_recommendation.novel_id = '" + novelId + "'";
		System.out.println(sql);
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt("novel_recommendation_count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int getRecoNumerByweek() {
		String sql = "SELECT\r\n" + "	tb_recommendation.novel_recommendation_count\r\n" + "FROM\r\n"
				+ "	tb_recommendation\r\n"
				+ "INNER JOIN tb_novel_base_info ON tb_recommendation.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "	YEARWEEK(\r\n" + "		date_format(\r\n"
				+ "			novel_recommendation_count,\r\n" + "			'%Y-%m-%d'\r\n" + "		)\r\n"
				+ "	) = YEARWEEK(now())";
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt("novel_recommendation_count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int getRecoNumerByMonth() {
		String sql = "SELECT\r\n" + "	tb_recommendation.novel_recommendation_count\r\n" + "FROM\r\n"
				+ "	tb_recommendation\r\n"
				+ "INNER JOIN tb_novel_base_info ON tb_recommendation.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "	DATE_FORMAT(\r\n" + "		novel_recommendation_date,\r\n" + "		'%Y%m'\r\n"
				+ "	) = DATE_FORMAT(CURDATE(), '%Y%m')";
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt("novel_recommendation_count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 插入,更新 封装更新数据的方法
	 * 
	 * @param sql
	 * @return
	 */
	public boolean executeUpdate(String sql) {
		System.out.println(" SQL : " + sql);
		int i;
		try {
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
			if (i == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} // End try
		return false;
	}
}
