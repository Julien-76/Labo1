package be.technifutur.java2020.gestionStage.stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    public void remplaceStage(ListeStage maMap, String oldKey, String newKey, Stage newStage) {
        if (!maMap.listeStage.containsKey(oldKey)) {
            System.out.println("Le stage à remplacer n'existe pas");
        } else {
            this.removeStage(maMap, oldKey);
            this.addStage(maMap, newKey, newStage);
        }
    }

    public boolean isDateValid(LocalDateTime debut, LocalDateTime fin) {
        boolean ok = false;
        if (debut.compareTo(fin) > 0 || debut.isBefore(LocalDateTime.now())) {
            System.out.println("Date invalide (antérieur au début ou au présent");
        } else {
            ok = true;
        }
        return ok;
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

    public LocalDateTime saisieDate(){
        String formatDate = "d/MM/yyyy HH:mm";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(formatDate);
        String date = new Scanner(System.in).nextLine();
        Pattern pat = Pattern.compile("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9][0-9][0-9][0-9]) ([0-1][0-9]|2[0-3]):([0-5][0-9])");
        Matcher match = pat.matcher(date);
        boolean valid = match.matches();
        while (!valid) {
            System.out.println("Date non valide, recommence");
            date = new Scanner(System.in).nextLine();
            match = pat.matcher(date);
            valid = match.matches();
        }
        LocalDateTime maDate = LocalDateTime.parse(date, format);
        return maDate;
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
