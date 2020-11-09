package be.technifutur.java2020.gestionStage.activite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Activite {

    private String name, txtDebut, txtFin;
    private LocalDateTime dateDebut, dateFin;
    private int duree;  // en minutes

    public Activite(String name, LocalDateTime debut, int duree) {
        this.name = name;
        this.dateDebut = debut;
        this.duree = duree;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String nDebut = dateDebut.format(formatter);
        this.txtDebut = nDebut;
        this.dateFin = this.dateDebut.plusMinutes(this.duree);
        String nFin = dateFin.format(formatter);
        this.txtFin = nFin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getTxtDebut() {
        return txtDebut;
    }

    public void setTxtDebut(String txtDebut) {
        this.txtDebut = txtDebut;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getTxtFin() {
        return txtFin;
    }
}
