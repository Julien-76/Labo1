package be.technifutur.java2020.gestionStage;

import java.util.LinkedHashMap;

public class AbstractVue {

    public void afficheListe(LinkedHashMap maListe){

        System.out.println(maListe.keySet().toString());

    }
}
