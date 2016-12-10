

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
		// 设置请求编码格式，防止出现中文乱码问题
		request.setCharacterEncoding("utf-8");
		//获取reg.html 所传递的用户信息
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String degree = request.getParameter("degree");
		String[] tech = request.getParameterValues("tech");
		String intro = request.getParameter("intro");
		
		//创建session对象，将上述数据存储到session中
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", pwd);
		session.setAttribute("sex", sex);
		session.setAttribute("degree", degree);
		session.setAttribute("tech", tech);
		session.setAttribute("intro", intro);
		//采用重定向方式进行页面跳转
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
