package org.example.servers.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.example.servers.errors.GetProductFromDBException;
import org.example.servers.repos.ProductRepository;

import java.io.IOException;

@WebServlet(name = "ProductsFromDb", value = "/products")
public class ProductsFromDbServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ServletContext servletContext = servletConfig.getServletContext();
        DataSource dataSource = (DataSource) servletContext.getAttribute("dataSource");
        productRepository = new ProductRepository(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            var products = productRepository.findAll();
            req.setAttribute("products", products);
            req.getRequestDispatcher("jsp/product.jsp").forward(req, resp);
        } catch (GetProductFromDBException e) {
            var writer = resp.getWriter();
            writer.println(e.getMessage());
            writer.close();
        }
    }
}
