<<<<<<< HEAD
<%@page import="utils.JSFunction"%>
=======
<%@page import="utils.JSFunction_과거"%>
>>>>>>> 4244c777a6a4bd34b4ca1a2160dfd0820c9f8ffd
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
<<<<<<< HEAD
=======

>>>>>>> 4244c777a6a4bd34b4ca1a2160dfd0820c9f8ffd
String saveDirectory = application.getRealPath("/Uploads");
String saveFilename = request.getParameter("sName");
String originalFilename = request.getParameter("oName");

try {

	File file = new File(saveDirectory, saveFilename);
	InputStream inStream = new FileInputStream(file);

	String client = request.getHeader("User-Agent");
	if (client.indexOf("WOW64") == -1) {
		originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
	}

	else {
		originalFilename = new String(originalFilename.getBytes("KSC5601"), "ISO-8859-1");
	}

	response.reset();
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFilename + "\"");
	response.setHeader("Content-Length", "" + file.length());

	out.clear();

	OutputStream outStream = response.getOutputStream();

	byte b[] = new byte[(int) file.length()];
	int readBuffer = 0;
	while ((readBuffer = inStream.read(b)) > 0) {
		outStream.write(b, 0, readBuffer);
	}

	inStream.close();
	outStream.close();
} catch (FileNotFoundException e) {
<<<<<<< HEAD
	JSFunction.alertBack("파일을 찾을 수 없습니다.", out);

} catch (Exception e) {
	e.printStackTrace();
	JSFunction.alertBack("예외가 발생하였습니다.", out);
=======
	JSFunction_과거.alertBack("파일을 찾을 수 없습니다.", out);

} catch (Exception e) {
	e.printStackTrace();
	JSFunction_과거.alertBack("예외가 발생하였습니다.", out);
>>>>>>> 4244c777a6a4bd34b4ca1a2160dfd0820c9f8ffd
}
%>