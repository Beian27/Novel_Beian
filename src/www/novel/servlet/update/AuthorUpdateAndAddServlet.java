package www.novel.servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Author;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class AdminUpdateAndAddservlet
 */
@WebServlet({ "/AuthorAddServlet", "/AuthorUpdateServlet" })
public class AuthorUpdateAndAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthorUpdateAndAddServlet() {
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
		response.setCharacterEncoding("UTF-8");
		
		
		Author author = new Author();
		author.setAuthorName(request.getParameter("authorName"));
		author.setAuthorAccount(request.getParameter("authorAccount"));
		author.setAuthorPassword(request.getParameter("authorPassword"));
		
		String authorId = request.getParameter("authorId");
		if (authorId == null) {
			Author template = new Author();
			template.setAuthorAccount(author.getAuthorAccount());
			long l = BeetlSQLUtil.getSQLManager().templateCount(template);
			if(l>0) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().write("<script>alert('’À∫≈“—¥Ê‘⁄');history.back()</script>");
				return; 
			}
			
			BeetlSQLUtil.getSQLManager().insert(author);
		} else {
			author.setAuthorId(new Long(authorId));
			BeetlSQLUtil.getSQLManager().updateById(author);
		}
		String zzzq = request.getParameter("zzzq");
		if (zzzq != null) {
			response.sendRedirect(request.getContextPath() + "/Author/login.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/AuthorListSerlvet");
		}
	}

}
