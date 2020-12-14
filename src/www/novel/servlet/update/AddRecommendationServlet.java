package www.novel.servlet.update;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.dao.RecommendationDao;
import www.novel.entity.Novel;
import www.novel.entity.Recommendation;
import www.novel.util.BeetlSQLUtil;

/**
 * Servlet implementation class AddRecommendationServlet
 */
@WebServlet("/AddRecommendationServlet")
public class AddRecommendationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendationDao rDao = new RecommendationDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRecommendationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String novelId = request.getParameter("novelId");
		// 根据小说ID查询推荐
		List<Recommendation> list = BeetlSQLUtil.getSQLManager().query(Recommendation.class).andEq("novel_id", novelId)
				.select();
		String sql = "";
		// 推荐日期
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String newsCreateTime = ft.format(dNow);
		AddRecommendationServlet aServlet = new AddRecommendationServlet();
		// 如果推荐为空则新建推荐，否则++
		if (list.isEmpty()) {
			sql = "INSERT IGNORE INTO tb_recommendation (`novel_id`, `novel_recommendation_count`, `novel_recommendation_date`) VALUES ('"
					+ novelId + "','" + 1 + "','" + newsCreateTime + "')";

			aServlet.re(sql, request);
			System.out.println(sql);
		} else {
			sql = "UPDATE `tb_recommendation` SET `novel_recommendation_count`= `novel_recommendation_count`+ 1 WHERE (`novel_id`='"
					+ novelId + "')";
			aServlet.re(sql, request);
			System.out.println(sql);
		}
		Novel novel = new Novel();
		novel.setNovelId(new Long(novelId));
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

	public void re(String sql, HttpServletRequest request) {
		// 执行
		if (rDao.executeUpdate(sql)) {
			request.setAttribute("message", "成功！");
		} else {
			request.setAttribute("message", "失败！");
		}
	}

}
