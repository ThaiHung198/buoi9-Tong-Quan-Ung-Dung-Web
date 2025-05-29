package com.example.ex5productdiscountcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculateDiscount", value = "/discount")
public class CalculateDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String productName = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        double discount_percent = Double.parseDouble(request.getParameter("discount_percent"));
        double discount_amount  = price * discount * 0.01;
        double discount_price = price - discount_amount;
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<p style='font-weight:bold'> Mô tả: </p>" +"<p>" + productName + "</p>");
        out.println("<p style='font-weight:bold'> Giá: </p>" + "<p>" + price + "</p>");
        out.println("<p style='font-weight:bold'> Chiết khấu: </p>"  + discount_percent + "%</p>");
        out.println("<p style='font-weight:bold'> Lượng Chiết khấu: </p>" + "<p>" + discount_amount + "</p>");
        out.println("<p style='font-weight:bold'> Giá sau chiết khấu: </p>" + "<p>" + discount_price + "</p>");
        out.println("</html>");

    }

}
