package be.technifutur.java2020.gestionStage.stage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Stage {
    private String key;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    public static void main(String[] args) {
        LocalDateTime baba = LocalDateTime.of(2020,05,12,16,00);
        System.out.println(baba);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String nouvelleDate = baba.format(formatter);
        System.out.println(nouvelleDate);
    }

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
