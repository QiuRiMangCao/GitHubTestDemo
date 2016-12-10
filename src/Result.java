

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
		// 对请求进行重新编码，防止出现中文乱码问题
		request.setCharacterEncoding("utf-8");
		//获取session对象
		HttpSession session = request.getSession();
		//获取session中的属性
		String username =(String)session.getAttribute("username");
		String pwd =(String)session.getAttribute("password");
		String sex = (String)session.getAttribute("sex");
		String degree =(String)session.getAttribute("degree");
		String[] tech = (String[])session.getAttribute("tech");
		String intro = (String)session.getAttribute("intro");
		//设置响应，用于将上述内容进行输出
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>显示用户信息</title></head><body>");
		out.print("用户名是："+username+"<br/>");
		out.print("密码是："+pwd+"<br/>");
		out.print("性别是："+sex+"<br/>");
		out.print("学历是："+degree+"<br/>");
		out.print("擅长技术是：");
		for(String x:tech){
			out.print(x+"&nbsp;");
		}
		out.print("<br/>");
		out.print("自我介绍是："+intro);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
