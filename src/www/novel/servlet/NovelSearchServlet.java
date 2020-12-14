package www.novel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Novel;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class NovelSearchServlet
 */
@WebServlet("/NovelSearchServlet")
public class NovelSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NovelSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Novel> novels = new ArrayList<>();
		String q = request.getParameter("q");
		novels = BeetlSQLUtil.getSQLManager().query(Novel.class).andLike("novel_name", "%" + q + "%").select();
		request.setAttribute("novels", novels);
		request.getRequestDispatcher("/foreground/novelsearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
