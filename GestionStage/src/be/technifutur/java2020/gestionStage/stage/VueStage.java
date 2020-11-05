package be.technifutur.java2020.gestionStage.stage;

import java.util.List;


public class VueStage {

    public void AfficheListe(List maListe){
        for (int cpt = 0; cpt < maListe.size(); cpt++){
            System.out.println(maListe.get(cpt));
        }
    }
}
