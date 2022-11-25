package ru.gamesphere;

import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.JDBCLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import ru.gamesphere.utils.DefaultServer;
import ru.gamesphere.utils.FlywayInitializer;
import ru.gamesphere.utils.GuiceListener;
import ru.gamesphere.utils.SecurityHandlerBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        FlywayInitializer.initDb();

        final Server server = new DefaultServer().build();

        ServletContextHandler context = new ServletContextHandler();
        context.addServlet(HttpServletDispatcher.class, "/");
        context.addEventListener(new GuiceListener());

        server.setHandler(context);

        final String jdbcConfig = Main.class.getResource("/jdbc_config").toExternalForm();
        final JDBCLoginService jdbcLoginService = new JDBCLoginService("login", jdbcConfig);
        final ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(jdbcLoginService);
        server.addBean(jdbcLoginService);
        securityHandler.setHandler(context);
        server.setHandler(securityHandler);

        server.start();
    }
}
