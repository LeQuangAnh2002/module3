package codegym.com.Controller;

import codegym.com.Model.Producer;
import codegym.com.Model.Product;
import codegym.com.Service.ProducerService;
import codegym.com.Service.ProducerServiceImpl;
import codegym.com.Service.ProductService;
import codegym.com.Service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private ProducerService producerService = new ProducerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if(action == null){
                action = "";
            }
            switch (action){
                case "list":
                    listProducts(request,response);
                    break;
                case "create":
                    showCreate(request,response);
                    break;
                case "update":
                     showUpdate(request,response);
                    break;
                case "delete":
                    showDelete(request,response);
                 break;
                case "view" :
                    viewProduct(request,response);
                    break;
                default:
                    listProducts(request,response);
                    break;
            }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/WEB-INF/product/view.jsp").forward(request,response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        List<Producer> producers= producerService.findAll();
        request.setAttribute("product",product);
        request.setAttribute("producers",producers);
        request.getRequestDispatcher("/WEB-INF/product/delete.jsp").forward(request,response);

    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        List<Producer> producers= producerService.findAll();
        request.setAttribute("product",product);
        request.setAttribute("producers",producers);
        request.getRequestDispatcher("/WEB-INF/product/update.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producer> producers = producerService.findAll();
        request.setAttribute("producers",producers);
        System.out.println(producers);
        request.getRequestDispatcher("/WEB-INF/product/create.jsp").forward(request,response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("products",products);
        request.getRequestDispatcher("/WEB-INF/product/list.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "update":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "search":
                searchName(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        productService.delete(product);
        response.sendRedirect("/products?action=list");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String desc = request.getParameter("desc");
        int producer = Integer.parseInt(request.getParameter("producerId"));
        Producer producerId = producerService.findById(producer);

        Product productOnly = productService.findById(id);
        productOnly.setProductName(name);
        productOnly.setPrice(price);
        productOnly.setDescription(desc);
        productOnly.setProducer(producerId);
        productService.update(productOnly);
        response.sendRedirect("/products?action=list");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("desc");
        int id =(int) (Math.random()*10000);
        int producer = Integer.parseInt(request.getParameter("producerId"));
        Producer producerId = producerService.findById(producer);
        Product product = new Product(id,name,price,description,producerId);
        productService.add(product);
        response.sendRedirect("/products?action=list");
    }

    private void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameProduct = request.getParameter("searchName");
        System.out.println(nameProduct);
        List<Product> searchResult = searchProductByName(nameProduct);

        request.setAttribute("searchResult",searchResult);
        request.getRequestDispatcher("/WEB-INF/product/search.jsp").forward(request,response);
    }
    private  List<Product> searchProductByName(String name){
        List<Product> productList = productService.findAll();
        List<Product> result = new ArrayList<>();
        for (Product product :productList){
            if(product.getProductName().contains(name)){
                result.add(product);
            }
        }
        return result;
    }
}
