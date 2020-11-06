package be.technifutur.java202.gestionStage.utility;

public class SaisieException extends Throwable {
    public SaisieException(String errorMessage) {
        super(errorMessage);
    }

    public SaisieException(String errorMessage, Exception cause) {
        super(errorMessage,cause);
    }
}
