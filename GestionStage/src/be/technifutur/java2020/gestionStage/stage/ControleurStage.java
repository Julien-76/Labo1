package be.technifutur.java2020.gestionStage.stage;

import be.technifutur.java2020.gestionStage.AbstractControleur;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ControleurStage extends AbstractControleur {

    public void addStage(ListeStage maMap, String name, Stage monStage){
            if (maMap.listeStage.containsKey(name)) {
                System.out.println("Le stage existe déjà");
            }else {
                maMap.listeStage.put(name, monStage);
                System.out.println("Le stage " + name + " a bien été ajouté");
            }
    }

    public void removeStage(ListeStage maMap, String stageKey) {
        if (!maMap.listeStage.containsKey(stageKey)) {
            System.out.println("Aucun stage correspondant");
        }else {
        maMap.listeStage.remove(stageKey);
        System.out.println("Le Stage " + stageKey + " a bien été retiré");
        }
    }

    public void remplaceStage(ListeStage maMap, String oldKey, String newKey, Stage newStage) {
        if (!maMap.listeStage.containsKey(oldKey)) {
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
            System.out.println("Date de début ?");
            dateDebut = this.saisieDate();
            System.out.println("Date de fin ?");
            dateFin = this.saisieDate();
            this.isDateValid(dateDebut, dateFin);
        }while (!this.isDateValid(dateDebut, dateFin));

        Stage newStage = new Stage(addNom, dateDebut, dateFin);
        return newStage;
    }



    public static void main(String[] args) {        // manipulation de la liste ok
        int choix = 0;
        ControleurStage control = new ControleurStage();
        ListeStage maliste = new ListeStage();
        maliste.listeStage = new HashMap<>();
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
                vue.AfficheListe(maliste.listeStage);
            }
        }
    }
}
