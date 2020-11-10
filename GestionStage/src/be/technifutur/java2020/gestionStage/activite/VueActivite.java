package be.technifutur.java2020.gestionStage.activite;

import be.technifutur.java2020.gestionStage.AbstractVue;
import be.technifutur.java2020.gestionStage.Menu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class VueActivite extends AbstractVue {



    public void afficheMenu(){
        System.out.println("Que veux-tu faire ?");
        Menu menuPrincipal = new Menu();
        menuPrincipal.menuPrincipal();
        menuPrincipal.afficheListeValeurs();
    }

    public boolean isStageValid(LinkedHashMap maMap, String key) {
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

