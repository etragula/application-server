package org.example.servers.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servers.models.Product;

import java.io.IOException;

@WebServlet(name = "FrontController", value = "/main")
public class FrontControllerServlet extends HttpServlet {

    public static final String CART = "Cart";
    public static final String CATALOG = "Catalog";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String stage = req.getParameter("stage");
        if (stage != null) {
            if (CATALOG.equalsIgnoreCase(stage)) {
                req.setAttribute(CATALOG.toLowerCase(), Product.getCatalog());
                req.getRequestDispatcher("jsp/catalog.jsp").forward(req, resp);
            } else if (CART.equalsIgnoreCase(stage)) {
                req.setAttribute(CART.toLowerCase(), Product.getCart());
                req.getRequestDispatcher("jsp/cart.jsp").forward(req, resp);
            }
        }
    }
}
