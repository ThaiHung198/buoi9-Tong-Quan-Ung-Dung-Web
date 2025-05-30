package com.example.ex5productdiscountcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String priceStr = request.getParameter("price");
        String discountPercentStr = request.getParameter("discount");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (productName == null || productName.trim().isEmpty() ||
                priceStr == null || priceStr.trim().isEmpty() ||
                discountPercentStr == null || discountPercentStr.trim().isEmpty()) {

            out.println("<p style='color:red;'>Lỗi: Vui lòng điền đầy đủ thông tin sản phẩm, giá và phần trăm chiết khấu.</p>");
            out.println("<p><a href='" + request.getContextPath() + "/index.jsp'>Quay lại</a></p>");
            out.println("</body></html>");
            return;
        }
        try {
            double price = Double.parseDouble(priceStr);
            double discountPercentage = Double.parseDouble(discountPercentStr); // Đây là % chiết khấu

            if (price < 0 || discountPercentage < 0 || discountPercentage > 100) {
                out.println("<p style='color:red;'>Lỗi: Giá và phần trăm chiết khấu không hợp lệ (Giá > 0, Chiết khấu 0-100%).</p>");
                out.println("<p><a href='" + request.getContextPath() + "/index.jsp'>Quay lại</a></p>");
                out.println("</body></html>");
                return;
            }

            double discount_amount = price * discountPercentage * 0.01;
            double discount_price = price - discount_amount;

            out.println("<p style='font-weight:bold'> Mô tả: </p>" + "<p>" + productName + "</p>");
            out.println("<p style='font-weight:bold'> Giá: </p>" + "<p>" + price + "</p>");
            out.println("<p style='font-weight:bold'> Chiết khấu: </p>" + "<p>" + discountPercentage + "%</p>"); // Sửa thẻ đóng p
            out.println("<p style='font-weight:bold'> Lượng Chiết khấu: </p>" + "<p>" + discount_amount + "</p>");
            out.println("<p style='font-weight:bold'> Giá sau chiết khấu: </p>" + "<p>" + discount_price + "</p>");

        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Lỗi: Giá hoặc phần trăm chiết khấu không phải là số hợp lệ.</p>");
            out.println("<p>Chi tiết lỗi: " + e.getMessage() + "</p>");
            out.println("<p><a href='" + request.getContextPath() + "/index.jsp'>Quay lại</a></p>");
        }
        out.println("</body></html>");
    }
}
