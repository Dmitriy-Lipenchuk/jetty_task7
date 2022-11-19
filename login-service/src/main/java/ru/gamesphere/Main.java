package ru.gamesphere;

import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.JDBCLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.gamesphere.servlets.InfoServlet;
import ru.gamesphere.servlets.GetServlet;
import ru.gamesphere.servlets.PostServlet;
import ru.gamesphere.utils.DefaultServer;
import ru.gamesphere.utils.FlywayInitializer;
import ru.gamesphere.utils.SecurityHandlerBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        FlywayInitializer.initDb();

        final Server server = new DefaultServer().build();

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(new ServletHolder("get-servlet", GetServlet.class), "/get");
        context.addServlet(new ServletHolder("post-servlet", PostServlet.class), "/post");
        context.addServlet(new ServletHolder("info-servlet", InfoServlet.class), "/info");

        final String jdbcConfig = Main.class.getResource("/jdbc_config").toExternalForm();
        final JDBCLoginService jdbcLoginService = new JDBCLoginService("login", jdbcConfig);
        final ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(jdbcLoginService);
        server.addBean(jdbcLoginService);
        securityHandler.setHandler(context);
        server.setHandler(securityHandler);

        server.start();
    }
}
