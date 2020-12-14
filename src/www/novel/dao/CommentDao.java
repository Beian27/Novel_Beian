package www.novel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import www.novel.entity.Comment;
import www.novel.entity.Novel;
import www.novel.util.BeetlSQLUtil;
import www.novel.util.DbHelp;

public class CommentDao {
	private Connection conn = null;
	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Comment comment = null;
	private Novel novel = null;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Date d = new Date();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public CommentDao() {
		// TODO Auto-generated constructor stub
		conn = DbHelp.getConnection();
	}

	/**
	 * 根据当前的小说ID查询所有的评论
	 * 
	 * @param novelId
	 * @return
	 */
	public ArrayList<Comment> getCommentDetaliByAuthorId(String novelId) {
		ArrayList<Comment> comments = (ArrayList<Comment>) BeetlSQLUtil.getSQLManager().query(Comment.class)
				.andEq("comment_novelid", novelId).select();
		System.out.println(novelId);
		return comments;
	}

	/**
	 * 根据当前的小说ID查询所有的评论
	 * 
	 * @param novelId
	 * @return
	 */
	public ArrayList<Comment> getCommentByNovelId(String novelId) {
		ArrayList<Comment> comments = (ArrayList<Comment>) BeetlSQLUtil.getSQLManager().query(Comment.class)
				.andEq("comment_novelid", novelId).select();
		System.out.println(novelId);
		return comments;
	}

	/**
	 * 获取当前作者的小说评论
	 * 
	 * @param novelId
	 * @return
	 */
	public ArrayList<Comment> getCommentByAuthor(String authorName) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		sql = "SELECT" + "*" + "FROM\r\n" + "tb_comment\r\n"
				+ "INNER JOIN tb_novel_base_info ON tb_comment.comment_novelid = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "tb_novel_base_info.novel_author = '"+authorName+"' ORDER BY\r\n" + 
						"tb_comment.comment_date DESC ";
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				comment = new Comment();
				novel = new Novel();
				comment.setCommentId(rs.getLong("comment_id"));
				comment.setCommentator(rs.getString("commentator"));
				comment.setCommentContent(rs.getString("comment_content"));
				comment.setCommentNovelId(rs.getLong("comment_novelid"));
				try {
					d = formatter.parse(rs.getString("comment_date"));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				comment.setCommentDate(format.format(d));
				novel.setNovelId(rs.getLong("novel_id"));
				novel.setNovelName(rs.getString("novel_name"));
				novel.setNovelDesc((rs.getString("novel_desc")));
				novel.setNovelAuthor((rs.getString("novel_author")));
				novel.setNovelClassify((rs.getString("novel_classify")));
				novel.setNovelState((rs.getString("novel_state")));
				comment.setNovel(novel);
				comments.add(comment);
			}
			return comments;
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

	public ArrayList<Comment> getlatestNovelList(String authorName) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		sql = "SELECT" + "*" + "FROM\r\n" + "tb_comment\r\n"
				+ "INNER JOIN tb_novel_base_info ON tb_comment.comment_novelid = tb_novel_base_info.novel_id\r\n"
				+ "WHERE\r\n" + "tb_novel_base_info.novel_author =  '"+authorName+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				comment = new Comment();
				novel = new Novel();
				comment.setCommentId(rs.getLong("comment_id"));
				comment.setCommentator(rs.getString("commentator"));
				comment.setCommentContent(rs.getString("comment_content"));
				comment.setCommentNovelId(rs.getLong("comment_novelid"));
				try {
					d = formatter.parse(rs.getString("comment_date"));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				comment.setCommentDate(format.format(d));
				novel.setNovelId(rs.getLong("novel_id"));
				novel.setNovelName(rs.getString("novel_name"));
				novel.setNovelDesc((rs.getString("novel_desc")));
				novel.setNovelAuthor((rs.getString("novel_author")));
				novel.setNovelClassify((rs.getString("novel_classify")));
				novel.setNovelState((rs.getString("novel_state")));
				comment.setNovel(novel);
				comments.add(comment);
				return comments;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}

	/**
	 * 添加评论
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment) {
		System.out.println(comment.getCommentNovelId() + "faesavas");
		BeetlSQLUtil.getSQLManager().insert(comment);
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
