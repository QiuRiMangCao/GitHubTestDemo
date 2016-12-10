

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Chart
 */
@WebServlet("/Chart")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String[] goods = request.getParameterValues("good");
		String del = request.getParameter("del");
		HttpSession session = request.getSession();
		ArrayList<String> goodsSession = (ArrayList)(session.getAttribute("goods"));
		if(del != null){	
			ArrayList<String> dels = new ArrayList<String>();
			for(String a:goodsSession){
				if(a.equals(del)){
					dels.add(a);
				}
			}
			goodsSession.removeAll(dels);
			
		}
		if(goods != null){
			if(goodsSession == null){
				goodsSession = new ArrayList<>();
			}
			for(String x:goods){
				goodsSession.add(x);
			}
		}		
		session.setAttribute("goods", goodsSession);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>购物车显示</title></head><body>");
		out.print("购物车商品为：");
		if(goodsSession == null){
			out.print("空，快去添加商品吧~");
		}else{
			ArrayList<String> control = new ArrayList<String>();
			for(String x:goodsSession){								
				int i=0;
				for(String y:goodsSession){
					if(y.equals(x)){
						i++;
					}
				}
				if(control.contains(x)){
					continue;
				}
				out.print("<form action='Chart' method='post'>");
				out.print(x+"&nbsp;"+i+"本&nbsp;");
				out.print("<input type='hidden' value='"+x+"' name='del'>");
				out.print("<input type='submit' value='删除'>");
				out.print("</form>");
				control.add(x);
			}
		}
		out.print("<form action='Chart' method='post'>");
		out.print("商品列表：");
		out.print("<input type='checkbox' value='Java' name='good'>Java" );
		out.print("<input type='submit' value='添加到购物车'>");
		out.print("</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
