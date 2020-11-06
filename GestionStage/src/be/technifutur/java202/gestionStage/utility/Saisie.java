package be.technifutur.java202.gestionStage.utility;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Saisie<T> implements Supplier<Optional<T>> {

    private String prompt = " value : ";
    private Supplier<String> supplierInput;
    private Predicate<String> predicate = (s)->true;
    private Function<String, T> mapper = (s)->null;
    private String errorMessage = "error";
    private String cancelString = null;

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setSupplierInput(Supplier<String> supplierInput) {
        this.supplierInput = supplierInput;
    }

    public void setPredicate(Predicate<String> predicate) {
        this.predicate = predicate;
    }

    public void setMapper(Function<String, T> mapper) {
        this.mapper = mapper;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setCancelString(String cancelString) {
        this.cancelString = cancelString;
    }

    public Optional<T> get() {
        Optional<T> s = null;
        do {
            try {
                s = saisie();
            } catch (SaisieException e) {
                System.out.println(this.errorMessage);
            }

        } while (s == null);
        return s;
    }

    private Optional<T> saisie() throws SaisieException {
        Optional<T> saisie;
        System.out.print(prompt);
        String input = supplierInput.get();
        try {
            if (predicate.test(input)) {
                saisie = Optional.of(mapper.apply(input));
            } else {
                if (input.equals(cancelString)) {
                    saisie = Optional.empty();
                } else {
                    throw new SaisieException(this.errorMessage);
                }
            }
        } catch (Exception e) {
            throw new SaisieException(this.errorMessage, e);
        }

    return saisie;
    }
}
