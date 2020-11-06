package be.technifutur.java2020.gestionStage.activite;
import be.technifutur.java2020.gestionStage.stage.Stage;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleurActivite {

    public void addActivite(Stage monStage, String name, Activite monActivite) {     //TODO, se baser sur Stage
        if (monStage.getListeActivite().containsKey(name)) {
            System.out.println("L'activité existe déjà");
        }else {
            monStage.getListeActivite().put(name, monActivite);
            System.out.println("L'activité " + name + " a bien été ajoutée");
        }
    }

    public void removeActivité(Stage monStage, String activiteKey) {
        if (!monStage.getListeActivite().containsKey(activiteKey)) {
            System.out.println("Aucune activité correspondante");
        }else {
            monStage.getListeActivite().remove(activiteKey);
            System.out.println("L'activité' " + activiteKey + " a bien été retirée");
        }
    }

    public void remplaceActivite(Stage monStage, String oldKey, String newKey, Activite newActivite) {
        if (!monStage.getListeActivite().containsKey(oldKey)) {
            System.out.println("Le stage à remplacer n'existe pas");
        } else {
            this.removeActivité(monStage, oldKey);
            this.addActivite(monStage, newKey, newActivite);
        }
    }

    public void createActivite() {      //TODO, se baser sur Stage

    }

    public static void main(String[] args) {


    }
}
