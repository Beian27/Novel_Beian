package www.novel.servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.entity.Novel;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class NovelUpdateAndAddSerlvet
 */
@WebServlet({ "/NovelAddSerlvet", "/NovelUpdateSerlvet" })
public class NovelUpdateAndAddSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NovelUpdateAndAddSerlvet() {
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
		Novel novel = new Novel();
		novel.setNovelName(request.getParameter("noveltitle"));
		novel.setNovelDesc(request.getParameter("text.value"));
		novel.setNovelAuthor(request.getParameter("novelauthor"));
		novel.setNovelClassify(request.getParameter("novelclassify"));
		novel.setNovelState(request.getParameter("novelstate"));
		if(request.getSession().getAttribute("msg")!= null) {
			String ima = request.getSession().getAttribute("msg").toString();
			novel.setNovelImage(ima);
			System.out.println("imaged "+ima);
			System.out.println("noveld "+novel.getNovelImage());
		}
		String novelId = request.getParameter("novelId");
		
		if (novelId == null) {
			BeetlSQLUtil.getSQLManager().insert(novel);
			request.getSession().removeAttribute("msg");
		} else {
			novel.setNovelId((new Long(novelId)));
			BeetlSQLUtil.getSQLManager().updateTemplateById(novel);
		}
		// 是否来自作者专区
		String zzString = request.getParameter("zzzq");
		if (zzString != null) {
			response.sendRedirect(
					request.getContextPath() + "/NovelListServlet?zzzq='" + zzString + "'&novelId='" + novelId + "'");

		} else {
			response.sendRedirect(request.getContextPath() + "/NovelListServlet");

		}

	}

}
