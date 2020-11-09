package be.technifutur.java2020.gestionStage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractControleur {

    public LocalDateTime saisieDate(){
        String formatDate = "dd/MM/yyyy HH:mm";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(formatDate);
        String date = new Scanner(System.in).nextLine();
        Pattern pat = Pattern.compile("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9][0-9][0-9][0-9]) ([0-1][0-9]|2[0-3]):([0-5][0-9])");
        Matcher match = pat.matcher(date);
        boolean valid = match.matches();
        while (!valid) {
            System.out.println("Date non valide, recommence");
            date = new Scanner(System.in).nextLine();
            match = pat.matcher(date);
            valid = match.matches();
        }
        LocalDateTime maDate = LocalDateTime.parse(date, format);
        return maDate;
    }

    public boolean isDateValid(LocalDateTime debut, LocalDateTime fin) {
        boolean ok = false;
        if (fin.isBefore(debut) || debut.isBefore(LocalDateTime.now())) {
            System.out.println("Date invalide (antérieur au début ou au présent");
        } else {
            ok = true;
        }
        return ok;
    }

    public boolean contient(HashMap maMap, String key) {
        boolean contain = false;
        if (maMap.containsKey(key)){
            contain = true;
        }
        return contain;
    }
}
