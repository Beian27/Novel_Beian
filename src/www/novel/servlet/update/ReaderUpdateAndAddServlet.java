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
 * Servlet implementation class ReaderUpdateAndAddServlet
 */
@WebServlet({ "/ReaderAddServlet", "/ReaderUpdateServlet" })
public class ReaderUpdateAndAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReaderUpdateAndAddServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		Reader reader = new Reader();

		reader.setReaderName(request.getParameter("readerName"));
		reader.setReaderAccount(request.getParameter("readerAccount"));
		reader.setReaderPassword(request.getParameter("readerPassword"));

		String readerId = request.getParameter("readerId");
		if (readerId == null) {
			Reader template = new Reader();
			template.setReaderAccount(reader.getReaderAccount());
			long l = BeetlSQLUtil.getSQLManager().templateCount(template);
			if(l>0) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().write("<script>alert('’À∫≈“—¥Ê‘⁄');history.back()</script>");
				return; 
			}
			BeetlSQLUtil.getSQLManager().insert(reader);
		} else {
			reader.setReaderId((new Long(readerId)));
			BeetlSQLUtil.getSQLManager().updateById(reader);
		}
		String zzzq = request.getParameter("zzzq");
		if (zzzq!=null) {
			response.sendRedirect(request.getContextPath() + "/foreground/index.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/ReaderListServlet");
		}

	}

}
