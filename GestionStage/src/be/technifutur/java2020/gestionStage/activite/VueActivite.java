package be.technifutur.java2020.gestionStage.activite;

import be.technifutur.java2020.gestionStage.AbstractVue;

import java.util.HashMap;
import java.util.Scanner;

public class VueActivite extends AbstractVue {



    public void afficheMenu(){
        System.out.println("Que veux-tu faire ? \n1. Ajouter Activité\n2. Retirer Activité\n3. Remplacer Activité\n4. Afficher la liste des activités du Stage\n5. Afficher les détails d'une activité\n6. Retourner dans le menu principal");
    }

    public boolean isStageValid(HashMap maMap, String key) {
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

