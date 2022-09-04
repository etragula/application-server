package org.example.servers.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator", value = "/calculator")
public class CalculatorServlet extends HttpServlet {

    private static final String NUMBER = "Number";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String number = req.getParameter(NUMBER);
        String numAttribute = (String) session.getAttribute(NUMBER);

        if (numAttribute == null) {
            session.setAttribute(NUMBER, number);
            req.getRequestDispatcher("jsp/calculator.jsp").forward(req, resp);
        } else {
            PrintWriter writer = resp.getWriter();
            session.removeAttribute(NUMBER);
            writer.printf("<h4>Sum = %d.</h4>", Integer.parseInt(number) + Integer.parseInt(numAttribute));
            writer.close();
        }
    }
}
