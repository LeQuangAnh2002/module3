package com.example.caculator;

import model.Calculator;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/calculate")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(req.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(req.getParameter("second-operand"));
        char operator = req.getParameter("operator").charAt(0);
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try{
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        }catch (Exception ex){
            writer.println("Error: " + ex.getMessage());
        }
        writer.println("</html>");
    }
}