<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Material_Registeration|Study-with-You</title>
	<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
	 <div class="container mx-auto mt-5">
        <div class="flex justify-center">
            <div class="w-full max-w-lg">
				<h1 class="text-3xl text-center mb-8">教材登録画面</h1>
				<div class="bg-white p-8 rounded shadow-lg">
					<form action="" method="post">
						<div class="mb-6">
							<label for="materialName" class="block mb-2">教材名</label>
							<input type="text" id="materialName" name="materialName">
						</div>
						<div class="mb-6">
							<label for="name" class="block mb-2">有効ページ</label>
							<input type="number" id="pageStart" name="pageStart">～<input type="number" id="pageEnd" name="pageEnd">
						</div>
						<div class="mb-6">
							<label for="name" class="block mb-2">章を入力</label>
							<input type="number" id="sectionStart" name="sectionStart">～<input type="number" id="sectionEnd" name="sectionEnd">
						</div>
						<button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">登録</button>
					</form>
				</div>
            </div>
        </div>
    </div>
</body>
</html>