package www.novel.servlet.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.NovelClassify;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class DeleteClassifyServlet
 */
@WebServlet("/DeleteClassifyServlet")
public class DeleteClassifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteClassifyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long classifyId = new Long(request.getParameter("classifyId"));
		BeetlSQLUtil.getSQLManager().deleteById(NovelClassify.class, classifyId);// 增删查改基本一致
		response.sendRedirect(request.getContextPath() + "/ClassifyListServlet");
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
