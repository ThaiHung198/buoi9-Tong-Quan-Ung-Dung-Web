package com.example.ex2simple_login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws SecurityException, IOException {}


@Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws SecurityException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    PrintWriter writer = response.getWriter();
    writer.println("<html>");
    if ("admin".equals(username) && "admin".equals(password)) {
        writer.println("<h1>Welcome " + username + "to website</h1>");
    }else {
        writer.println("<h1>Login Error</h1>");
    }
    writer.println("</html>");
}
}
