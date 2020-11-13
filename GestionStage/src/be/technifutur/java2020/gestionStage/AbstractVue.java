package be.technifutur.java2020.gestionStage;

import be.technifutur.java2020.gestionStage.stage.ListeStage;
import be.technifutur.java2020.gestionStage.stage.Participant;
import be.technifutur.java2020.gestionStage.stage.Stage;

import java.util.LinkedHashMap;
import java.util.TreeSet;

public class AbstractVue {

    public void afficheListe(LinkedHashMap maListe){

        System.out.println(maListe.keySet().toString());

    }

    public void afficheParticipants(Stage monStage) {
        System.out.println("\n");
        System.out.println("Voici la liste des participants : \n");
        for (Participant s : monStage.getParticipantsStage()) {
            System.out.println("\t- " + s.getNom()+ " " + s.getPrenom());
        }
        System.out.println("\n");
    }
}
