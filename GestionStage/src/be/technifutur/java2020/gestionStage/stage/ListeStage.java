package be.technifutur.java2020.gestionStage.stage;

import java.util.HashMap;


public class ListeStage {

   private HashMap<String, Stage> listeStage;

    public ListeStage () {
        listeStage = new HashMap<>();
    }
    public HashMap<String, Stage> getListeStage() {
        return listeStage;
    }


}
