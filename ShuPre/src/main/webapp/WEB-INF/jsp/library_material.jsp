<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Library_Material|Study-with-You</title>
	<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
	 <div class="container mx-auto mt-5">
        <ul class="flex justify-center">
			<% for(Material material : materialList){ %>
				<li>
					<p><%= material.getName() %></p>
					<p>ページ数：<%= material.getPageStart() %>～<%= material.getPageEnd() %></p>
				</li>
			<% } %>
        </ul>
    </div>
</body>
</html>