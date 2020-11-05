package be.technifutur.java2020.gestionStage.stage;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class ControleurStage {

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

   /* public void removeStage(ListeStage maMap, String stageKey, Stage monStage) {
        boolean presence = false;
        if (!maMap.listeStage.containsKey(stageKey)) {
            presence = true;
            maMap.listeStage.remove(monStage);
        }
        if (presence) {
            System.out.println("Le Stage " + monStage.getKey() + " a bien été retiré");
        }else {
            System.out.println("Aucun stage correspondant");
        }
    }
*/
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
        System.out.println("Jour début ?");
        int jourDebut = sc.nextInt();
        System.out.println("Mois début ?");
        int moisDebut = sc.nextInt();
        System.out.println("Année début ?");
        int anneeDebut = sc.nextInt();
        System.out.println("Heure début?");
        int heureDebut = sc.nextInt();
        System.out.println("Minutes début?");
        int minutesDebut = sc.nextInt();
        LocalDateTime dateDebut = LocalDateTime.of(anneeDebut, moisDebut, jourDebut, heureDebut, minutesDebut);

        System.out.println("Jour fin ?");
        int jourFin = sc.nextInt();
        System.out.println("Mois fin ?");
        int moisFin = sc.nextInt();
        System.out.println("Année fin ?");
        int anneeFin = sc.nextInt();
        System.out.println("Heure fin?");
        int heureFin = sc.nextInt();
        System.out.println("Minutes fin?");
        int minutesFin = sc.nextInt();
        LocalDateTime dateFin = LocalDateTime.of(anneeFin, moisFin, jourFin, heureFin, minutesFin);
        Stage newStage = new Stage(addNom, dateDebut, dateFin);
        return newStage;
    }

    public static void main(String[] args) {
        int choix = 1;
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
                control.addStage(maliste, stageAdd.getKey(), stageAdd);
            }
            if (choix == 2) {
                System.out.println("Quel stage supprimer ?");
                Scanner sc3 = new Scanner(System.in);
                String remStage = sc3.nextLine();
                control.removeStage(maliste, remStage/*, maliste.listeStage.get(remStage)*/);
            }
            if (choix == 3) {

                System.out.println("Quel stage remplacer ?");
                Scanner sc4 = new Scanner(System.in);
                String rempStage = sc4.nextLine();
                System.out.println("Entre les coordonnées du nouveau Stage :");
                Stage stageAdd = control.createStage();
                control.remplaceStage(maliste, rempStage, stageAdd.getKey(), stageAdd);
            }
            if (choix == 4) {
                vue.AfficheListe(maliste.listeStage);
            }
        }
    }
}
