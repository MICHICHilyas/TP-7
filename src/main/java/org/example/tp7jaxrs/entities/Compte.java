package org.example.tp7jaxrs.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Entité représentant un compte bancaire dans le système.
 * Cette classe est annotée pour la persistance JPA et la sérialisation XML (JAXB).
 * Utilise Lombok pour la génération automatique des getters, setters et constructeurs.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@Entity
@Table(name = "COMPTE_BANCAIRE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "compteBancaire")
public class Compte {

    /**
     * Identifiant unique du compte bancaire (clé primaire auto-générée)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Solde actuel du compte en dirhams
     */
    @Column(name = "solde_compte")
    private double solde;

    /**
     * Date d'ouverture du compte bancaire
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "date_ouverture")
    private Date dateCreation;

    /**
     * Type du compte (COURANT ou EPARGNE)
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type_compte")
    private TypeCompte type;
}