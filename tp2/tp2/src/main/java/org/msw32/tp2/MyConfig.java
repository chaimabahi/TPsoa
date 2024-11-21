package org.msw32.tp2;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyConfig {
    @Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig resourceConfig= new ResourceConfig();
        resourceConfig.register(TemperatureRS.class);
        return resourceConfig;
    }
}
