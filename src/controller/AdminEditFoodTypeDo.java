package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FoodType;

/**
 * Servlet implementation class AdminEditFoodTypeDo
 */
@WebServlet("/admin_edit_foodType_do")
public class AdminEditFoodTypeDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditFoodTypeDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String typeN= request.getParameter("ftn");
		FoodType foodtype = new FoodType();
		String msg = "修改分类失败！";
		try {
			int result = foodtype.editFoodTypeAct(id, typeN);
			if(result == 1){
				msg = "修改分类成功！";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String href = request.getContextPath()+"/admin_list_foodType";
		request.setAttribute("msg", msg);
		request.setAttribute("href", href);
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
