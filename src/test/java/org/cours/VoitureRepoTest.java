package org.cours;
import static org.assertj.core.api.Assertions.assertThat;
import org.cours.modele.Proprietaire;
import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
public class VoitureRepoTest {
@Autowired
            private TestEntityManager entityManager;
            @Autowired
            VoitureRepo voitureRepo;
            @Test
            public void ajouterVoiture() {
            Proprietaire p2 = new Proprietaire("Najat" , "ddd");
            Voiture voiture = new Voiture("MiolaCar","Uber","Blanche","M-2020",2021,180000,p2);
            entityManager.persistAndFlush(voiture);
            assertThat(voiture.getId()).isNotNull();
            }
            @Test
            public void supprimerVoiture() {
                 Proprietaire p1 = new Proprietaire("Ali" , "bnb");
            entityManager.persistAndFlush(new Voiture ("MiolaCar","Uber","Blanche","M-2020", 2021, 180000,p1));
            entityManager.persistAndFlush(new Voiture ("MiniCooper","Uber","Rouge","C-2020", 2021, 180000,p1));
            voitureRepo.deleteAll();
            assertThat(voitureRepo.findAll()).isEmpty();
            }
}
