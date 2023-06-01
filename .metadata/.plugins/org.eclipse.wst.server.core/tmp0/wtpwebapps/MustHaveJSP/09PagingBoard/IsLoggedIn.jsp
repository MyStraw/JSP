<<<<<<< HEAD
<%@ page import="utils.JSFunction"%>
=======
<%@ page import="utils.JSFunction_과거"%>
>>>>>>> 4244c777a6a4bd34b4ca1a2160dfd0820c9f8ffd
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if (session.getAttribute("UserId") == null) {
<<<<<<< HEAD
    JSFunction.alertLocation("로그인 후 이용해주십시오.",
=======
    JSFunction_과거.alertLocation("로그인 후 이용해주십시오.",
>>>>>>> 4244c777a6a4bd34b4ca1a2160dfd0820c9f8ffd
                             "../06Session/LoginForm.jsp", out);
    return;
}
%>