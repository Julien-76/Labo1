package be.technifutur.java2020.gestionStage;

import be.technifutur.java2020.gestionStage.stage.*;

import java.time.LocalDateTime;
import java.util.Comparator;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
       ControleurStage control = new ControleurStage();
       ListeStage maliste = new ListeStage();
       VueStage vue = new VueStage();
       Menu menuPrincipal = new Menu();
       control.menuPrincipal(control, maliste.getListeStage(), vue, menuPrincipal);
    }
 }
