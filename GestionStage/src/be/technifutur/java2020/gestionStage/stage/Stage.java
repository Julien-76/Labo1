package be.technifutur.java2020.gestionStage.stage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Stage {
    private String nom, debut, fin;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    public static void main(String[] args) {
        LocalDateTime a = LocalDateTime.of(2020,05,12,16,00);
        LocalDateTime b = LocalDateTime.of(2020,05,12,16,01);
        int c = a.compareTo(b);
        System.out.println(c);
    }

    public Stage (String nom, LocalDateTime debut, LocalDateTime fin) {
        if (debut.compareTo(fin) > 0) {
            System.out.println("Date de fin antérieur à celle du début...");
        } else {
            this.nom = nom;
            this.dateDebut = debut;
            this.dateFin = fin;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String nDebut = debut.format(formatter);
            String nFIn = fin.format(formatter);
            this.debut = nDebut;
            this.fin = nFIn;
        }
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

    public void setKey(String nom) {
        this.nom = nom;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }
}
