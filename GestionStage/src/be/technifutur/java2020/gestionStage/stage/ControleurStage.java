package be.technifutur.java2020.gestionStage.stage;

import java.time.LocalDateTime;
import java.util.List;


public class ControleurStage {

    public void addStage(List maListe, String name, LocalDateTime debut, LocalDateTime fin){
        boolean doublon = false;
        Stage monStage = new Stage(name, debut, fin);
            if (maListe.contains(monStage)) {
                System.out.println("Le stage existe déjà");
            }else {
                maListe.add(monStage);
                monStage.setDateDebut(debut);
                monStage.setDateFin(fin);
                System.out.println("Le stage " + monStage.getNom() + " a bien été ajouté");
        }
    }

    public void removeStage(List maListe, Stage monStage) {
        boolean presence = false;
        if (maListe.contains(monStage)) {
            presence = true;
            maListe.remove(maListe.indexOf(monStage));
        }
        if (presence) {
            System.out.println("Le Stage " + monStage.getNom() + " a bien été retiré");
        }else {
            System.out.println("Aucun stage correspondant");
        }
    }

    public void remplaceStage(List maListe, Stage oldStage, Stage newStage) {
        if (!maListe.contains(oldStage)) {
            System.out.println("Le stage à remplacer n'existe pas");
        }else {
            maListe.set(maListe.indexOf(oldStage), newStage);
            System.out.println("Le Stage " + oldStage.getNom() + " a bien été remplacé par le stage " + newStage.getNom());
        }
    }
}
