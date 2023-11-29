<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Log-in|Study-with-You</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div id="login">
            <div class="main">
                <h1>ログイン画面</h1>
                <div class="form_wrapper">
                <form action="LoginServlet" method="post">
                        <p>ユーザーID：<br>
                        <input type="id" name="accountId" placeholder="IDを入力"></p>
                         <p>パスワード：<br>
                        <input type="password" name="pass" placeholder="パスワードを入力"></p>
                        <button type="submit">ログイン</button>
                    </form>
                </div>
                <p>※アカウントをお持ちでない方は<a href="signup.html">こちら</a></p>
                <p><a href="index.html">トップへ</a></p>
            </div>
        </div>
    </body>
</html>