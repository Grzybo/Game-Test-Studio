/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-24 20:23:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _005fmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write(" \r\n");
      out.write(" \t<style>\r\n");
      out.write(" \t\t.button {\r\n");
      out.write("\t        display: inline-block;\r\n");
      out.write("\t        padding: 10px 20px;\r\n");
      out.write("\t        text-align: center;\r\n");
      out.write("\t        text-decoration: none;\r\n");
      out.write("\t        color: #ffffff;\r\n");
      out.write("\t        background-color: #33ccff;\r\n");
      out.write("\t        border-radius: 6px;\r\n");
      out.write("\t        outline: none;}\r\n");
      out.write("\t        \r\n");
      out.write("        .center {\r\n");
      out.write("        \ttext-align: center;} \r\n");
      out.write("\t\t.user {\r\n");
      out.write("\t\t\tcolor: #33ccff;}\r\n");
      out.write("        body {\r\n");
      out.write("        \tfont-family: Verdana, sans-serif;\r\n");
      out.write("  \t\t\ttext-align: center;}\r\n");
      out.write("\t\t.content {\r\n");
      out.write("\t\t\twidth:35%;\r\n");
      out.write("\t\t\theight: auto;\r\n");
      out.write("\t\t\tmargin: auto;\r\n");
      out.write("\t\t\tbackground: white;\r\n");
      out.write("\t\t\tpadding: 10px;\r\n");
      out.write("\t\t\tborder-style: groove;\r\n");
      out.write("\t\t\tborder-color: #33ccff;}\r\n");
      out.write("\t\t.left{\r\n");
      out.write("\t\t\ttext-align: left;}\r\n");
      out.write("\t\ttextarea { resize: vertical; }\r\n");
      out.write("\t\t#checkboxes ul {\r\n");
      out.write("\t\t  margin: 0;\r\n");
      out.write("\t\t  list-style: none;\r\n");
      out.write("\t\t  float: center;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#checkboxes label {\r\n");
      out.write(" \t\t float: center;\r\n");
      out.write("\t\t}\r\n");
      out.write("    </style>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\t<a class=\"button\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/projects\">Project</a> \r\n");
      out.write("\t|\r\n");
      out.write("\t<a class=\"button\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/contact\">Contact</a> \r\n");
      out.write("\t|\r\n");
      out.write("\t<a class=\"button\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/userInfo\">User Page</a>\r\n");
      out.write("\t|\r\n");
      out.write("\t<a class=\"button\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/adminPage\">Admin Page</a>\r\n");
      out.write("\t|\r\n");
      out.write("\t<a class=\"button\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/logout\">Logout</a>\r\n");
      out.write("\t| \r\n");
      out.write("\t<a class =\"user\" >Logged as: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginedUsername}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </a>\r\n");
      out.write("\t|\r\n");
      out.write("\t<a class =\"user\" >Project: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userProject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><hr> \r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
