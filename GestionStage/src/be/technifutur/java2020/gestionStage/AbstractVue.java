package be.technifutur.java2020.gestionStage;

import java.util.HashMap;

public class AbstractVue {

    public void afficheListe(HashMap maListe){
        System.out.println(maListe.keySet().toString());
    }
}
