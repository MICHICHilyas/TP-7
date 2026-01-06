package org.example.tp7jaxrs.config;

import org.example.tp7jaxrs.controllers.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration Jersey pour l'application JAX-RS.
 * Cette classe configure les ressources REST qui seront exposées
 * par le serveur Jersey embarqué dans Spring Boot.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@Configuration
public class MyConfig {

    /**
     * Configure et retourne la configuration des ressources Jersey.
     * Enregistre les contrôleurs REST JAX-RS pour les exposer via l'API.
     * 
     * @return la configuration Jersey avec les ressources enregistrées
     */
    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServlet = new ResourceConfig();
        // Enregistrement du contrôleur REST pour les comptes bancaires
        jerseyServlet.register(CompteRestJaxRSAPI.class);
        return jerseyServlet;
    }
}