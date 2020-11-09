package be.technifutur.java2020.gestionStage.stage;

import be.technifutur.java2020.gestionStage.AbstractVue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VueStage extends AbstractVue {

    public void afficheMenu(){
        System.out.println("Que veux-tu faire ? \n1. Ajouter Stage\n2. Retirer Stage\n3. Remplacer Stage\n4. Afficher la liste des Stages");
    }
}