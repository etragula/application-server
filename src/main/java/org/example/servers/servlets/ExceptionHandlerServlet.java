package org.example.servers.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "ExceptionHandler", urlPatterns = "/exceptionHandler")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        final Cookie[] cookies = req.getCookies();
        final PrintWriter writer = resp.getWriter();
        if (cookies.length != 0) {
            writer.println("<h3>Cookies:</h3>");
            Arrays.stream(cookies)
                    .forEach(c -> writer.printf("\"%s\" : \"%s\" <br/>", c.getName(), c.getValue()));
        } else {
            writer.println("Cookies пустые!");
        }
        writer.close();
    }
}
