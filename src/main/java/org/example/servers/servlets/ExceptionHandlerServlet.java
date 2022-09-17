package org.example.servers.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ExceptionHandler", urlPatterns = "/exceptionHandler")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        var cookies = req.getCookies();
        var writer = resp.getWriter();
        if (cookies.length != 0) {
            writer.println("<h3>Cookies:</h3>");
            for (var c : cookies) {
                writer.printf("\"%s\" : \"%s\" <br/>", c.getName(), c.getValue());
            }
        } else {
            writer.println("Cookies пустые!");
        }
        writer.close();
    }
}
