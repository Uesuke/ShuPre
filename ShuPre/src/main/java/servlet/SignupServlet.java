package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SignupLogic;
import model.SignupUser;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String accountId = request.getParameter("accountId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		int userTypeId = Integer.parseInt(request.getParameter("userTypeId"));
		
		//データベース上のアカウントIDの重複を確認
		SignupUser signupUser = new SignupUser(accountId, name, pass, mail, userTypeId);
		SignupLogic sl = new SignupLogic();
		boolean integrityOK = sl.hasAccountIdIntegrity(signupUser);
		
		if(integrityOK) {//アカウントIDの重複がなければ
			//セッションスコープに登録ユーザー情報を保存
			HttpSession session = request.getSession();
			session.setAttribute("signupUser", signupUser);
			
			//確認画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/confirm_signup.jsp");
			dispatcher.forward(request, response);
		}else {//アカウントIDに重複があった場合は
			
			
			String errorMsg = "このアカウントIDは既に使用されています。";
			
			//入力画面へ再フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/confirm_signup.jsp");
			dispatcher.forward(request, response);
		}
	}

}
