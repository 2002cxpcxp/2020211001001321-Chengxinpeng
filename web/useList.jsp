<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/4/4
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User list</h1>
<table border=1>
    <tr>
        <td>ID</td><td>Username</td><td>password</td><td>gender</td><td>birthdate</td>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
        if (rs==null){
    %>
    <tr>
        <td>NO Data!!!</td>
    </tr>
    <%}else{
        while (rs.next()) {
//get one by one
            out.println("<tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("gender") + "</td>");
            out.println("<td>" + rs.getString("birthdate") + "</td>");
            out.println("</tr>");
        }
        //out.println("</table></body></html>");
    }
    %>
</table>
<%@include file="footer.jsp"%>