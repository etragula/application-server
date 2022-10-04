package org.example.servers.context;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.io.IOException;
import java.util.Properties;

@WebListener
public class ApplicationContext implements ServletContextListener {

    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        var systemP = getAppProperties();
        var poolP = getPoolProperties(systemP);

        /* Для работы через контекст Tomcat-а
        try {
            var initContext = new InitialContext();
            var envContext = (Context) initContext.lookup("java:/comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/My_DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        this.dataSource = new DataSource(poolP);
        sce.getServletContext().setAttribute("dataSource", dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.dataSource.close();
    }

    private Properties getAppProperties() {
        var properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException("Не удалось загрузить системные переменные.");
        }
        return properties;
    }

    private PoolProperties getPoolProperties(Properties systemP) {
        var poolP = new PoolProperties();
        poolP.setUrl(systemP.getProperty("db.url"));
        poolP.setUsername(systemP.getProperty("db.user"));
        poolP.setPassword(systemP.getProperty("db.password"));
        poolP.setDriverClassName(systemP.getProperty("db.driver-class-name"));
        poolP.setInitialSize(Integer.parseInt(systemP.getProperty("db.pool-size")));
        poolP.setJmxEnabled(true);
        poolP.setTestWhileIdle(false);
        poolP.setTestOnBorrow(true);
        poolP.setValidationQuery("SELECT 1");
        poolP.setTestOnReturn(false);
        poolP.setValidationInterval(30000);
        poolP.setTimeBetweenEvictionRunsMillis(30000);
        poolP.setMaxActive(100);
        poolP.setMaxWait(10000);
        poolP.setRemoveAbandonedTimeout(60);
        poolP.setMinEvictableIdleTimeMillis(30000);
        poolP.setMinIdle(10);
        poolP.setLogAbandoned(true);
        poolP.setRemoveAbandoned(true);
        poolP.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        return poolP;
    }
}
