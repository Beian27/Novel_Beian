package www.novel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.NovelClassify;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class ClassifyListServlet
 */
@WebServlet("/ClassifyListServlet")
public class ClassifyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassifyListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<NovelClassify> nClassifies = new ArrayList<>();
		String q = request.getParameter("q");
		if (null != q) {
			request.setAttribute("q", q);
			nClassifies = BeetlSQLUtil.getSQLManager().query(NovelClassify.class)
					.andLike("novel_classify_name", "%" + q + "%").select();
		} else {
			System.out.println("d");
			nClassifies = BeetlSQLUtil.getSQLManager().all(NovelClassify.class);
		}

		request.setAttribute("nClassifies", nClassifies);
		request.getRequestDispatcher("/WEB-INF/jsp/classificationOfNovelMng.jsp").forward(request, response);
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
