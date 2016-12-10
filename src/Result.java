

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������������±��룬��ֹ����������������
		request.setCharacterEncoding("utf-8");
		//��ȡsession����
		HttpSession session = request.getSession();
		//��ȡsession�е�����
		String username =(String)session.getAttribute("username");
		String pwd =(String)session.getAttribute("password");
		String sex = (String)session.getAttribute("sex");
		String degree =(String)session.getAttribute("degree");
		String[] tech = (String[])session.getAttribute("tech");
		String intro = (String)session.getAttribute("intro");
		//������Ӧ�����ڽ��������ݽ������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>��ʾ�û���Ϣ</title></head><body>");
		out.print("�û����ǣ�"+username+"<br/>");
		out.print("�����ǣ�"+pwd+"<br/>");
		out.print("�Ա��ǣ�"+sex+"<br/>");
		out.print("ѧ���ǣ�"+degree+"<br/>");
		out.print("�ó������ǣ�");
		for(String x:tech){
			out.print(x+"&nbsp;");
		}
		out.print("<br/>");
		out.print("���ҽ����ǣ�"+intro);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
