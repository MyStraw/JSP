<%@page import="utils.JSFunction_과거"%>
<%@page import="utils.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String user_id = request.getParameter("user_id");
String user_pw = request.getParameter("user_pw");
String save_check = request.getParameter("save_check");

if ("must".equals(user_id) && "1234".equals(user_pw)) {

	if (save_check != null && save_check.equals("Y")) {
		CookieManager.makeCookie(response, "loginId", user_id, 86400);
	} else {
		CookieManager.deleteCookie(response, "loginId"); //쿠키를 만드는것도, 삭제하는것도 다 같은거니 중복이 될거니 따로 클래스로 뺐다. 이게 효율적.보수관리도.
	}

	JSFunction_과거.alertLocation("로그인에 성공했습니다.", "IdSaveMain.jsp", out);
}

else {

	JSFunction_과거.alertBack("로그인에 실패했습니다.", out);
}
%>

