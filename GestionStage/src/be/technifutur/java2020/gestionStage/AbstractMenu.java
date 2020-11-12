package be.technifutur.java2020.gestionStage;

import java.util.LinkedHashMap;

public abstract class AbstractMenu {

    public boolean contient(LinkedHashMap maMap, int key) {
        boolean ok = false;
        if (maMap.containsKey(key)) {
            ok = true;
        }
        return ok;
    }

    public void addChoix(LinkedHashMap maMap, String key, String value){
        maMap.put(key, value);
    }
}
