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
 * Servlet implementation class ClassifyUpdateAndAdd
 */
@WebServlet({ "/ClassifyAddServlet", "/ClassifyUpdateServlet" })
public class ClassifyUpdateAndAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassifyUpdateAndAddServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NovelClassify classify = new NovelClassify();

		classify.setNovelClassifyName(request.getParameter("newclassify"));

		System.out.println(classify.getNovelClassifyName());
		String classifyId = request.getParameter("classifyId");
		if (classifyId == null) {
			BeetlSQLUtil.getSQLManager().insert(classify);
		} else {
			classify.setNovelClassifyId((new Long(classifyId)));
			BeetlSQLUtil.getSQLManager().updateById(classify);
		}
		response.sendRedirect(request.getContextPath() + "/ClassifyListServlet");
	}

}
