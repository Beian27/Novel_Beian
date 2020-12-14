package www.novel.servlet.update;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.dao.CommentDao;
import www.novel.entity.Comment;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 读者名
		String commentator = request.getParameter("commentator");
		// 小说Id
		String commentNovelId = request.getParameter("comment_novelid");
		System.out.println(commentNovelId);
		// 内容
		String commentContent = request.getParameter("commentContent");
		// 日期
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String commentDate = sFormat.format(date);
		Comment comment = new Comment();
		comment.setCommentator(commentator);
		comment.setCommentContent(commentContent);
		comment.setCommentDate(commentDate);
		comment.setCommentNovelId(Long.parseLong(commentNovelId));
		CommentDao cDao = new CommentDao();
		// cDao.addComment(comment);
		String sql = "INSERT INTO `tb_comment` (`commentator`, `comment_content`, `comment_date`, `comment_novelid`) VALUES ('"
				+ commentator + "', '" + commentContent + "', '" + commentDate + "', '" + commentNovelId + "')";
		cDao.executeUpdate(sql);
		request.setAttribute("comment", comment);
		request.getRequestDispatcher("/foreground/novelcomment.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
