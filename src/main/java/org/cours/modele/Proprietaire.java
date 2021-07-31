/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cours.modele;

/**
 *
 * @author DEEV
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Proprietaire {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
private long id;
@NonNull
private String nom;
@NonNull
private String prenom;
@OneToMany(cascade = CascadeType.ALL, mappedBy="proprietaire")
@JsonIgnore        
private List<Voiture> voitures; 
}
