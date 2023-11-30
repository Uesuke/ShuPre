<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SignupUser" %>
<%
//セッションスコープにユーザー情報があれば獲得
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
        <div id="signup">
            <div class="main">
                <h1>ユーザー登録画面</h1>
                <div class="form_wrapper">
                    <form action="SignupServlet" method="post">
                        <p>新規ユーザーID：<br>
                        <input type="id" name="accountId" placeholder="IDを入力"
	                        <% if(signupUser != null) { %>
	                        	value="<%=signupUser.getAccountId() %>"
	                        <% } %>
                        ></p>
                        <p>名前：<br>
                        <input type="id" name="name" placeholder="名前を入力"
	                        <% if(signupUser != null) { %>
	                        	value="<%=signupUser.getName() %>"
	                        <% } %>
                        ></p>
                        <%if(request.getAttribute("errorMsg_Id") != null) { %>
                        <span style="color:red;"><%= request.getAttribute("errorMsg_Id") %></span>
                        <% } %>
                        <p>パスワード設定：<br>
                        <input type="password" name="pass" placeholder="パスワードを入力"></p>
                        <p>パスワード（確認用）：<br>
                        <input type="password" name="pass_for_check" placeholder="パスワードを再度入力"></p>
                        <p>メールアドレス：<br>
                        <input type="email" name="mail" placeholder="メールアドレスを入力"
    						<% if(signupUser != null) { %>
	                        	value="<%=signupUser.getMail() %>"
	                        <% } %>
                        ></p>
                        <p>ユーザータイプ<br>
                        <input type="radio" name="userTypeId" value="1"
                        	<% if(signupUser != null && signupUser.getUserTypeId() == 1){ %>
                        		checked
                        	<% } %>
                        >個人・学生モード<br>
                        <input type="radio" name="userTypeId" value="2"
                        	<% if(signupUser != null && signupUser.getUserTypeId() == 2){ %>
                        		checked
                        	<% } %>
                        >教師モード
                        </p>
                        <button type="submit">登録</button>
                    </form>
                </div>
                <p>※すでにアカウントをお持ちの方は<a href="LoginServlet">こちら</a></p>
                <p><a href="index.jsp">トップへ</a></p>
            </div>
        </div>
    </body>
</html>