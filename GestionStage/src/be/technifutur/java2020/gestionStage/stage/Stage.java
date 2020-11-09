package be.technifutur.java2020.gestionStage.stage;
import be.technifutur.java2020.gestionStage.activite.Activite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Stage {

    private String nom, txtDebut, txtFin;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private HashMap<String, Activite> listeActivite; //bug introuvable si private


    public Stage (String nom, LocalDateTime debut, LocalDateTime fin) {
        this.nom = nom;
        this.dateDebut = debut;
        this.dateFin = fin;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String nDebut = debut.format(formatter);
        String nFIn = fin.format(formatter);
        this.txtDebut = nDebut;
        this.txtFin = nFIn;
        listeActivite = new HashMap<>();
    }

    public void addActivite(Activite monActivite) {
        this.listeActivite.put(monActivite.getName(), monActivite);
    }

    public void removeActivite(String key) {
        this.listeActivite.remove(key);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDetaFin() {
        return dateFin;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public String getTxtDebut() {
        return txtDebut;
    }

    public String getTxtFin() {
        return txtFin;
    }

    public HashMap<String, Activite> getListeActivite() {
        return listeActivite;
    }
}
