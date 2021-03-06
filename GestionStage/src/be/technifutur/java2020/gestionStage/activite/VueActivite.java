package be.technifutur.java2020.gestionStage.activite;
import be.technifutur.java2020.gestionStage.AbstractVue;
import be.technifutur.java2020.gestionStage.Menu;

import java.util.Map;
import java.util.Scanner;

public class VueActivite extends AbstractVue {



    public void afficheMenu(Menu menuStage){
        System.out.println("Que veux-tu faire ?");
        menuStage.menuStage();
        menuStage.afficheListeValeurs();
    }

    public boolean isStageValid(Map<String, ?> maMap, String key) {
        boolean currentStage;
        Scanner sc = new Scanner(System.in);
        if (!maMap.containsKey(key)) {
            currentStage = false;
        } else {
            currentStage = true;
        }
        return currentStage;
    }
    }

