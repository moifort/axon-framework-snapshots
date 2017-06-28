package org.softech.flexbet;


import org.h2.server.web.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet(), "/console/*");
        return registration;
    }

}
