package be.technifutur.java2020.gestionStage;

import be.technifutur.java2020.gestionStage.stage.Participant;

import java.util.Comparator;

public class Comparateur implements Comparator<Participant> {

    @Override
    public int compare(Participant p1, Participant p2) {
        int compare =  p1.getNom().compareTo(p2.getNom());
        if (compare == 0) {
            compare = p1.getPrenom().compareTo(p2.getPrenom());
        }
        return compare;
    }
}
