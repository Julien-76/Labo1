package be.technifutur.java2020.gestionStage.stage;
import be.technifutur.java2020.gestionStage.activite.Activite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Stage {

    private String nom, txtDebut, txtFin;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private LinkedHashMap<String, Activite> listeActivite;


    public Stage (String nom, LocalDateTime debut, LocalDateTime fin) {
        this.nom = nom;
        this.dateDebut = debut;
        this.dateFin = fin;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String nDebut = debut.format(formatter);
        String nFIn = fin.format(formatter);
        this.txtDebut = nDebut;
        this.txtFin = nFIn;
        listeActivite = new LinkedHashMap<>();
    }

    public void addActivite(Activite monActivite) {
        if (!this.dateInZone(monActivite)){
            System.out.println("L'activité ne respecte pas l'horaire du Stage");
        }else {
            this.listeActivite.put(monActivite.getName(), monActivite);
            System.out.println("L'activité " + monActivite.getName() + " a bien été ajoutée");
        }
    }

    public void removeActivite(String key) {
        this.listeActivite.remove(key);
    }

    public boolean dateInZone(Activite monActivite) {
        boolean ok = false;
        if ((monActivite.getDateDebut().isAfter(this.getDateDebut())) &&
                (this.getDetaFin().isAfter(monActivite.getDateDebut().plusMinutes(monActivite.getDuree())))) {
            ok = true;
        }
        return ok;
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

    public LinkedHashMap<String, Activite> getListeActivite() {
        return listeActivite;
    }
}
