package be.technifutur.java2020.gestionStage.stage;

import be.technifutur.java2020.gestionStage.AbstractMenu;

import java.util.LinkedHashMap;
import java.util.Map;

public class MenuStage extends AbstractMenu {

    private LinkedHashMap<String, String> listeChoix;


    public MenuStage() {
    listeChoix = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, String> getListeChoix() {
        return listeChoix;
    }
    


    public static void main(String[] args) {        //tests
        MenuStage monMenu = new MenuStage();
        monMenu.getListeChoix().put("1", "1. Jupiter");
        monMenu.getListeChoix().put("2", "2. Saturne");
        monMenu.getListeChoix().put("3", "3. Neptune");
        for (Map.Entry<String, String> entry : monMenu.getListeChoix().entrySet()) {
            String value = entry.getValue();
            System.out.println(value);
        }
    }

    //TODO créer une Map et afficher les valeurs sous forme de liste
    /* for (Map.Entry<String, String> entry : lang.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Clé: " + key + ", Valeur: " + value);
        } peut être utile */
}
