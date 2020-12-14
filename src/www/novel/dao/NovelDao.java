package www.novel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import www.novel.entity.Novel;
import www.novel.entity.NovelChapter;
import www.novel.entity.Recommendation;
import www.novel.util.DbHelp;

public class NovelDao {
	private Connection conn = null;
	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Novel novel = null;
	private NovelChapter novelChapter = null;
	private Recommendation recommendation = null;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Date d = new Date();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public NovelDao() {
		super();
		conn = DbHelp.getConnection();
	}

	public List<Novel> getUpdateArticle() {
		return null;

	}

	/**
	 * 小说排行榜
	 * 
	 * @return
	 * @throws ParseException
	 */
	public ArrayList<Novel> getNovels() {
		ArrayList<Novel> list = new ArrayList<Novel>();
		sql = "SELECT\r\n" + "tb_novel_base_info.novel_id,\r\n" + "tb_novel_base_info.novel_name,\r\n"
				+ "tb_novel_base_info.novel_desc,\r\n" + "tb_novel_base_info.novel_author,\r\n"
				+ "tb_novel_base_info.novel_classify,\r\n" + "tb_novel_base_info.novel_state,\r\n"
				+ "tb_novel_base_info.novel_image\r\n" + "FROM\r\n" + "tb_novel_base_info\r\n" + "ORDER BY\r\n"
				+ "tb_novel_base_info.novel_id DESC\r\n" + "LIMIT 0, 6\r\n" + "";
		System.out.println("小说排行榜\n" + sql);
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
				novel.setNovelImage(rs.getString("novel_image"));
				/*
				 * novelChapter.setChapterName(rs.getString("novle_chapter_name")); try {
				 * d=formatter.parse(rs.getString("novle_chapter_datetime"));
				 * novelChapter.setChapterDateTime(format.format(d)); } catch (ParseException e)
				 * { // TODO Auto-generated catch block e.printStackTrace(); }
				 * 
				 * novel.setNovelChapter(novelChapter);
				 */
				list.add(novel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 最近更新列表
	 * 
	 * @return
	 * @throws ParseException
	 */
	public ArrayList<Novel> getrecentUpdates() {
		ArrayList<Novel> list = new ArrayList<Novel>();
		sql = "SELECT DISTINCT\r\n" + "tb_novel_base_info.novel_id,\r\n" + "tb_novel_base_info.novel_name,\r\n"
				+ "tb_novel_base_info.novel_desc,\r\n" + "tb_novel_base_info.novel_author,\r\n"
				+ "tb_novel_base_info.novel_classify,\r\n" + "tb_novel_base_info.novel_state,\r\n"
				+ "tb_novel_base_info.novel_image\r\n" + "FROM\r\n" + "	tb_novel_base_info\r\n"
				+ "INNER JOIN tb_novle_chapter_info ON tb_novle_chapter_info.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "ORDER BY novle_chapter_datetime DESC ";
		System.out.println("最近更新列表\n" + sql);
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
				novel.setNovelImage(rs.getString("novel_image"));
				/*
				 * novelChapter.setChapterName(rs.getString("novle_chapter_name")); try {
				 * d=formatter.parse(rs.getString("novle_chapter_datetime"));
				 * novelChapter.setChapterDateTime(format.format(d)); } catch (ParseException e)
				 * { // TODO Auto-generated catch block e.printStackTrace(); }
				 * 
				 * novel.setNovelChapter(novelChapter);
				 */
				list.add(novel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 总推荐榜列表
	 * 
	 * @return
	 */
	public ArrayList<Novel> getRecommendationList() {
		ArrayList<Novel> list = new ArrayList<Novel>();

		sql = "SELECT DISTINCT\r\n *"
				+ "FROM\r\n" + "	tb_novel_base_info\r\n"
				+ "INNER JOIN tb_recommendation ON tb_recommendation.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "GROUP BY\r\n" + "	tb_recommendation.novel_recommendation_count \r\n" + "DESC\r\n" + "LIMIT 0,\r\n"
				+ " 15";
		System.out.println("总推荐榜列表\n" + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				novel = new Novel();
				recommendation = new Recommendation();
				novel.setNovelId(rs.getLong("novel_id"));
				novel.setNovelName(rs.getString("novel_name"));
				novel.setNovelDesc((rs.getString("novel_desc")));
				novel.setNovelAuthor((rs.getString("novel_author")));
				novel.setNovelClassify((rs.getString("novel_classify")));
				novel.setNovelState((rs.getString("novel_state")));
				novel.setNovelImage(rs.getString("novel_image"));
				recommendation.setRecommendationNovelCount(rs.getLong("novel_recommendation_count"));
				novel.setRecommendation(recommendation);
				list.add(novel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 最新小说列表
	 * 
	 * @return
	 */
	public ArrayList<Novel> getlatestNovelList() {
		ArrayList<Novel> list = new ArrayList<Novel>();
		sql = "SELECT DISTINCT\r\n" + "*\r\n" + "FROM\r\n" + "tb_novel_base_info\r\n" + "ORDER BY\r\n"
				+ "tb_novel_base_info.novel_id DESC";
		System.out.println("最新小说列表" + sql);
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
				novel.setNovelImage(rs.getString("novel_image"));
				/*
				 * novelChapter.setChapterName(rs.getString("novle_chapter_name")); try {
				 * d=formatter.parse(rs.getString("novle_chapter_datetime"));
				 * novelChapter.setChapterDateTime(format.format(d)); } catch (ParseException e)
				 * { // TODO Auto-generated catch block e.printStackTrace(); }
				 * novel.setNovelChapter(novelChapter);
				 */
				list.add(novel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 小说分类 {@code if (type.equals("xhmf")) { t = "玄幻魔法"; }}
	 * 
	 * @param type
	 * @return
	 */
	public static String type(String type) {
		String t = "";
		if (type.equals("xhmf")) {
			t = "玄幻魔法";
		}
		if (type.equals("xhxz")) {
			t = "武侠修真";
		}
		if (type.equals("dsyq")) {
			t = "都市言情";
		}
		if (type.equals("lsjs")) {
			t = "历史军事";
		}
		if (type.equals("wyjj")) {
			t = "网游竞技";
		}
		if (type.equals("khxs")) {
			t = "科幻小说";
		}
		if (type.equals("kbly")) {
			t = "恐怖灵异";
		}
		if (type.equals("nsxs")) {
			t = "女生小说";
		}
		if (type.equals("qtxs")) {
			t = "其他小说";
		}
		if (type.equals("qbxs")) {
			t = "全本小说";
		}
		if (type.equals("tjxs")) {
			t = "tjxs";
		}

		return t;
	}

	/**
	 * 分类小说列表
	 * 
	 * @return
	 */
	public ArrayList<Novel> getTypeNovelList(String type) {
		String novelType = type; // type(type);
		System.out.println(novelType);
		ArrayList<Novel> list = new ArrayList<Novel>();
		if (type.equals("zjgx") || type.equals("zxxs")) {
			sql = "SELECT DISTINCT\r\n" + "tb_novel_base_info.novel_name,\r\n" + "tb_novel_base_info.novel_id,\r\n"
					+ "tb_novel_base_info.novel_desc,\r\n" + "tb_novel_base_info.novel_author,\r\n"
					+ "tb_novel_base_info.novel_classify,\r\n" + "tb_novel_base_info.novel_state,\r\n"
					+ "tb_novel_base_info.novel_image\r\n" + "FROM\r\n" + "tb_novel_base_info\r\n" + "ORDER BY\r\n"
					+ "tb_novel_base_info.novel_id DESC";
			System.out.println("分类小说列表" + sql);
		} else if (novelType.equals("tjxs")) {
			// 推荐小说榜
			sql = "SELECT DISTINCT\r\n" + "*\r\n" + "FROM\r\n" + "tb_novel_base_info\r\n"
					+ "INNER JOIN tb_recommendation ON tb_recommendation.novel_id = tb_novel_base_info.novel_id\r\n"
					+ "INNER JOIN tb_novle_chapter_info ON tb_novle_chapter_info.novel_id = tb_novel_base_info.novel_id\r\n"
					+ "GROUP BY\r\n" + "	tb_recommendation.novel_recommendation_count\r\n" + "DESC";
			System.out.println("分类小说列表" + sql);
		} else {
			sql = "SELECT DISTINCT\r\n" + "tb_novel_base_info.novel_id,\r\n" + "tb_novel_base_info.novel_name,\r\n"
					+ "tb_novel_base_info.novel_desc,\r\n" + "tb_novel_base_info.novel_author,\r\n"
					+ "tb_novel_base_info.novel_classify,\r\n" + "tb_novel_base_info.novel_state,\r\n"
					+ "tb_novel_base_info.novel_image\r\n" + "FROM\r\n" + "	tb_novel_base_info\r\n"
					+ "INNER JOIN tb_novle_chapter_info ON tb_novle_chapter_info.novel_id = tb_novel_base_info.novel_id\r\n"
					+ "WHERE\r\n" + "	tb_novel_base_info.novel_classify = '" + novelType + "'\r\n" + "ORDER BY\r\n"
					+ "	tb_novle_chapter_info.novle_chapter_datetime DESC";
			System.out.println("分类小说列表" + sql);
		}
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
				novel.setNovelImage(rs.getString("novel_image"));
				/*
				 * novelChapter.setChapterName(rs.getString("chaptername"));
				 * novelChapter.setChapterWordCount(rs.getString("novle_chapter_wordcount"));
				 * try { d=formatter.parse(rs.getString("novle_chapter_datetime"));
				 * novelChapter.setChapterDateTime(format.format(d)); } catch (ParseException e)
				 * { // TODO Auto-generated catch block e.printStackTrace(); }
				 * novel.setNovelChapter(novelChapter);
				 */
				list.add(novel);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 我的书架小说列表
	 * 
	 * @return
	 */
	public ArrayList<Novel> getMyBookSelfList(String readerId) {

		ArrayList<Novel> list = new ArrayList<Novel>();
		sql = "SELECT \r\n" + "*\r\n" + "FROM\r\n" + "tb_bookshelf\r\n"
				+ "INNER JOIN tb_novel_base_info ON tb_bookshelf.novel_id = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "tb_bookshelf.reader_id = '" + readerId + "'\r\n" + "";
		System.out.println("我的书架小说列表\n" + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				novel = new Novel();
				novelChapter = new NovelChapter();
				novel.setNovelId(rs.getLong("novel_id"));
				System.out.println(rs.getString("novel_name"));
				novel.setNovelName(rs.getString("novel_name"));
				// novel.setNovelDesc((rs.getString("novel_desc")));
				novel.setNovelAuthor((rs.getString("novel_author")));
				novel.setNovelClassify((rs.getString("novel_classify")));
				// novel.setNovelState((rs.getString("novel_state")));
				// novelChapter.setChapterName(rs.getString("novle_chapter_name"));
				// novelChapter.setChapterWordCount(rs.getString("novle_chapter_wordcount"));
				/*
				 * try { d = formatter.parse(rs.getString("novle_chapter_datetime"));
				 * novelChapter.setChapterDateTime(format.format(d)); } catch (ParseException e)
				 * { // TODO Auto-generated catch block e.printStackTrace(); }
				 * novel.setNovelChapter(novelChapter);
				 */
				list.add(novel);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 小说详情
	 * 
	 * @param novelId
	 * @return
	 */
	public Novel noveldetail(String novelId) {
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
				// recommendation = new Recommendation();
				novel.setNovelId(rs.getLong("novel_id"));
				novel.setNovelName(rs.getString("novel_name"));
				novel.setNovelDesc((rs.getString("novel_desc")));
				novel.setNovelAuthor((rs.getString("novel_author")));
				novel.setNovelClassify((rs.getString("novel_classify")));
				novel.setNovelState((rs.getString("novel_state")));
				novel.setNovelImage(rs.getString("novel_image"));
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
				// recommendation.setRecommendationNovelCount(rs.getLong("novel_recommendation_count"));
				// novel.setRecommendation(recommendation);
				return novel;
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
	 * 小说详情介绍
	 * 
	 * @param novelId
	 * @return
	 */
	public Novel noveldesc(String novelId) {
		sql = "SELECT\r\n" + "*\r\n" + "FROM\r\n" + "tb_novel_base_info "+"WHERE\r\n" + "tb_novel_base_info.novel_id = '" + novelId + "'";
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				novel = new Novel();
				//NOvelChapter = new NovelChapter();
				// recommendation = new Recommendation();
				novel.setNovelId(rs.getLong("novel_id"));
				novel.setNovelName(rs.getString("novel_name"));
				novel.setNovelDesc((rs.getString("novel_desc")));
				novel.setNovelAuthor((rs.getString("novel_author")));
				novel.setNovelClassify((rs.getString("novel_classify")));
				novel.setNovelState((rs.getString("novel_state")));
				novel.setNovelImage(rs.getString("novel_image"));
				/*				novelChapter.setChapterId(rs.getLong("novle_chapter_id"));
				novelChapter.setChapterName(rs.getString("novle_chapter_name"));
				novelChapter.setChapterWordCount(rs.getString("novle_chapter_wordcount"));
				try {
					d = formatter.parse(rs.getString("novle_chapter_datetime"));
					novelChapter.setChapterDateTime(format.format(d));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				novel.setNovelChapter(novelChapter);*/
				// recommendation.setRecommendationNovelCount(rs.getLong("novel_recommendation_count"));
				// novel.setRecommendation(recommendation);
				return novel;
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
