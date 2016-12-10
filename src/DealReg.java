

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DealReg
 */
@WebServlet("/DealReg")
public class DealReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������������ʽ����ֹ����������������
		request.setCharacterEncoding("utf-8");
		//��ȡreg.html �����ݵ��û���Ϣ
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String degree = request.getParameter("degree");
		String[] tech = request.getParameterValues("tech");
		String intro = request.getParameter("intro");
		
		//����session���󣬽��������ݴ洢��session��
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", pwd);
		session.setAttribute("sex", sex);
		session.setAttribute("degree", degree);
		session.setAttribute("tech", tech);
		session.setAttribute("intro", intro);
		//�����ض���ʽ����ҳ����ת
		response.sendRedirect("Result");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
