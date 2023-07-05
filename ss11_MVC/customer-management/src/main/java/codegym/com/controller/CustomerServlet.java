package codegym.com.controller;

import codegym.com.model.Customer;
import codegym.com.service.CustomerService;
import codegym.com.service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "list":
                listCustomers(request,response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request,response);
                break;
            default:
                listCustomers(request,response);
                break;
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }




    private void listCustomers(HttpServletRequest rep , HttpServletResponse resp){
        List<Customer> customers = customerService.findAll();
        rep.setAttribute("customers",customers);

        try {
            rep.getRequestDispatcher("/WEB-INF/customer/list.jsp").forward(rep,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer/create.jsp");
            try {
                dispatcher.forward(request,response);
            }catch (ServletException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
    }
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id =(int) (Math.random()*10000);

        Customer customer = new Customer(id,name,email,address);
        customerService.save(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer/create.jsp");
        request.setAttribute("message","New customer was created");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        response.sendRedirect("/customers?action=list");
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String inputString = request.getParameter("id");
        int number = Integer.parseInt(inputString);
        Customer customer = this.customerService.findById(number);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("/WEB-INF/customer/error-404.jsp");
        }else{
            request.setAttribute("customer",customer);
            dispatcher  = request.getRequestDispatcher("/WEB-INF/customer/update.jsp");
        }
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;

        if (customer == null) {

            dispatcher = request.getRequestDispatcher("/WEB-INF/customer/error-404.jsp");

        } else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            this.customerService.update(id, customer);
            request.setAttribute("customer", customer);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("/WEB-INF/customer/update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/WEB-INF/customer/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if( customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/WEB-INF/customer/delete.jsp");
        }
        try{
            dispatcher.forward(request,response);

        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if( customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            customerService.remove(id);
            try{
                response.sendRedirect("/customers");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
