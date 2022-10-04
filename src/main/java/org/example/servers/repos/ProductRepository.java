package org.example.servers.repos;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.example.servers.errors.GetProductFromDBException;
import org.example.servers.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private final DataSource dataSource;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (var cn = dataSource.getConnection();
             var ps = cn.prepareStatement("SELECT ID, NAME, DESC FROM PRODUCTS")) {
            var resultSet = ps.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("DESC")
                ));
            }
        } catch (Exception e) {
            throw new GetProductFromDBException("На данный момент не удается получить запрашиваемую информацию.");
        }
        return products;
    }
}
