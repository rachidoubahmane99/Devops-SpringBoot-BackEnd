/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cours.web;

import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEEV
 */
@RestController
@CrossOrigin(origins ="http://localhost:3000" )
public class VoitureController {
            @Autowired
            private VoitureRepo voitureRepo;
            @RequestMapping("/voitures")
            public Iterable<Voiture> getVoitures(){
                return voitureRepo.findAll();
            }
}

