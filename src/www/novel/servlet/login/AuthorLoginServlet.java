package www.novel.servlet.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Author;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AuthorLoginServlet")
public class AuthorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决中文乱码
		response.setContentType("text/html;charset=utf-8");
		// 请求解决乱码
		request.setCharacterEncoding("utf-8");
		// 响应解决乱码
		response.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		List<Author> authors = BeetlSQLUtil.getSQLManager().query(Author.class).andEq("author_account", account)
				.andEq("author_password", password).select();

		if (authors.isEmpty()) {
			request.getRequestDispatcher("/Author/login.jsp").forward(request, response);

		} else {
			request.getSession().setAttribute("author", authors.get(0));
			response.sendRedirect(request.getContextPath() + "/Author/index.jsp");

		}
	}

}
