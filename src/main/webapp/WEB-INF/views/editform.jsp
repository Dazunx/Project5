<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
 <%@page import="com.spring.music.MusicDAO, com.spring.music.MusicVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>플레이리스트 정보수정</title>
</head>
<body>

<h1>음악 정보 수정</h1>
<form:form modelAttribute="musicVO" method="POST" action="../editok">
	<form:hidden path="sid"/>
	<table id="edit">
		<tr><td>Title:</td><td><form:input path="title"/></td></tr>
		<tr><td>Artist:</td><td><form:input path="artist"/></td></tr>
		<tr><td>Album:</td><td><form:input path="album"/></td></tr>
		<tr><td>Genre:</td><td><form:input path="genre"/></td></tr>
		<tr><td>Chart:</td><td><form:input path="chart"/></td></tr>
	</table>
	<input type="submit" value="수정하기" />
	<input type="button" value="취소하기" onclick="history.back()"/>
	</form:form>
</body>
</html>