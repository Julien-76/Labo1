package be.technifutur.java2020.gestionStage.stage;
import be.technifutur.java2020.gestionStage.Comparateur;
import be.technifutur.java2020.gestionStage.activite.Activite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Stage {

    private final String nom, txtDebut, txtFin;
    private final LocalDateTime dateDebut, dateFin;
    private final LinkedHashMap<String, Activite> listeActivite;
    private final TreeSet<Participant> participantsStage;


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
        participantsStage = new TreeSet<Participant>(new Comparateur());
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

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDetaFin() {
        return dateFin;
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

    public TreeSet<Participant> getParticipantsStage() {
        return participantsStage;
    }
}
