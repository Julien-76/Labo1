package be.technifutur.java2020.gestionStage.activite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

public class Activite {

    private final String name, txtDebut, txtFin;
    private final LocalDateTime dateDebut, dateFin;
    private final int duree;  // en minutes
    private TreeSet<String> participantsActivite;

    public Activite(String name, LocalDateTime debut, int duree) {
        this.name = name;
        this.dateDebut = debut;
        this.duree = duree;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.txtDebut = formatter.format(dateDebut);
        this.dateFin = this.dateDebut.plusMinutes(this.duree);
        this.txtFin = formatter.format(dateFin);
    }

    public String getName() {
        return name;
    }

    public int getDuree() {
        return duree;
    }

    public String getTxtDebut() {
        return txtDebut;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public String getTxtFin() {
        return txtFin;
    }
}
