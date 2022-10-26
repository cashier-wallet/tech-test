package com.ballys.techtest.configuration;

import com.ballys.techtest.rest.v1.RegisterResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(RegisterResource.class);
        registerClasses(ExceptionHandlers.class.getClasses());
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}
