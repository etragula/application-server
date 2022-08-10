package ru.sbrf.servers.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FrontController", value = "/")
public class FrontControllerServlet extends HttpServlet {

    public static final String CART = "Cart";
    public static final String CATALOG = "Catalog";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stage = (String) req.getAttribute("stage");

        if (stage.equalsIgnoreCase(CATALOG)) {
            System.out.println(CATALOG);
        }
        else if (stage.equalsIgnoreCase(CART)) {
            System.out.println(CART);
        }
        super.doGet(req, resp);
    }
}
