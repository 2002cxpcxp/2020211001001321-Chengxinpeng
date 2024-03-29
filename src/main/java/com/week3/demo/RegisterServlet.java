package com.week3.demo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();

        /*ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init()--> "+ con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        */
        con= (Connection) getServletContext().getAttribute("");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            PrintWriter writer = response.getWriter();
    String username =request.getParameter("username");
    String password =request.getParameter("password");
    String email =request.getParameter("email");
    String gender =request.getParameter("gender");
    String birthDate =request.getParameter("birthDate");


    try {
        Statement st = con.createStatement();
        String sql = "insert into usertable(username,password,email,gender,birthdate)" +
                "value('" + username + "','" + password + "','" + email + "','" + gender + "','" + birthDate + "')";
        System.out.println("sql" + sql);


        int n = st.executeUpdate(sql);
        System.out.println("n-->" + n);

        sql = "select id,username,password,email,gender,birthdate from usertable";
        ResultSet rs = st.executeQuery(sql);
        PrintWriter out = response.getWriter();

        //out.println("<html><title></title><body><table border=1><tr>");
        //out.println("<td>Username</td><td>password</td><td>gender</td><td>birthdate</td>");
        /*while (rs.next()) {

            //out.println("<tr>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("gender") + "</td>");
            out.println("<td>" + rs.getString("birthdate") + "</td>");
            out.println("</tr>");
        }*/
        //out.println("</table></body></html>");

        request.setAttribute("rsname",rs);


        request.getRequestDispatcher("userList.jsp").forward(request,response);

        System.out.println("i am in RegisterServlet-->doPost()--> after forward");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    //writer.println("<br>username :"+username);
        //writer.println("<br>password :"+password);
        //writer.println("<br>email :"+email);
        //writer.println("<br>gender :"+gender);
        //writer.println("<br>birthDate :"+birthDate);
        //writer.close();
    }
}
