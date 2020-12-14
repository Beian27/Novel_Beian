package www.novel.servlet.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Reader;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/log")
public class ReaderLoginServlet extends HttpServlet {
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

		List<Reader> readers = BeetlSQLUtil.getSQLManager().query(Reader.class).andEq("reader_account", account)
				.andEq("reader_password", password).select();

		if (readers.isEmpty()) {
			request.getRequestDispatcher("/foreground/login.jsp").forward(request, response);

		} else {
			request.getSession().setAttribute("readers", readers.get(0));
			response.sendRedirect(request.getContextPath() + "/foreground/index.jsp");

		}
	}

}
