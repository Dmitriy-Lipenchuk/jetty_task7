package ru.gamesphere.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import ru.gamesphere.api.InfoREST;
import ru.gamesphere.api.DaoREST;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

public class GuiceListener extends GuiceResteasyBootstrapServletContextListener {
    @Override
    protected List<? extends Module> getModules(ServletContext context) {
        return Collections.singletonList(new GuiceModule());
    }

    private static final class GuiceModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(InfoREST.class);
            bind(DaoREST.class);
            bind(ObjectMapper.class).toInstance(new ObjectMapper());
        }
    }
}
