package org.example.tp7jaxrs.repositories;

import org.example.tp7jaxrs.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de dépôt pour l'accès aux données des comptes bancaires.
 * Hérite de JpaRepository pour bénéficier des opérations CRUD standard.
 * Spring Data JPA génère automatiquement l'implémentation.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
