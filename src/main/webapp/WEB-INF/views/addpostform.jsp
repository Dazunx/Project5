<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>AddPostForm</title>
</head>
<body>

<h1>Add New Music</h1>
<form action="addok" method="post">
	<table id="edit">
		<tr><td>Title:</td><td><input type="text" name="title"/></td></tr>
		<tr><td>Artist:</td><td><input type="text" name="artist"/></td></tr>
		<tr><td>Album:</td><td><textarea cols="50" rows="5" name="album"></textarea></td></tr>
		<tr><td>Genre:</td><td><input type="text" name="genre"/></td></tr>
		<tr><td>Chart:</td><td><input type="text" name="chart"/></td></tr>
	</table>
	<button type="button" onclick="location.href='list'">목록보기</button>
	<button type="submit">추가하기</button>
</form>

</body>
</html>
