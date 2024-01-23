package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Material;
import model.User;
import model.ViewMaterialLogic;

@WebServlet("/SetGoalServlet")
public class SetGoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user == null) {	//ログインしていない場合
			//リダイレクト
			response.sendRedirect("WEB-INF/jsp/login.jsp");
		}
		else {	//ログイン済みの場合
			//ユーザーに紐づいたMaterialをArrayListに取得
			ViewMaterialLogic vml = new ViewMaterialLogic();
			List<Material> materialList = vml.execute(user);
			
			//セッションスコープにリストを保存
			session.setAttribute("materialList", materialList);
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/goal_set.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからユーザーインスタンスを取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String goalName = request.getParameter("materialName");
		
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			Date dateStart = sdf.parse((String)request.getParameter("dateStart"));
			Date dateEnd = sdf.parse((String)request.getParameter("dateEnd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    int statusTypeId = 1;	//進行中
	    //詳細のパラメータを取得
		int pageStart = Integer.parseInt(request.getParameter("pageStart"));
		int pageEnd = Integer.parseInt(request.getParameter("pageEnd"));
		int sectionStart = Integer.parseInt(request.getParameter("sectionStart"));
		int sectionEnd = Integer.parseInt(request.getParameter("sectionEnd"));
		int userId = user.getUserId();
		
	}

}
