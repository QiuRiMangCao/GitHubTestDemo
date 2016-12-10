package ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reg
 */
@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("uName");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String[] interests= request.getParameterValues("interest");
		String place = request.getParameter("place");
		String intro = request.getParameter("intro");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>显示用户信息</title></head><body>");
		out.print("用户名是："+username+"<br/>");
		out.print("密码是："+pwd+"<br/>");
		out.print("性别是：");
		if(sex != null){
			if(sex.equals("0")){
				out.println("男");
			}else{
				out.println("女");
			}
		}
		if(interests != null){
			out.print("兴趣是：");
			for(String x:interests){
				if(x.equals("1")){
					out.print("唱歌"+"&nbsp;");
				}
				out.print(x+"&nbsp;");
			}
		}
		if(place != null){
			out.println(place);
		}
		out.println(intro);
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
