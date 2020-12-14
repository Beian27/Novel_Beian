package www.novel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Reader;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class ReaderListServlet
 */
@WebServlet("/ReaderListServlet")
public class ReaderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReaderListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Reader> readers = new ArrayList<>();
		String q = request.getParameter("q");
		if (null != q) {
			if (q.equals("")) {
				readers = BeetlSQLUtil.getSQLManager().all(Reader.class);
			} else {
				Reader query = new Reader();
				query.setReaderName(q);
				request.setAttribute("q", q);
				readers = BeetlSQLUtil.getSQLManager().template(query);
			}

		} else {
			readers = BeetlSQLUtil.getSQLManager().all(Reader.class);
		}
		request.setAttribute("readers", readers);
		request.getRequestDispatcher("/WEB-INF/jsp/readerInfoMng.jsp").forward(request, response);
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
