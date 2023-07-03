package com.example.danh_sach_khach_hang;

import Service.CustomerService;
import entity.Customer;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/customer")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         CustomerService service = new CustomerService();
        List<Customer> list = service.getList();

        req.setAttribute("customers",list);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

}