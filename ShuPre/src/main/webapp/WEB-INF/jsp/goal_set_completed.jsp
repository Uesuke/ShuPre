<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Material, model.Goal, model.GoalDetail, java.util.List" %>
<%
//セッションスコープに保存されたユーザー情報を取得
User user = (User)session.getAttribute("user");
//リクエストスコープに保存された目標情報を取得
Goal goal = (Goal)request.getAttribute("goal");
List<GoalDetail> goalDetails = (List<GoalDetail>)request.getAttribute("goalDetails");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Goal_Setting|Study-with-You</title>
		<script src="https://cdn.tailwindcss.com"></script>
		<script deffer src="./js/goal_set.js"></script>
	</head>
	<body class="bg-gray-100">
		 <div class="container mx-auto mt-5">
	        <div class="flex justify-center">
	            <div class="w-full max-w-lg">
					<h1 class="text-3xl text-center mb-8">目標登録完了！</h1>
					<div class="bg-white p-8 rounded shadow-lg">
						<div class="">
							<h2><%=goal.getGoalName(); %></h2>
							<% for(int idx=0; idx<) %>
							<div class="">
								
							</div>
							<% } %>
						</div>
					</div>
	            </div>
	        </div>
	    </div>
	</body>
</html>