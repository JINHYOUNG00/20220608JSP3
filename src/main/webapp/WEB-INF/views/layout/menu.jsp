<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br />
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="home.do">홈</a></li>
<!-- 					로그인 유무에 따라 로그인창 로그아웃창이 보이게 수정 -->
				<c:choose>
					<c:when test="${empty id }">
				<li><a href="loginForm.do">로그인</a></li>
				<li><a href="loginForm.do">회원가입</a></li>
					</c:when>
					<c:otherwise>
				<li><a href="logout.do">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="noticeSelectList.do">공지사항</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Product</a></li>
				<li><a href="#">Service</a></li>
<!-- 				admin만 members 메뉴를 볼수있게 el문으로 수정 -->
				<c:if test="${author eq 'ADMIN' }">
					<li><a href="#about">Members</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>