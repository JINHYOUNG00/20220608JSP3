<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div align="center">
		<div>
			<h1>공지사항 목록</h1>
		      </div>
      <div>
         <table border="1">
            <thead>
               <tr>
                  <th width="100">글번호</th>
                  <th width="150">작성자</th>
                  <th width="200">제 목</th>
                  <th width="150">작성일자</th>
                  <th width="100">조회수</th>
               </tr>
            </thead>

            <tbody>
               <c:forEach items="${notices }" var="notice">
                  <tr class="row" onclick="noticeSelect(${notice.id})">
                     <td align="center">${notice.id }</td>
                     <td align="center">${notice.writer }</td>
                     <td>${notice.title }</td>
                     <td align="center">${notice.wdate }</td>
                     <td align="center">${notice.hit }</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div><br/>
      <div>
         <form id="frm" action="noticeSelect.do" method="post">
            <input type="hidden" id="id" name="id">
         </form>
      </div>
      <div>
         <button type="button" onclick="location.href='home.do'">홈으로 돌아가기</button>
      </div>
   </div>
   <script type="text/javascript">
   function noticeSelect(id){
   //   location.href = "noticeSelect.do?id="+id;
      frm.id.value = id;
      frm.submit();
   }   
   </script>
</body>
</html>