package be.technifutur.java2020.gestionStage.stage;

import java.util.List;
import java.util.Scanner;

public class ControleurStage {

    public void addStage(List maListe, Stage monStage){
        maListe.add(monStage);
    }

    public void removeStage(List maListe) {
        String stageName;
        boolean presence = false;
        System.out.println("Quel stage voulez-vous retirer ?");
        Scanner sc = new Scanner(System.in);
        stageName = sc.nextLine();
        for (int cpt = 0 ; cpt <= maListe.size() ; cpt++) {
            if (maListe.get(cpt).equals(stageName)) {
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
