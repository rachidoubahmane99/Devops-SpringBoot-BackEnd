/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cours.modele;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author DEEV
 */
@RepositoryRestResource
public interface VoitureRepo extends CrudRepository<Voiture, Long>{
            //Lister Voitures par marque
            List<Voiture> findByModele(@Param("modele") String modele); 
            //Lister Voitures par couleur
            List<Voiture> findByCouleur(@Param("couleur") String couleur);
}


