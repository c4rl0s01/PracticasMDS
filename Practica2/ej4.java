import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ej4 {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        String frase = lector.nextLine();
        Pattern pattern = Pattern.compile("\\b(([a-z]{1,})\\.([a-z]{2,})@urjc\\.es)|\\b(([a-z]{1})\\.([a-z]{2,})\\.([0-9]{4})@alumnos\\.urjc\\.es)");
        Matcher matcher= pattern.matcher(frase);
        int len = frase.length();
        while ( matcher.find()){

            //Ante cualquier duda durante la resolución de la práctica, escribir un email a \href{mailto:isaac.lozano@urjc.es}{isaac.lozano@urjc.es} \textbf{con copia a} \href{mailto:raul.martin@urjc.es}{raul.martin@urjc.es}. En caso de no poderse resolver la duda vía mail, se puede concertar una tutoría, siempre y cuando se concierte en un período de \textbf{hasta 48 horas antes} de la fecha de entrega de la práctica. Correos de alumnos: c.barahona.2020@alumnos.urjc.es y i.gomeze.2019@alumnos.urjc.es
            if (matcher.group(1) != null ){
                System.out.println("profesor "+matcher.group(2)+" apellido "+matcher.group(3));
            }else{
               System.out.println("alumno "+matcher.group(6)+" matriculado en "+matcher.group(7));

            }

        }

    }
}
