package ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class SessionServlet
 */
@WebServlet(urlPatterns = { "/buy" })
public class SessionServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Session Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		String good= request.getParameter("good");
		HttpSession session=request.getSession();
        List<String> goods=(List)session.getAttribute("goods");
        if(good !=null && !good.equals("")){
        	 if(goods==null){
             	goods=new ArrayList();
        	 }
             goods.add(good);
             session.setAttribute("goods",goods);
        }
       if(goods!=null){
    	   for(String x:goods){
    		   out.println(x);      	
           }
       }
        
        out.print("<form action=\"./buy\" method=\"post\">");
		out.println("  <input type=\"text\" name=\"good\"/>");
		out.println("  <input type=\"submit\" value=\"Ìá½»\">");
		out.println("  </form>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
