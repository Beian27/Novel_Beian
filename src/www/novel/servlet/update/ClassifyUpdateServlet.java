package www.novel.servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.NovelClassify;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class ClassifyUpdateServlet
 */
@WebServlet("/updateClassify.jsp")
public class ClassifyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassifyUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String classifyId = request.getParameter("classifyId");
		NovelClassify novelClassify = BeetlSQLUtil.getSQLManager().single(NovelClassify.class, classifyId);
		System.out.println(novelClassify);
		request.setAttribute("novelClassify", novelClassify);
		request.getRequestDispatcher("/WEB-INF/jsp/updateClassify.jsp").forward(request, response);
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
