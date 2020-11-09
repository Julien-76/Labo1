package be.technifutur.java2020.gestionStage.stage;

import be.technifutur.java2020.gestionStage.AbstractControleur;
import be.technifutur.java2020.gestionStage.activite.Activite;

import javax.accessibility.AccessibleTable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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



    public static void main(String[] args) {        // manipulation de la liste ok
        int choix = 0;
        ControleurStage control = new ControleurStage();
        ListeStage maliste = new ListeStage();
        VueStage vue = new VueStage();
        while (choix != 100) {
            vue.afficheMenu();
            Scanner sc = new Scanner(System.in);
            choix = sc.nextInt();
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
                vue.AfficheListe(maliste.getListeStage());
            }
        }
    }
}
