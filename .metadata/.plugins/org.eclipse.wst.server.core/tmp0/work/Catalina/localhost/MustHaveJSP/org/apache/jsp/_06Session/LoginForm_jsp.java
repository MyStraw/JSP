/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
<<<<<<< HEAD
 * Generated at: 2023-05-24 11:59:52 UTC
=======
 * Generated at: 2023-05-23 08:36:32 UTC
>>>>>>> 4244c777a6a4bd34b4ca1a2160dfd0820c9f8ffd
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._06Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Session</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h2>로그인 페이지</h2>\r\n");
      out.write("	<span style=\"color:red; font-size: 1.2em;\"> ");
      out.print(request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg"));
      out.write("\r\n");
      out.write("\r\n");
      out.write("	</span>\r\n");
      out.write("\r\n");
      out.write("	");

	if (session.getAttribute("UserId") == null) {
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		function validateForm(form) {\r\n");
      out.write("			if (!form.user_id.value) {\r\n");
      out.write("				alert(\"아이디를 입력하세요.\");\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("			if (form.user_pw.value == \"\") {\r\n");
      out.write("				alert(\"패스워드를 입력하세요.\");\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("	</script> <!-- 밑에 form 만 있어도 실해이 된다~ 나머지 위아래 필요없쬬~ 위에 제대로 입력했는지, 이미 있는사람인지 확인용 -->\r\n");
      out.write("	<form action=\"LoginProcess.jsp\" method=\"post\" name=\"loginFrm\"\r\n");
      out.write("		onsubmit=\"return validateForm(this);\">\r\n");
      out.write("		아이디 : <input type=\"text\" name=\"user_id\" /><br /> 패스워드 : <input\r\n");
      out.write("			type=\"password\" name=\"user_pw\" /><br /> <input type=\"submit\"\r\n");
      out.write("			value=\"로그인하기\" />\r\n");
      out.write("	</form>\r\n");
      out.write("	");

	} else {
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.print(session.getAttribute("UserName"));
      out.write("\r\n");
      out.write("	회원님, 로그인하셨습니다.\r\n");
      out.write("	<br />\r\n");
      out.write("	<a href=\"Logout.jsp\">[로그아웃]</a>\r\n");
      out.write("\r\n");
      out.write("	");

	}
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
