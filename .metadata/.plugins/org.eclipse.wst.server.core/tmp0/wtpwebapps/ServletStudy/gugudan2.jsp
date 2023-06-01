<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String scol = request.getParameter("col");    
    int col = 3;
    if (scol !=null) col = Integer.parseInt(scol);    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>GuGuDan2</h2><br/>
	

<%
out.println("<table border=\"3\">");
	
for(int i = 1; i <= 9; i+=col) {	 
	 out.print("<tr>");
	for (int k = 1; k<=9 ; k++){ //이게 여기 들어와야~		 
 	for(int j = 1 ; j<=col ; j++){
 		if (9<i+j) break; 		
 		if (j!=0) 			
 		out.print(String.format("<td>" +"%d * %d = %d " + "</td>", i+j, k, (i+j)*k));  		
 		} 		
 		out.print("</tr>"); 		
 	}	  
 }
 out.println("</table>"); 
 %>
</body>
</html>