package www.novel.servlet.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.dao.BookSelfDao;

/**
 * Servlet implementation class DeleteServletBookSelf
 */
@WebServlet("/DeleteServletBookSelf")
public class DeleteServletBookSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServletBookSelf() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long novelId = new Long(request.getParameter("novelId"));
		BookSelfDao bookSelfDao = new BookSelfDao();
		String sql = "delete from tb_bookshelf where novel_id='" + novelId + "'";
		if (bookSelfDao.executeUpdate(sql)) {
			request.setAttribute("message", "É¾³ý³É¹¦£¡");
		} else {
			request.setAttribute("message", "É¾³ýÊ§°Ü£¡");
		}
		response.sendRedirect(request.getContextPath() + "/foreground/bookself.jsp");
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
