package www.novel.servlet.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Admin;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
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

		List<Admin> admins = BeetlSQLUtil.getSQLManager().query(Admin.class).andEq("admin_account", account)
				.andEq("admin_password", password).select();

		if (admins.isEmpty()) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		} else {
			request.getSession().setAttribute("admins", admins.get(0));
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
	}

}
