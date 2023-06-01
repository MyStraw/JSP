<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>액션 태그 - UseBean</title></head>
<body>
<h2>액션 태그로 폼값 한 번에 받기</h2>
<form method="post" action="UseBeanAction.jsp">
이름 : <input type="text" name="name" /> <br /> <!-- name1 로 해버리면 UseBeanAction에 person이 못받기에 null로만 들어가진다 -->
나이 : <input type="text" name="age" /> <br /> <!-- age12123 이렇게 해버리면 마찬가지로 0만 들어간다. 뭐를 입력하든지. -->
학교 : <input type="text" name="school" /> <br /> <!-- school은 person에 없다. -->

<input type="submit" value="폼값 전송" />
</form>

</body>
</html>