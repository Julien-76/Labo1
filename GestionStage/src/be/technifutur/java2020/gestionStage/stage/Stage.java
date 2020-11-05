package be.technifutur.java2020.gestionStage.stage;
import java.time.LocalDateTime;

public class Stage {
    private String key;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;


    public Stage (String nom, LocalDateTime debut, LocalDateTime fin) {
        this.key = nom;
        this.dateDebut = debut;
        this.dateFin = fin;
    }

    public String getKey() {
        return key;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDetaFin() {
        return dateFin;
    }

    public void setKey(String nom) {
        this.key = nom;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }
}
