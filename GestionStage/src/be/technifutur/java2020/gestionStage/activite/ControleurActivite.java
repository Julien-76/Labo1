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

    public void removeActivité() {      //TODO, se baser sur Stage

    }

    public void replaceActivite() {     //TODO, se baser sur Stage

    }

    public void createActivite() {      //TODO, se baser sur Stage

    }

    public static void main(String[] args) {


    }
}
