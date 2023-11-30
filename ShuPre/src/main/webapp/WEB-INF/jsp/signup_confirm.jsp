<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SignupUser" %>
<%
//セッションスコープのユーザー情報を獲得
SignupUser signupUser = (SignupUser)session.getAttribute("signupUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sign-up|Study-with-You</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div id="signup_confirm">
            <div class="main">
                <h1>ユーザー登録確認画面</h1>
                <div class="signup_confirm_wrapper">
                    <p>以下の登録内容に誤りがないか確認してください</p>
                    <p>ユーザーID：<br>
                    <%=signupUser.getAccountId() %></p>
                    <p>名前：<br>
                    <%=signupUser.getName() %></p>
                    <p>パスワード：<br>
                    <%=signupUser.getPass() %></p>
                    <p>メールアドレス：<br>
                    <%=signupUser.getMail() %></p>
                    <p>ユーザータイプ：<br>
                    <%if(signupUser.getUserTypeId() == 1){ %>
                    	個人・学生モード
                    <% } else if(signupUser.getUserTypeId() == 2) { %>
                    	教師モード
                    <% } else { %>
                    	<span style="color:red;">ユーザータイプの取得に失敗しました</span>
                    <% } %>
                    </p>
                </div>
                <button>確認して登録</button>
                <button>登録内容を修正</button>
            </div>
        </div>
    </body>
</html>