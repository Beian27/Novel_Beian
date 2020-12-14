package www.novel.servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.dao.BookSelfDao;
import www.novel.entity.Novel;

/**
 * Servlet implementation class AddBookToBookshelfServlet
 */
@WebServlet("/AddBookToBookshelfServlet")
public class AddBookToBookshelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookToBookshelfServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String readerId = request.getParameter("readerId");
		String novelId = request.getParameter("novelId");
		String sql = "INSERT IGNORE INTO `tb_bookshelf` (`novel_id`, `reader_id`) VALUES ('" + novelId + "', '"
				+ readerId + "')";
		BookSelfDao bSelfDao = new BookSelfDao();
		if (bSelfDao.executeUpdate(sql)) {
			request.setAttribute("message", "添加成功！");
		} else {
			request.setAttribute("message", "已存在！");
		}
		Novel novel = new Novel();
		novel.setNovelId(Long.parseLong(novelId));
		request.setAttribute("novel", novel);
		request.getRequestDispatcher("/foreground/articledetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
