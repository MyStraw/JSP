<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - froward</title>
</head>
<body>
<h2>포워드 결과</h2>
<ul>
<li>
page 영역 : <%= pageContext.getAttribute("pAttr") %> <!-- 페이지는 공유 안됨 -->
</li>
<li>
request 영역 : <%= request.getAttribute("rAttr") %> <!-- 리퀘스트는 공유 -->
</li>
</ul>

</body>
</html>


