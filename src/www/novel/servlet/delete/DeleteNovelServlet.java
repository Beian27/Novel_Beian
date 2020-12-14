package www.novel.servlet.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Novel;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class DeleteNovelServlet
 */
@WebServlet("/DeleteNovelServlet")
public class DeleteNovelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteNovelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long novelBaseInfoId = new Long(request.getParameter("novelBaseInfoId"));
		String string = request.getParameter("zzzq");
		BeetlSQLUtil.getSQLManager().deleteById(Novel.class, novelBaseInfoId);// 增删查改基本一致
		if (string != null) {
			response.sendRedirect(request.getContextPath() + "/NovelListServlet?zzzq='" + string + "'");
		} else {
			response.sendRedirect(request.getContextPath() + "/NovelListServlet");
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
