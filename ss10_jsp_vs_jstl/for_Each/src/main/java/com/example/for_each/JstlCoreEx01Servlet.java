package com.example.for_each;

import com.example.Service.DBUtils;
import com.example.bean.Dept;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = "/")
public class JstlCoreEx01Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truy vấn dữ liệu từ DB (Mô phỏng).
        List<Dept> list = DBUtils.queryDepartments();

        // Lưu dữ liệu vào thuộc tính 'departments' của request.
        request.setAttribute("departments", list);

        // Tạo đối tượng RequestDispatcher
        // để Forward (chuyển tiếp) yêu cầu tới jstl_core_example01.jsp
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/departments/index.jsp");

        // Forward (Chuyển tiếp) yêu cầu, để hiển thị dữ liệu trên trang JSP.
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
