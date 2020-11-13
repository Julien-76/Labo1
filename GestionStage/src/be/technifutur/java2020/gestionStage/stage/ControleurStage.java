package be.technifutur.java2020.gestionStage.stage;

import be.technifutur.java2020.gestionStage.AbstractControleur;
import be.technifutur.java2020.gestionStage.Menu;
import be.technifutur.java2020.gestionStage.activite.Activite;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class ControleurStage extends AbstractControleur {

    public void addStage(ListeStage maMap, String name, Stage monStage){
            if (this.contient(maMap.getListeStage(), name)) {
                System.out.println("Le stage existe déjà");
            }else {
                maMap.getListeStage().put(name, monStage);
                System.out.println("Le stage " + name + " a bien été ajouté");
            }
    }

    public void removeStage(ListeStage maMap, String stageKey) {
        if (!this.contient(maMap.getListeStage(), stageKey)) {
            System.out.println("Aucun stage correspondant");
        }else {
        maMap.getListeStage().remove(stageKey);
        System.out.println("Le Stage " + stageKey + " a bien été retiré");
        }
    }

    public void remplaceStage(ListeStage maMap, String oldKey, String newKey, Stage newStage) {
        if (!this.contient(maMap.getListeStage(), oldKey)) {
            System.out.println("Le stage à remplacer n'existe pas");
        } else {
            this.removeStage(maMap, oldKey);
            this.addStage(maMap, newKey, newStage);
        }
    }

    public Stage createStage() {
        System.out.println("Quel nom de stage ?");
        Scanner sc = new Scanner(System.in);
        String addNom = sc.nextLine();
        LocalDateTime dateDebut = null;
        LocalDateTime dateFin = null;
        do {
            System.out.println("Date et heure de début ? (jj/mm/aaaa hh:mm))");
            dateDebut = this.saisieDate();
            System.out.println("Date de fin ?");
            dateFin = this.saisieDate();
            this.isDateValid(dateDebut, dateFin);
        }while (!this.isDateValid(dateDebut, dateFin));
        HashMap<String, Activite> maliste = null;
        Stage newStage = new Stage(addNom, dateDebut, dateFin);
        return newStage;
    }

    public Participant createParticipant() {
        Participant participant = new Participant();
        String nom, prenom;
        System.out.println("Nom ?");
        Scanner sc = new Scanner(System.in);
        nom = sc.nextLine();
        System.out.println("Prémnom ?");
        prenom = sc.nextLine();
        participant.setNom(nom);
        participant.setPrenom(prenom);
        return participant;
    }

    public void menuPrincipal(ControleurStage control, LinkedHashMap<String, Stage> maListe, VueStage vue, Menu menuPrincipal){
        int choix = 0;
        ListeStage maliste = new ListeStage();
        maliste.getListeStage().putAll(maListe);
        while (choix != 8) {
            vue.afficheMenu(menuPrincipal);
            Scanner sc = new Scanner(System.in);
            choix = sc.nextInt();
            while (!menuPrincipal.contient(menuPrincipal.getListeChoix(), choix)) {
                System.out.println("Choix incorrect");
                vue.afficheMenu(menuPrincipal);
                choix = sc.nextInt();
            }
            if (choix == 1) {
                Stage stageAdd = control.createStage();
                control.addStage(maliste, stageAdd.getNom(), stageAdd);
            }
            if (choix == 2) {
                System.out.println("Quel stage supprimer ?");
                Scanner sc3 = new Scanner(System.in);
                String remStage = sc3.nextLine();
                control.removeStage(maliste, remStage);
            }
            if (choix == 3) {
                System.out.println("Quel stage remplacer ?");
                Scanner sc4 = new Scanner(System.in);
                String rempStage = sc4.nextLine();
                System.out.println("Entre les coordonnées du nouveau Stage :");
                Stage stageAdd = control.createStage();
                control.remplaceStage(maliste, rempStage, stageAdd.getNom(), stageAdd);
            }
            if (choix == 4) {
                vue.afficheListe(maliste.getListeStage());
            }

            if (choix == 5) {
                System.out.println("Liste des stages :");
                vue.afficheListe(maliste.getListeStage());
                System.out.println("De quel stage veux-tu voir les détails ?");
                Scanner sc5 = new Scanner(System.in);
                String details = sc5.nextLine();
                vue.detailsStage(maliste, details);
            }

            if (choix == 6) {
                vue.menuStages(maliste.getListeStage());
            }
        }
    }
}
