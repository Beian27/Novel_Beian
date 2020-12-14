package www.novel.servlet.update;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// Ϊ�������ṩ������Ϣ
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����������ʵ��
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// ��ʼ����
		sfu.setFileSizeMax(Long.MAX_VALUE);
		// ÿ�����������ݻ��װ��һ����Ӧ��FileItem������
		try {
			List<FileItem> items = sfu.parseRequest(request);
			// ���ֱ���
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				// isFormFieldΪtrue����ʾ�ⲻ���ļ��ϴ�����
				if (!item.isFormField()) {
					ServletContext sctx = getServletContext();
					// ��ô���ļ�������·��
					// upload�µ�ĳ���ļ��� �õ���ǰ���ߵ��û� �ҵ���Ӧ���ļ���
					String path = sctx.getRealPath("/images");
					System.out.println(path);
					// ����ļ���
					String fileName = item.getName();
					System.out.println(fileName);
					// �÷�����ĳЩƽ̨(����ϵͳ),�᷵��·��+�ļ���
					fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
					File file = new File(path + "\\" + fileName);
					if (!file.exists()) {
						item.write(file);
						// ���ϴ�ͼƬ�����ּ�¼�����ݿ���
						String msg = request.getContextPath() + "/images/" + fileName;
						request.getSession().setAttribute("msg", msg);
						/* request.getRequestDispatcher("/addNovel.jsp").forward(request, response); */
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
