package be.technifutur.java2020.gestionStage.activite;
import be.technifutur.java2020.gestionStage.AbstractControleur;
import be.technifutur.java2020.gestionStage.stage.Participant;
import be.technifutur.java2020.gestionStage.stage.Stage;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.TreeSet;

public class ControleurActivite extends AbstractControleur {

    public void addActivite(Stage monStage, String name, Activite monActivite) {
        if (this.contient(monStage.getListeActivite(), name)) {
            System.out.println("L'activité existe déjà");
        }else {
            monStage.addActivite(monActivite);
        }
    }

    public void removeActivité(Stage monStage, String activiteKey) {
        if (!this.contient(monStage.getListeActivite(), activiteKey)) {
            System.out.println("Aucune activité correspondante");
        }else {
            monStage.removeActivite(activiteKey);
            System.out.println("L'activité " + activiteKey + " a bien été retirée");
        }
    }

    public void remplaceActivite(Stage monStage, String oldKey, String newKey, Activite newActivite) {
        if (!this.contient(monStage.getListeActivite(), oldKey)) {
            System.out.println("L'activité à remplacer n'existe pas");
        } else {
            this.removeActivité(monStage, oldKey);
            this.addActivite(monStage, newKey, newActivite);
        }
    }

    public Activite createActivite() {
        System.out.println("Quelle activité créer ?");
        Scanner sc = new Scanner(System.in);
        String addNom = sc.nextLine();
        LocalDateTime dateDebut = null;
        do {
            System.out.println("Date et heure de début ? (jj/mm/aaaa hh:mm)");
            dateDebut = this.saisieDate();
            if (dateDebut.isBefore(LocalDateTime.now())) {
                System.out.println("Date antérieure au présent... recommence");
            }
        }while (dateDebut.isBefore(LocalDateTime.now()));
        System.out.println("Combien de temps va durer l'activité ? (en minutes) ");
        int duree = sc.nextInt();
        return new Activite(addNom, dateDebut, duree);
    }

    public boolean contientParticipant(TreeSet<Participant> maListe, Participant participant) {
        boolean doublon = false;
        for(Participant p : maListe) {
            if (p.getNom().equals(participant.getNom()) && p.getPrenom().equals(participant.getPrenom())){
                doublon = true;
            }
        }
        return doublon;
    }
}
