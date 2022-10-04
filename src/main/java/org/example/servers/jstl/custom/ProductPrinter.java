package org.example.servers.jstl.custom;

import org.example.servers.models.Product;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class ProductPrinter extends SimpleTagSupport {

    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public void doTag() throws JspException, IOException {
        var out = getJspContext().getOut();
        for (Product product : products) {
            out.println(product + "<br>");
        }
    }
}
