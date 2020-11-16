package be.technifutur.java2020.gestionStage.stage;

import be.technifutur.java2020.gestionStage.AbstractVue;
import be.technifutur.java2020.gestionStage.Menu;
import be.technifutur.java2020.gestionStage.activite.Activite;
import be.technifutur.java2020.gestionStage.activite.ControleurActivite;
import be.technifutur.java2020.gestionStage.activite.VueActivite;

import java.util.*;


public class VueStage extends AbstractVue {

    public void afficheMenu(Menu menuPrincipal){
        menuPrincipal.menuPrincipal();
        System.out.println("Que veux-tu faire ?");
        for (Map.Entry<Integer, String> entry : menuPrincipal.getListeChoix().entrySet()) {
            String value = entry.getValue();
            System.out.println(value);
        }
    }

    public void detailsStage(ListeStage maListe, String key) {
        boolean activite = false;
        if (!maListe.getListeStage().containsKey(key)) {
            System.out.println("Le stage n'existe pas");
        } else {
            if (maListe.getListeStage().get(key).getListeActivite().isEmpty()) {
                activite = true;
            }
            System.out.println("Stage " + key + " du " + maListe.getListeStage().get(key).getTxtDebut()
                    + " au " + maListe.getListeStage().get(key).getTxtFin());

            if (activite) {
                System.out.println("Le Stage ne contient pas d'activité");
            } else {
                System.out.println("Ce stage contient : ");
                for (Map.Entry<String, Activite> entry : maListe.getListeStage().get(key).getListeActivite().entrySet()) {
                    String cle = entry.getKey();
                    Activite valeur = entry.getValue();
                    System.out.println("\t- Activité " + cle + "\tle " + maListe.getListeStage().get(key).getListeActivite().get(cle).getTxtDebut()
                            + " (durée : " + maListe.getListeStage().get(key).getListeActivite().get(cle).getDuree() + " min)");
                    }
                }
        }
        //TODO créer une Map et afficher les valeurs sous forme de liste
    /* for (Map.Entry<String, String> entry : lang.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Clé: " + key + ", Valeur: " + value);
        } peut être utile */
    }

    public void menuStages(LinkedHashMap<String, Stage> listStages) {
        int choix = 0;
        String choixStage = "";
        VueActivite vue = new VueActivite();
        ControleurActivite control = new ControleurActivite();
        ControleurStage controlS = new ControleurStage();
        System.out.println("Voici les différents Stages : ");
        for (Map.Entry<String, Stage> entry : listStages.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
        }
        System.out.println("\nDans quel Stage veux-tu travailler ?");
        Scanner sc = new Scanner(System.in);
        choixStage = sc.nextLine();
        while (!vue.isStageValid(listStages, choixStage)) {
                System.out.println("Le Stage n'existe pas");
                System.out.println("\nDans quel Stage veux-tu travailler ?");
                choixStage = sc.nextLine();
        }
        Menu menuStage = new Menu();
        while (choix != 8) {
            vue.afficheMenu(menuStage);
            choix = sc.nextInt();
            while (!menuStage.contient(menuStage.getListeChoix(), choix)) {
                System.out.println("Choix incorrect");
                vue.afficheMenu(menuStage);
                choix = sc.nextInt();
            }
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
                vue.afficheListe(((Stage) listStages.get(choixStage)).getListeActivite());
            }
            if (choix == 5) {
                String activite;
                if (listStages.get(choixStage).getListeActivite().isEmpty()){
                    System.out.println("Il n'y a pas encore d'activité dans ce stage");
                } else {
                    System.out.println("Voici la liste des activités du stage :");
                    this.afficheListe(((Stage) listStages.get(choixStage)).getListeActivite());
                    System.out.println("De quelle activité veux-tu voir les détails ?");
                    Scanner sc5 = new Scanner(System.in);
                    activite = sc5.nextLine();
                    while (!vue.isStageValid(((Stage) listStages.get(choixStage)).getListeActivite(), activite)) {
                        System.out.println("L'activité n'existe pas");
                        System.out.println("De quelle activité veux-tu voir les détails ?");
                        activite = sc5.nextLine();
                    }
                    System.out.println("L'activité " + activite + " se déroule lors du stage " +
                            ((Stage) listStages.get(choixStage)).getNom() +
                            " (du " + ((Stage) listStages.get(choixStage)).getTxtDebut() + " au " + ((Stage) listStages.get(choixStage)).getTxtFin() +
                            ")\nElle aura lieu du " + ((Stage) listStages.get(choixStage)).getListeActivite().get(activite).getTxtDebut() + " au " +
                            ((Stage) listStages.get(choixStage)).getListeActivite().get(activite).getTxtFin());
                    System.out.println("\nVoici la liste des inscris à cette activité :");
                    this.afficheParticipants(listStages.get(choixStage).getListeActivite().get(activite));
                }
            }

            if (choix == 6) {
                this.afficheParticipants(listStages.get(choixStage));
            }

            if (choix == 7) {
                String choixActivite;
                if (listStages.get(choixStage).getListeActivite().isEmpty()){
                    System.out.println("Il n'y a pas encore d'activité dans ce stage");
                } else {
                    System.out.println("Voici la liste des activités du stage :");
                    vue.afficheListe(((Stage) listStages.get(choixStage)).getListeActivite());
                    System.out.println("\nÀ quelle activité voulez-vous vous inscrire ?");
                    Scanner sc1 = new Scanner(System.in);
                    choixActivite = sc1.nextLine();
                    while (!listStages.get(choixStage).getListeActivite().containsKey(choixActivite)){
                        System.out.println("Le stage ne contient pas cette activité");
                        System.out.println("Voici la liste des activités du stage :");
                        vue.afficheListe(((Stage) listStages.get(choixStage)).getListeActivite());
                        System.out.println("\nÀ quelle activité voulez-vous vous inscrire ?");
                        choixActivite = sc1.nextLine();
                    }
                    Participant participant = controlS.createParticipant();
                    if (!control.contientParticipant(listStages.get(choixStage).getParticipantsStage(), participant)) {
                        System.out.println("Inscrivez-vous d'abord au Stage avant de vous inscrire à une activité");
                    } else {
                        listStages.get(choixStage).getListeActivite().get(choixActivite).getParticipantsActivite().add(participant);
                    }
                }
                System.out.println("Voici la liste des activités du stage :");
                vue.afficheListe(((Stage) listStages.get(choixStage)).getListeActivite());
                System.out.println("\nÀ quelle activité voulez-vous vous inscrire ?");
                Scanner sc1 = new Scanner(System.in);
                choixActivite = sc1.nextLine();
                while (!listStages.get(choixStage).getListeActivite().containsKey(choixActivite)){
                    System.out.println("Le stage ne contient pas cette activité");
                    System.out.println("Voici la liste des activités du stage :");
                    vue.afficheListe(((Stage) listStages.get(choixStage)).getListeActivite());
                    System.out.println("\nÀ quelle activité voulez-vous vous inscrire ?");
                    choixActivite = sc1.nextLine();
                }
                Participant participant = controlS.createParticipant();
                if (!control.contientParticipant(listStages.get(choixStage).getParticipantsStage(), participant)) {
                    System.out.println("Inscrivez-vous d'abord au Stage avant de vous inscrire à une activité");
                } else {
                    listStages.get(choixStage).getListeActivite().get(choixActivite).getParticipantsActivite().add(participant);
                }
            }
        }
        VueStage vueS = new VueStage();
        controlS.menuPrincipal(controlS, listStages, vueS, menuStage);
    }
}