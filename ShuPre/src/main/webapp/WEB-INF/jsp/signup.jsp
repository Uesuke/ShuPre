<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.SignupUser" %>
<%
    //セッションスコープにユーザー情報があれば獲得
    SignupUser signupUser = (SignupUser)session.getAttribute("signupUser");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign-up|Study-with-You</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <h1 class="text-center">ユーザー登録画面</h1>
                <div class="card">
                    <div class="card-body">
                        <form action="SignupServlet" method="post">
                            <div class="mb-3">
                                <label for="accountId" class="form-label">新規ユーザーID：</label>
                                <input type="text" class="form-control" id="accountId" name="accountId" placeholder="IDを入力" value="<%= signupUser != null ? signupUser.getAccountId() : "" %>">
                                <% if(request.getAttribute("errorMsg_Id") != null) { %>
                                    <br><span style="color:red;"><%= request.getAttribute("errorMsg_Id") %></span>
                                <% } %>
                            </div>
                            <div class="mb-3">
                                <label for="name" class="form-label">名前：</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="名前を入力" value="<%= signupUser != null ? signupUser.getName() : "" %>">
                            </div>
                            <div class="mb-3">
                                <label for="pass" class="form-label">パスワード設定：</label>
                                <input type="password" class="form-control" id="pass" name="pass" placeholder="パスワードを入力" value="<%= signupUser != null ? signupUser.getPass() : "" %>">
                            </div>
                            <div class="mb-3">
                                <label for="pass_for_check" class="form-label">パスワード（確認用）：</label>
                                <input type="password" class="form-control" id="pass_for_check" name="pass_for_check" placeholder="パスワードを再度入力" value="<%= signupUser != null ? signupUser.getPass() : "" %>">
                            </div>
                            <div class="mb-3">
                                <label for="mail" class="form-label">メールアドレス：</label>
                                <input type="email" class="form-control" id="mail" name="mail" placeholder="メールアドレスを入力" value="<%= signupUser != null ? signupUser.getMail() : "" %>">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">ユーザータイプ：</label>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="userTypeId" id="userType1" value="1" <%= signupUser != null && signupUser.getUserTypeId() == 1 ? "checked" : "" %>>
                                    <label class="form-check-label" for="userType1">個人・学生モード</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="userTypeId" id="userType2" value="2" <%= signupUser != null && signupUser.getUserTypeId() == 2 ? "checked" : "" %>>
                                    <label class="form-check-label" for="userType2">教師モード</label>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">登録</button>
                        </form>
                    </div>
                </div>
                <div class="mt-3">
                    <p class="text-center">※すでにアカウントをお持ちの方は<a href="LoginServlet">こちらからログイン</a></p>
                    <p class="text-center"><a href="index.jsp">トップへ</a></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
