package com.example.productdiscountcalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CaculatorServlet", value = "/caculatorproduct")
public class productdiscountcalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         double listPrice = Double.parseDouble( request.getParameter("price"));
         double discountPercent = Double.parseDouble( request.getParameter("percent"));
         String name = request.getParameter("productname");
        double  discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Product Description : "+name);
        writer.println("<br>");
        writer.println("Discount Amount:" + discountAmount);
        writer.println("<br>");
        writer.println("Discount Price: :" + discountPrice);
        writer.println("</html>");
    }
}
