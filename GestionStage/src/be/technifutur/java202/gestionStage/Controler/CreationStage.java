package be.technifutur.java202.gestionStage.Controler;


import be.technifutur.java202.gestionStage.model.StageList;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Supplier;

public class CreationStage implements Runnable{

    private StageList stageList;
    private Supplier<Optional<String>> saisieName;
    private Supplier<Optional<LocalDateTime>> saisieDateDebut;
    private Supplier<Optional<LocalDateTime>> saisieDateFin;

    public void setStageList(StageList stageList) {
        this.stageList = stageList;
    }

    public void setSaisieName(Supplier<Optional<String>> saisieName) {
        this.saisieName = saisieName;
    }

    public void setSaisieDateDebut(Supplier<Optional<LocalDateTime>> saisieDateDebut) {
        this.saisieDateDebut = saisieDateDebut;
    }

    public void setSaisieDateFin(Supplier<Optional<LocalDateTime>> saisieDateFin) {
        this.saisieDateFin = saisieDateFin;
    }

    @Override
    public void run() {
        String name = this.saisieName.get().orElse("");
        LocalDateTime debut = this.saisieDateDebut.get().orElse(null);
        LocalDateTime fin = this.saisieDateFin.get().orElse(null);
        stageList.addStage(name, debut, fin);
    }
}
