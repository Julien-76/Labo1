package be.technifutur.java2020.gestionStage.stage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ControleurStage {

    public void addStage(List maListe, Stage monStage){
            if (maListe.contains(monStage)) {
                System.out.println("Le stage existe déjà");
            }else {
                maListe.add(monStage);
                System.out.println("Le stage " + monStage.getNom() + " a bien été ajouté");
            }
    }

   /* public static void main(String[] args) {
        List liste = new ArrayList();
        Stage stage = new Stage("tennis", LocalDateTime.of(2020, 05, 12, 16, 00), LocalDateTime.of(2020, 05, 12, 16, 10));
        ControleurStage control = new ControleurStage();
        control.addStage(liste, stage);
    }*/

    public void removeStage(List maListe, Stage monStage) {
        boolean presence = false;
        if (maListe.contains(monStage)) {
            presence = true;
            maListe.remove(maListe.indexOf(monStage));
        }
        if (presence) {
            System.out.println("Le Stage " + monStage.getNom() + " a bien été retiré");
        }else {
            System.out.println("Aucun stage correspondant");
        }
    }

    public void remplaceStage(List maListe, Stage oldStage, Stage newStage) {
        if (!maListe.contains(oldStage)) {
            System.out.println("Le stage à remplacer n'existe pas");
        }else {
            maListe.set(maListe.indexOf(oldStage), newStage);
            System.out.println("Le Stage " + oldStage.getNom() + " a bien été remplacé par le stage " + newStage.getNom());
        }
    }

    public static void main(String[] args) {
        int choix = 1;

        ControleurStage control = new ControleurStage();
        ListeStage maliste = new ListeStage();
        maliste.listeStage = new ArrayList<>();
        while (choix != 100) {
            System.out.println("Que veux-tu faire ? \n1. Ajouter Stage\n2. Retirer Stage\n3. Remplacer Stage\n4. Afficher la liste");
            Scanner sc = new Scanner(System.in);
            choix = sc.nextInt();
            if (choix == 1) {
                System.out.println("Quel nom de stage ?");
                Scanner sc2 = new Scanner(System.in);
                String addNom = sc2.nextLine();
                System.out.println("Année début ?");
                int anneeDebut = sc.nextInt();
                System.out.println("Mois début ?");
                int moisDebut = sc.nextInt();                   // je sais j'en fait peut être un peut de trop...
                System.out.println("Jour début ?");
                int jourDebut = sc.nextInt();
                System.out.println("Heure début?");
                int heureDebut = sc.nextInt();
                System.out.println("Minutes début?");
                int minutesDebut = sc.nextInt();
                LocalDateTime dateDebut = LocalDateTime.of(anneeDebut, moisDebut, jourDebut, heureDebut, minutesDebut);
                System.out.println("Année fin ?");
                int anneeFin = sc.nextInt();
                System.out.println("Mois fin ?");
                int moisFin = sc.nextInt();
                System.out.println("Jour fin ?");
                int jourFin = sc.nextInt();
                System.out.println("Heure fin?");
                int heureFin = sc.nextInt();
                System.out.println("Minutes fin?");
                int minutesFin = sc.nextInt();
                LocalDateTime dateFin = LocalDateTime.of(anneeFin, moisFin, jourFin, heureFin, minutesFin);
                Stage newStage = new Stage(addNom, dateDebut, dateFin);
                control.addStage(maliste.listeStage, newStage);
            }
            if (choix == 2) {
                System.out.println("Quel stage supprimer ?");
                for (int cpt = 0; cpt < maliste.listeStage.size(); cpt++) {
                    System.out.println(cpt + ". " + maliste);
                }
                int remStage = sc.nextInt();
                control.removeStage(maliste.listeStage, maliste.listeStage.get(remStage));
            }
        }
    }
}
