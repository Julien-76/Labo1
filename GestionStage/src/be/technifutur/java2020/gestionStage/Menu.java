package be.technifutur.java2020.gestionStage;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {

    private LinkedHashMap<Integer, String> listeChoix;


    public Menu() {

        listeChoix = new LinkedHashMap<>();
    }

    public LinkedHashMap<Integer, String> getListeChoix() {
        return listeChoix;
    }

    public void menuPrincipal() {
        this.getListeChoix().put(1, "1. Ajouter Stage");
        this.getListeChoix().put(2, "2. Retirer Stage");
        this.getListeChoix().put(3, "3. Remplacer Stage");
        this.getListeChoix().put(4, "4. Afficher la liste des Stages");
        this.getListeChoix().put(5, "5. Aficher les détails d'un Stage");
        this.getListeChoix().put(6, "6. Entrer dans le Menu des Stages");
        this.getListeChoix().put(7, "7. Fermer l'application");
    }

    public void menuStage() {
        this.getListeChoix().put(1, "1. Ajouter Activité");
        this.getListeChoix().put(2, "2. Retirer Activité");
        this.getListeChoix().put(3, "3. Remplacer Activté");
        this.getListeChoix().put(4, "4. Afficher la liste des Activités");
        this.getListeChoix().put(5, "5. Afficher les détails d'une Activité");
        this.getListeChoix().put(6, "6. Revenir au Menu Principal");
    }

    public void afficheListeValeurs() {
        for (Map.Entry<Integer, String> entry : this.getListeChoix().entrySet()) {
            String value = entry.getValue();
            System.out.println(value);
        }
    }

    public boolean contient(LinkedHashMap maMap, int key) {
        boolean ok = false;
        if (maMap.containsKey(key)) {
            ok = true;
        }
        return ok;
    }
}



