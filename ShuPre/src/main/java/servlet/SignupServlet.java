package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		//アカウントIDの重複を確認
		SignupUser signupUser = new SignupUser(accountId, name, pass, mail, userTypeId);
		SignupLogic sl = new SignupLogic();
		boolean integrityOK = sl.hasAccountIdIntegrity(signupUser);
		
		if(integrityOK) {
			
		}else {
			
		}
	}

}
