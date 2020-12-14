package www.novel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import www.novel.entity.Novel;
import www.novel.entity.NovelChapter;
import www.novel.util.DbHelp;

public class NovelChapterDao {
	private Connection conn = null;
	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Novel novel = null;
	private NovelChapter novelChapter = null;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Date d = new Date();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public NovelChapterDao() {

		conn = DbHelp.getConnection();
	}

	/*
	 * public void addChapter(NovelChapter novelChapter) {
	 * System.out.println(novelChapter.getChapterName()); if
	 * (novelChapter.getChapterId() == null) {
	 * BeetlSQLUtil.getSQLManager().insert(novelChapter); } else {
	 * novelChapter.setChapterId((new Long(novelChapter.getChapterId())));
	 * BeetlSQLUtil.getSQLManager().updateById(novelChapter); } }
	 */
	/**
	 * ����,���� ��װ�������ݵķ���
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

	/**
	 * �½��б�
	 * 
	 * @param novelId
	 *            С˵ID
	 * @return
	 */
	public ArrayList<Novel> getChapters(String novelId) {
		ArrayList<Novel> list = new ArrayList<Novel>();
		sql = "SELECT\r\n" + "*\r\n" + "FROM\r\n" + "tb_novel_base_info\r\n"
				+ "INNER JOIN tb_novle_chapter_info ON tb_novle_chapter_info.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "tb_novel_base_info.novel_id = '" + novelId + "'";
		System.out.println(sql);
		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				novel = new Novel();
				novelChapter = new NovelChapter();
				novel.setNovelId(rs.getLong("novel_id"));
				novel.setNovelName(rs.getString("novel_name"));
				novel.setNovelDesc((rs.getString("novel_desc")));
				novel.setNovelAuthor((rs.getString("novel_author")));
				novel.setNovelClassify((rs.getString("novel_classify")));
				novel.setNovelState((rs.getString("novel_state")));
				novelChapter.setChapterId(rs.getLong("novle_chapter_id"));
				novelChapter.setChapterName(rs.getString("novle_chapter_name"));
				try {
					d = formatter.parse(rs.getString("novle_chapter_datetime"));
					novelChapter.setChapterDateTime(format.format(d));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				novel.setNovelChapter(novelChapter);
				list.add(novel);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * С˵��������
	 * 
	 * @param novle_chapter_id
	 *            �½�ID
	 * @return
	 */
	public NovelChapter chapterdetail(String novle_chapter_id) {
		sql = "SELECT\r\n" + "tb_novle_chapter_info.novle_chapter_id,\r\n" + "tb_novle_chapter_info.novel_id,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_name,\r\n" + "tb_novle_chapter_info.novle_chapter_contend,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_wordcount,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_datetime,\r\n"
				+ "tb_novle_chapter_info.`novle_chapter_ state`\r\n" + "FROM\r\n" + "tb_novle_chapter_info\r\n"
				+ "INNER JOIN tb_novel_base_info ON tb_novle_chapter_info.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "tb_novle_chapter_info.novle_chapter_id = '" + novle_chapter_id + "'";
		System.out.println("С˵��������:" + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				novelChapter = new NovelChapter();
				novelChapter.setChapterId(rs.getLong("novle_chapter_id"));
				novelChapter.setChapterName(rs.getString("novle_chapter_name"));
				novelChapter.setChapterContent(rs.getString("novle_chapter_contend"));
				try {
					d = formatter.parse(rs.getString("novle_chapter_datetime"));
					novelChapter.setChapterDateTime(format.format(d));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return novelChapter;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	/**
	 * ͨ��С˵ID��ѯ�����½ڣ�����һ������
	 * 
	 * @param novelId
	 *            �½�ID
	 * @return
	 */
	public NovelChapter getChaptersById(String novelId) {
		sql = "SELECT\r\n" + "*\r\n" + "FROM\r\n" + "tb_novle_chapter_info\r\n" + "WHERE\r\n"
				+ "tb_novle_chapter_info.novel_id='" + novelId + "'\r\n" + "GROUP BY\r\n"
				+ "tb_novle_chapter_info.novle_chapter_datetime\r\n" ;
		System.out.println("�����½�:" + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				novelChapter = new NovelChapter();
				novelChapter.setChapterId(rs.getLong("novle_chapter_id"));
				novelChapter.setChapterName(rs.getString("novle_chapter_name"));
				novelChapter.setChapterContent(rs.getString("novle_chapter_contend"));
				try {
					d = formatter.parse(rs.getString("novle_chapter_datetime"));
					novelChapter.setChapterDateTime(format.format(d));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return novelChapter;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	/**
	 * ��һ��
	 * 
	 * @param novle_chapter_id
	 *            �½�ID
	 * @param novelId
	 *            С˵ID
	 * @return
	 */
	public NovelChapter Previous(String novle_chapter_id, String novelId) {
		sql = "SELECT\r\n" + "tb_novle_chapter_info.novle_chapter_id,\r\n" + "tb_novle_chapter_info.novel_id,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_name,\r\n" + "tb_novle_chapter_info.novle_chapter_contend,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_wordcount,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_datetime,\r\n"
				+ "tb_novle_chapter_info.`novle_chapter_ state`\r\n" + "FROM\r\n" + "tb_novle_chapter_info\r\n"
				+ "INNER JOIN tb_novel_base_info ON tb_novle_chapter_info.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "tb_novle_chapter_info.novle_chapter_id < '" + novle_chapter_id + "' AND\r\n"
				+ "tb_novle_chapter_info.novel_id = '" + novelId + "'" + "ORDER BY\r\n" + "	novle_chapter_id DESC\r\n"
				+ "limit 1";
		System.out.println("С˵��һ��:" + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				novelChapter = new NovelChapter();
				novelChapter.setChapterId(rs.getLong("novle_chapter_id"));
				novelChapter.setChapterName(rs.getString("novle_chapter_name"));
				novelChapter.setChapterContent(rs.getString("novle_chapter_contend"));
				try {
					d = formatter.parse(rs.getString("novle_chapter_datetime"));
					novelChapter.setChapterDateTime(format.format(d));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return novelChapter;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	/**
	 * ��һ��
	 * 
	 * @param novle_chapter_id
	 *            �½�ID
	 * @param novelId
	 *            С˵ID
	 * @return
	 */
	public NovelChapter next(String novle_chapter_id, String novelId) {
		sql = "SELECT\r\n" + "tb_novle_chapter_info.novle_chapter_id,\r\n" + "tb_novle_chapter_info.novel_id,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_name,\r\n" + "tb_novle_chapter_info.novle_chapter_contend,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_wordcount,\r\n"
				+ "tb_novle_chapter_info.novle_chapter_datetime,\r\n"
				+ "tb_novle_chapter_info.`novle_chapter_ state`\r\n" + "FROM\r\n" + "tb_novle_chapter_info\r\n"
				+ "INNER JOIN tb_novel_base_info ON tb_novle_chapter_info.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "tb_novle_chapter_info.novle_chapter_id > '" + novle_chapter_id + "' AND\r\n"
				+ "tb_novle_chapter_info.novel_id = '" + novelId + "'" + "ORDER BY\r\n" + "	novle_chapter_id\r\n"
				+ "LIMIT 1";
		System.out.println("С˵��һ��:" + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				novelChapter = new NovelChapter();
				novelChapter.setChapterId(rs.getLong("novle_chapter_id"));
				novelChapter.setChapterName(rs.getString("novle_chapter_name"));
				novelChapter.setChapterContent(rs.getString("novle_chapter_contend"));
				try {
					// ��ʽ��ʱ��
					d = formatter.parse(rs.getString("novle_chapter_datetime"));
					novelChapter.setChapterDateTime(format.format(d));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return novelChapter;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
