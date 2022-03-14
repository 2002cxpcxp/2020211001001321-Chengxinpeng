package com;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Helloservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name:Chengxinpeng");
        writer.println("ID:2020211001001321");
        writer.println("Date and Time Sun Feb 8 16:00:22 CST 2022");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
