package be.technifutur.java2020.gestionStage;

import be.technifutur.java2020.gestionStage.activite.Activite;
import be.technifutur.java2020.gestionStage.stage.Participant;
import be.technifutur.java2020.gestionStage.stage.Stage;

import java.util.LinkedHashMap;

public abstract class AbstractVue {

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

    public void afficheParticipants(Activite activite) {
        System.out.println("\n");
        if (activite.getParticipantsActivite().isEmpty()) {
            System.out.println("L'activité ne contient pas de participants");
        } else {
            for (Participant s : activite.getParticipantsActivite()) {
                System.out.println("\t- " + s.getNom()+ " " + s.getPrenom());
            }
            System.out.println("\n");
        }

    }
}