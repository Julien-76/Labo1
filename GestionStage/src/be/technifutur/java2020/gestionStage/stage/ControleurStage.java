package be.technifutur.java2020.gestionStage.stage;

import java.time.LocalDateTime;
import java.util.List;


public class ControleurStage {

    public void addStage(List maListe, String name, LocalDateTime debut, LocalDateTime fin){
        boolean doublon = false;
        Stage monStage = new Stage(name, debut, fin);

        for (int cpt = 0 ; cpt <= maListe.size() ; cpt++) {
            if (maListe.contains(monStage)) {
                System.out.println("Le stage existe déjà");
                doublon = true;
            }
        }
        if (doublon = false) {
            maListe.add(monStage);
            monStage.setDateDebut(debut);
            monStage.setDateFin(fin);
        }
    }

    public void removeStage(List maListe, Stage monStage) {
        boolean presence = false;
        for (int cpt = 0 ; cpt <= maListe.size() ; cpt++) {
            if (maListe.get(cpt) == monStage) {
                maListe.remove(cpt);
                presence = true;
            }
        }
        if (presence) {
            System.out.println("Le Stage a bien été retiré");
        }else {
            System.out.println("Aucun stage correspondant");
        }
    }
}
