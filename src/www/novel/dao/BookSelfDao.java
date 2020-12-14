package www.novel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import www.novel.entity.Novel;
import www.novel.util.DbHelp;

public class BookSelfDao {

	private Connection conn = null;
	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Novel novel = null;

	public BookSelfDao() {
		// TODO Auto-generated constructor stub
		super();
		conn = DbHelp.getConnection();
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
