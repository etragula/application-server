package org.example.servers.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SignInServlet", value = "/signIn")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        var eMail = req.getParameter("eMail");
        var password = req.getParameter("password");

        if (eMail.isBlank() || password.isBlank()) {
            resp.addCookie(new Cookie("code", "400"));
            resp.sendError(400);
        } else {
            var writer = resp.getWriter();
            writer.printf("Добро пожаловать, %s! <br/>", eMail);
            writer.close();
        }
    }
}
