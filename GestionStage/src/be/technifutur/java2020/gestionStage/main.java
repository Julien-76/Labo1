package be.technifutur.java2020.gestionStage;

import be.technifutur.java2020.gestionStage.stage.ControleurStage;
import be.technifutur.java2020.gestionStage.stage.ListeStage;
import be.technifutur.java2020.gestionStage.stage.VueStage;

public class main {

    public static void main(String[] args) {
        ControleurStage control = new ControleurStage();
        ListeStage maliste = new ListeStage();
        VueStage vue = new VueStage();
        Menu menuPrincipal = new Menu();
        control.menuPrincipal(control, maliste.getListeStage(), vue, menuPrincipal);
    }
}
