package be.technifutur.java202.gestionStage;

import be.technifutur.java202.gestionStage.Controler.CreationStage;
import be.technifutur.java202.gestionStage.model.StageList;
import be.technifutur.java202.gestionStage.utility.Saisie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Supplier;

public class Factory {
    private CreationStage creationStage;
    private Saisie saisie;
    private Saisie<String> saisieName;
    private Supplier<String> user;
    private Saisie<LocalDateTime> saisieFin;
    private Saisie<LocalDateTime> saisieDebut;
    private StageList stageList;

    public CreationStage getCreatrionStage() {
        if (this.creationStage == null) {
            this.creationStage = new CreationStage();
            this.creationStage.setStageList(getStageList());
            this.creationStage.setSaisieDateDebut(getSaisieDebut());
            this.creationStage.setSaisieDateFin(getSaisieFin());
            this.creationStage.setSaisieName(getSaisieName());
        }
        return this.creationStage;
    }

    private Saisie<String> getSaisieName() {
        if (this.saisieName == null) {
            this.saisieName = new Saisie<String>();
            this.saisieName.setPrompt(" Nom : ");
            this.saisieName.setPredicate((s)-> s.trim().length()>0);
            this.saisieName.setMapper((s)-> s.trim());
            this.saisieName.setErrorMessage("le nom ne peut pas être vide");
            this.saisieName.setSupplierInput(getUser());
        }
        return this.saisieName;
    }

    private Supplier<String> getUser() {
        if(this.user == null) {
            user = new Supplier<String>() {
                private Scanner scan = new Scanner(System.in);

                @Override
                public String get() {
                    return scan.nextLine();
                }
            };
        }
        return user;
    }

    private Saisie<LocalDateTime> getSaisieFin() {
        if (this.saisieFin == null) {
            this.saisieFin = new Saisie<LocalDateTime>();
            this.saisieFin.setPrompt(" Date de fin ( j/m/aa hh:mm ) : ");
            this.saisieFin.setMapper(
                    (s)-> LocalDateTime.parse(s,getDateFormater()));
            this.saisieFin.setErrorMessage("la date ne respecte pas le format");
            this.saisieFin.setSupplierInput(getUser());
        }
        return this.saisieFin;
    }

    private DateTimeFormatter getDateFormater() {
        return DateTimeFormatter.ofPattern("d/M/yy H:mm");
    }

    private Saisie<LocalDateTime> getSaisieDebut() {
        if (this.saisieDebut == null) {
            this.saisieDebut = new Saisie<LocalDateTime>();
            this.saisieDebut.setPrompt(" Date de début ( j/m/aa hh:mm ) : ");
            this.saisieDebut.setMapper(
                    (s)-> LocalDateTime.parse(s,getDateFormater()));
            this.saisieDebut.setErrorMessage("la date ne respecte pas le format");
            this.saisieDebut.setSupplierInput(getUser());
        }
        return this.saisieDebut;
    }

    private StageList getStageList() {
        if (this.stageList == null) {
            this.stageList = new StageList();
        }
        return this.stageList;
    }
}
