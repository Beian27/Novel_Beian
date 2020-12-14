package www.novel.servlet.update;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.novel.dao.NovelChapterDao;
import www.novel.util.WordsCount;

/**
 * Servlet implementation class AddChapterServlet
 */
@WebServlet("/AddChapterServlet")
public class AddChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddChapterServlet() {
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
		// 请求解决乱码
		request.setCharacterEncoding("utf-8");
		// 响应解决乱码
		response.setCharacterEncoding("utf-8");
		WordsCount wordsCount = new WordsCount();
		String novelId = request.getParameter("novelId");
		String chaptername = request.getParameter("chaptertitle");
		String content = request.getParameter("text.value");
		System.out.println(novelId);
		System.out.println(chaptername);
		System.out.println(content);
		// 推荐日期
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String newsCreateTime = ft.format(dNow);

		NovelChapterDao nChapterDao = new NovelChapterDao();
		String sql = "INSERT INTO `tb_novle_chapter_info` (`novel_id`, `novle_chapter_name`, `novle_chapter_contend`, `novle_chapter_wordcount`, `novle_chapter_datetime`) VALUES ('"
				+ novelId + "', '" + chaptername + "', '" + content + "', '" + wordsCount.getMSWordsCount(content) + ""
				+ "', '" + newsCreateTime + "')";
		String zzString = request.getParameter("zzzq");
		if (nChapterDao.executeUpdate(sql)) {
			response.sendRedirect(
					request.getContextPath() + "/NovelListServlet?zzzq='" + zzString + "'&novelId='" + novelId + "'");
		} else {
			response.sendRedirect(
					request.getContextPath() + "/NovelListServlet?zzzq='" + zzString + "'&novelId='" + novelId + "'");
		}

	}

}
