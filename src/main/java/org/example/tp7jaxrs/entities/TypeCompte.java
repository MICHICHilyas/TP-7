package org.example.tp7jaxrs.entities;

/**
 * Énumération représentant les différents types de comptes bancaires disponibles.
 * Utilisée pour catégoriser les comptes dans le système de gestion bancaire.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
public enum TypeCompte {
    /**
     * Compte courant pour les opérations quotidiennes
     */
    COURANT,
    
    /**
     * Compte épargne pour la capitalisation des économies
     */
    EPARGNE
}
