package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Goal;
import model.GoalDetail;
import model.Material;
import model.SetGoalDetailLogic;
import model.SetGoalLogic;
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
		request.setCharacterEncoding("UTF-8");
		
	    try {
	    	//目標基本情報登録
	    	String goalName = request.getParameter("materialName");
			int userId = user.getUserId();
			int statusTypeId = 1;	//進行中
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStart = sdf.parse((String)request.getParameter("dateStart"));
			Date dateEnd = sdf.parse((String)request.getParameter("dateEnd"));
			int standardTypeId = Integer.parseInt(request.getParameter("standardTypeId"));
			
			//入力値をもとにDBに目標を登録
			Goal settingGoal = new Goal(0, goalName, userId, dateStart, dateEnd, standardTypeId, statusTypeId);
			SetGoalLogic sgl = new SetGoalLogic();
			Goal goal = sgl.execute(settingGoal);
			//goalIdを取得
			int goalId = goal.getGoalId();
			
			//目標基本情報をリクエストパラメータに保存
			request.setAttribute("goal", goal);
			
			//目標詳細登録
			//リクエストパラメータから教材数を獲得
			int num_materials = Integer.parseInt(request.getParameter("num_materials"));
			
			List<GoalDetail> goalDetails = new ArrayList<GoalDetail>();
			
			//教材数に応じて登録処理を実施
			for(int idx=0; idx<num_materials; idx++) {
				int materialId = Integer.parseInt(request.getParameter("materialId_" + idx));
				int startFrom = Integer.parseInt(request.getParameter("startFrom_" + idx));
				int endTo = Integer.parseInt(request.getParameter("endTo_" + idx));
				
				GoalDetail settingGoalDetail = new GoalDetail(goalId, materialId, startFrom, endTo);
				SetGoalDetailLogic sgdl = new SetGoalDetailLogic();
				GoalDetail goalDetail = sgdl.execute(settingGoalDetail);
				goalDetails.add(goalDetail);
			}
			
			//目標詳細情報リストをリクエストスコープに保存
			request.setAttribute("goalDetails", goalDetails);
			
			//登録完了画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/goal_set_completed.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	}

}
