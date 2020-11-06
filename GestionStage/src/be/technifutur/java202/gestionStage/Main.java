package be.technifutur.java202.gestionStage;

import be.technifutur.java202.gestionStage.Controler.CreationStage;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        CreationStage ctrl = factory.getCreatrionStage();
        ctrl.run();

    }
}
