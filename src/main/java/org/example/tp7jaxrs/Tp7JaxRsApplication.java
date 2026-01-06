package org.example.tp7jaxrs;

import org.example.tp7jaxrs.entities.Compte;
import org.example.tp7jaxrs.entities.TypeCompte;
import org.example.tp7jaxrs.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * Classe principale de l'application de gestion des comptes bancaires.
 * Cette application utilise JAX-RS (Jersey) pour exposer une API REST
 * permettant de gérer les comptes bancaires avec support JSON et XML.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@SpringBootApplication
public class Tp7JaxRsApplication {

    /**
     * Point d'entrée principal de l'application.
     * Initialise et démarre le contexte Spring Boot.
     * 
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(Tp7JaxRsApplication.class, args);
    }

    /**
     * Initialise la base de données avec des comptes bancaires de démonstration.
     * Cette méthode est exécutée automatiquement au démarrage de l'application.
     * 
     * @param compteRepository le dépôt pour persister les comptes
     * @return le CommandLineRunner pour l'initialisation des données
     */
    @Bean
    CommandLineRunner initialiserDonnees(CompteRepository compteRepository) {
        return args -> {
            // Création de comptes bancaires de test avec des soldes aléatoires
            compteRepository.save(new Compte(null, Math.random() * 15000, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, Math.random() * 12000, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, Math.random() * 8000, new Date(), TypeCompte.EPARGNE));

            // Affichage des comptes créés dans la console
            System.out.println("=== Comptes bancaires initialisés par Ilyas MICHICH ===");
            compteRepository.findAll().forEach(compte -> {
                System.out.println("Compte: " + compte.toString());
            });
        };
    }
}
