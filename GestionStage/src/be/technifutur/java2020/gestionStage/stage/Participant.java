package be.technifutur.java2020.gestionStage.stage;
import be.technifutur.java2020.gestionStage.AbstractControleur;
import be.technifutur.java2020.gestionStage.Menu;
import be.technifutur.java2020.gestionStage.activite.Activite;


public class Participant {

    private String nom, prenom;


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
