import java.util.regex.*;
import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        String frase = lector.nextLine();
        Pattern pattern = Pattern.compile("(\\bE[-|\\s\\S]?[0-9]{4}[|\\s|\\-]?[A-Z]{3})|([0-9]{4}[-|\\s\\S]?[A-Z]{3}\\b)");
        Matcher matcher= pattern.matcher(frase);
        int len = frase.length();
        while ( matcher.find()){
            System.out.println(matcher.group());
        }

    }
}