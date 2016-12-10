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
 * Servlet implementation class AddDiningcarMultiple
 */
@WebServlet("/add_diningcar_multiple")
public class AddDiningcarMultiple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDiningcarMultiple() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		int userId = (int)request.getSession().getAttribute("userId");
		//String userId = (String)request.getSession().getAttribute("userId");
		DiningCar dc = new DiningCar();
		//该变量的值用于表示批量插入是否成功，如果变量的值为true，则代表批量插入成功，false代表失败
		boolean flag = true;
		for(String id:ids){
			try {
				int result = dc.addDiningCar(userId,id);
				if(result == 1){
					flag = true;
				}else{
					flag = false;
					break;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
			if(flag == true){
				request.setAttribute("msg", "添加点餐车成功！");
			}else{
				request.setAttribute("msg", "添加点餐车失败！");
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
