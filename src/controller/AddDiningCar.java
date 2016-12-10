package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DiningCar;

/**
 * Servlet implementation class AddDiningCar
 */
@WebServlet("/AddDiningCar")
public class AddDiningCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDiningCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取show_detail.jsp中的66行中的表单传递过来的数据
		String foodId = request.getParameter("foodId");
		//获取在login.jsp中设置的userId	
		Object userId = request.getSession().getAttribute("userId");
		
		//通过userId可以判断当前用户是否登录，如果为null，跳转会首页，如果用户已经登录，则可以将商品添加到点菜车中
		if(userId == null){
			request.setAttribute("msg", "您还未登录，请先进行登录！");
			request.setAttribute("href", request.getContextPath()+"/Homepage");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
		DiningCar dc = new DiningCar();
		
		try {
			int uId = (int)userId;
			int result = dc.addDiningCar(uId, foodId);
			if(result ==1){
				request.setAttribute("msg", "添加点餐车成功！");
			}else{
				request.setAttribute("msg", "添加点餐车失败！");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("href", request.getContextPath()+"/Homepage");
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
