package be.technifutur.java2020.gestionStage.stage;
import java.time.LocalDateTime;

public class Stage {
    private String nom;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;


    public Stage (String nom, LocalDateTime debut, LocalDateTime fin) {
        this.nom = nom;
        this.dateDebut = debut;
        this.dateFin = fin;
    }

    public String getNom() {
        return nom;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDetaFin() {
        return dateFin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }
}
