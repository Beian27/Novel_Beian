package www.novel.servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Reader;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class ReaderUpdateServlet
 */
@WebServlet("/updateReader.jsp")
public class ReaderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReaderUpdateServlet() {
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
		Reader reader = BeetlSQLUtil.getSQLManager().single(Reader.class, readerId);
		System.out.println(reader);
		request.setAttribute("reader", reader);
		request.getRequestDispatcher("/WEB-INF/jsp/updateReader.jsp").forward(request, response);
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
