<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <input type="id" name="accountId" placeholder="IDを入力"></p>
                        <p>パスワード設定：<br>
                        <input type="password" name="pass" placeholder="パスワードを入力"></p>
                        <p>パスワード（確認用）：<br>
                        <input type="password" name="pass_for_check" placeholder="パスワードを再度入力"></p>
                        <p>メールアドレス：<br>
                        <input type="email" name="mail" placeholder="メールアドレスを入力"></p>
                        <p>ユーザータイプ<br>
                        <input type="radio" name="userTypeId" value="1">個人・学生モード<br>
                        <input type="radio" name="userTypeId" value="2">教師モード
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