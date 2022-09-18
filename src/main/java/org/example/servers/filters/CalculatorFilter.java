package org.example.servers.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebFilter(value = "/calculator")
public class CalculatorFilter extends HttpFilter {
    private static final String POST = "POST";
    private static final String ERROR = "error";
    private static final String NUMBER = "Number";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if (POST.equals(req.getMethod())) {
//            var errorMessage = getErrorMessage(req.getParameter(NUMBER));
//            if (errorMessage.isBlank()) {
//                super.doFilter(req, res, chain);
//            }
//            req.setAttribute(ERROR, errorMessage);
//            req.getRequestDispatcher("jsp/calculator.jsp").forward(req, res);
//        } else {

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/My_DB");
            Connection connection = ds.getConnection();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }


        super.doFilter(req, res, chain);

//        }
    }

    private String getErrorMessage(String number) {
        if (number == null || number.isBlank()) {
            return "Поле не было заполнено!";
        } else if (isNotNumeric(number)) {
            return "Введенное значение не является числом!";
        } else {
            return "";
        }
    }

    private boolean isNotNumeric(String number) {
        return !number.matches("-?\\d+");
    }
}
