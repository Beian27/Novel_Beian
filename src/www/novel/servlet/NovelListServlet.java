package www.novel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Author;
import www.novel.entity.Novel;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class NovelListServlet
 */
@WebServlet("/NovelListServlet")
public class NovelListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NovelListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Novel> novels = new ArrayList<>();
		// 标志
		String q = request.getParameter("q");
		// 作者专区
		String zzString = request.getParameter("zzzq");
		// 是否来自作者专区
		if (zzString != null) {
			Author author = (Author) request.getSession().getAttribute("author");
			Novel novel = new Novel();
			novel.setNovelAuthor(author.getAuthorName());
			// 全部查询
			if (null != q) {
				if (q.equals("")) {
					// 根据小说作者查询，当前作者的所有小说
					novels = BeetlSQLUtil.getSQLManager().query(Novel.class).andEq("novel_author", novel.getNovelAuthor())
							.select();
				} else {
					// 模糊查询
					request.setAttribute("q", q);
					novels = BeetlSQLUtil.getSQLManager().query(Novel.class).andLike("novel_name", "%" + q + "%").andLike("novel_author", novel.getNovelAuthor())
							.select();
				}
			} else {
				// 根据小说作者查询，当前作者的所有小说
				novels = BeetlSQLUtil.getSQLManager().query(Novel.class).andEq("novel_author", novel.getNovelAuthor())
						.select();
			}
			request.setAttribute("novelBaseInfos", novels);
			request.getRequestDispatcher("/WEB-INF/jsp/authorzq/novelInfo.jsp").forward(request, response);
		} else {
			// 全部查询
			if (null != q) {
				if (q.equals("")) {
					novels = BeetlSQLUtil.getSQLManager().all(Novel.class);
				} else {
					// 模糊查询
					request.setAttribute("q", q);
					novels = BeetlSQLUtil.getSQLManager().query(Novel.class).andLike("novel_name", "%" + q + "%")
							.select();
				}
			} else {
				// 全部查询
				novels = BeetlSQLUtil.getSQLManager().all(Novel.class);
			}
			request.setAttribute("novelBaseInfos", novels);
			request.getRequestDispatcher("/WEB-INF/jsp/novelInfoMng.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
