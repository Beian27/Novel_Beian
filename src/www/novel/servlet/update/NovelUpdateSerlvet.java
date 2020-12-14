package www.novel.servlet.update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Novel;
import www.novel.entity.NovelClassify;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class NovelUpdateSerlvet
 */
@WebServlet("/updateNovelBaseInfo.jsp")
public class NovelUpdateSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NovelUpdateSerlvet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String novelBaseInfoId = request.getParameter("novelBaseInfoId");
		Novel novel = BeetlSQLUtil.getSQLManager().single(Novel.class, novelBaseInfoId);
		System.out.println(novel);
		request.setAttribute("novelBaseInfo", novel);

		List<NovelClassify> novelClassifies = new ArrayList<NovelClassify>();
		novelClassifies = BeetlSQLUtil.getSQLManager().all(NovelClassify.class);
		request.setAttribute("novelClassifies", novelClassifies);
		// 是否来自作者专区
		String zzString = request.getParameter("zzzq");
		if (zzString != null) {
			request.getRequestDispatcher("/WEB-INF/jsp/authorzq/updateNovel.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/updateNovel.jsp").forward(request, response);
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
