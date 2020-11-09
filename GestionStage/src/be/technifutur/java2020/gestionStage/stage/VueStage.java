package be.technifutur.java2020.gestionStage.stage;

import be.technifutur.java2020.gestionStage.AbstractVue;
import be.technifutur.java2020.gestionStage.activite.Activite;
import be.technifutur.java2020.gestionStage.activite.ControleurActivite;
import be.technifutur.java2020.gestionStage.activite.VueActivite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class VueStage extends AbstractVue {

    public void afficheMenu(){
        System.out.println("Que veux-tu faire ? \n1. Ajouter Stage\n2. Retirer Stage\n3. Remplacer Stage\n4. Afficher la liste des Stages\n5. Entrer dans le menu des Stage");
    }

    public void menuStages(HashMap listStages) {
        int choix = 0;
        String choixStage = "";
        boolean currentStage = false;
        VueActivite vue = new VueActivite();
        ControleurActivite control = new ControleurActivite();
        System.out.println("Voici les différents Stages : ");
        this.AfficheListe(listStages);
        System.out.println("\nDans quel Stage veux-tu travailler ?");
        Scanner sc = new Scanner(System.in);
        choixStage = sc.nextLine();
        while (!currentStage) {
            if (!listStages.containsKey(choixStage)) {
                System.out.println("Le Stage n'existe pas");
                System.out.println("\nDans quel Stage veux-tu travailler ?");
                choixStage = sc.nextLine();
            } else {
                currentStage = true;
            }
        }
        while (choix != 100) {
            vue.afficheMenu();
            choix = sc.nextInt();
            if (choix == 1) {
                Activite activiteAdd = control.createActivite();
                control.addActivite((Stage) listStages.get(choixStage), activiteAdd.getName(), activiteAdd);
            }
            if (choix == 2) {
                System.out.println("Quelle activité supprimer ?");
                Scanner sc3 = new Scanner(System.in);
                String remActivite = sc3.nextLine();
                control.removeActivité((Stage) listStages.get(choixStage), remActivite);
            }
            if (choix == 3) {

                System.out.println("Quelle activité remplacer ?");
                Scanner sc4 = new Scanner(System.in);
                String rempStage = sc4.nextLine();
                System.out.println("Entre les détails de la nouvelle activité :");
                Activite activiteAdd = control.createActivite();
                control.remplaceActivite((Stage) listStages.get(choixStage), rempStage, activiteAdd.getName(), activiteAdd);
            }
            if (choix == 4) {
                vue.AfficheListe(((Stage) listStages.get(choixStage)).getListeActivite());
            }
            if (choix == 5) {
                String activite;
                System.out.println("De quelle activité veux-tu voir les détails ?");
                Scanner sc5 = new Scanner(System.in);
                activite = sc5.nextLine();

            }
        }
    }
}