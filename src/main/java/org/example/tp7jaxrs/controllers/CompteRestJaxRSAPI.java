package org.example.tp7jaxrs.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.tp7jaxrs.entities.Compte;
import org.example.tp7jaxrs.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Contrôleur REST JAX-RS pour la gestion des comptes bancaires.
 * Expose les endpoints de l'API pour les opérations CRUD sur les comptes.
 * Supporte les formats JSON et XML pour les requêtes et réponses.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@Component
@Path("/gestion-bancaire")
public class CompteRestJaxRSAPI {

    /**
     * Dépôt pour l'accès aux données des comptes
     */
    @Autowired
    private CompteRepository compteRepository;

    /**
     * Récupère la liste de tous les comptes bancaires enregistrés.
     * Endpoint accessible en JSON et XML.
     * 
     * @return la liste complète des comptes bancaires
     */
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> listerTousLesComptes() {
        return compteRepository.findAll();
    }

    /**
     * Récupère un compte bancaire spécifique par son identifiant.
     * 
     * @param id l'identifiant du compte à rechercher
     * @return le compte trouvé ou null si non existant
     */
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte obtenirCompteParId(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    /**
     * Crée un nouveau compte bancaire dans le système.
     * Accepte les données au format JSON ou XML.
     * 
     * @param compte les données du nouveau compte à créer
     * @return le compte créé avec son identifiant généré
     */
    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte creerNouveauCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    /**
     * Met à jour les informations d'un compte bancaire existant.
     * 
     * @param id l'identifiant du compte à modifier
     * @param compte les nouvelles données du compte
     * @return le compte mis à jour ou null si non trouvé
     */
    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte mettreAJourCompte(@PathParam("id") Long id, Compte compte) {
        Compte compteExistant = compteRepository.findById(id).orElse(null);
        if (compteExistant != null) {
            compteExistant.setSolde(compte.getSolde());
            compteExistant.setDateCreation(compte.getDateCreation());
            compteExistant.setType(compte.getType());
            return compteRepository.save(compteExistant);
        }
        return null;
    }

    /**
     * Supprime un compte bancaire du système par son identifiant.
     * 
     * @param id l'identifiant du compte à supprimer
     */
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void supprimerCompte(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
    }
}

