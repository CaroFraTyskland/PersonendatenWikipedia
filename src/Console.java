import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);

        System.out.print("Vorname(n): ");
        String firstName = stringScanner.nextLine();

        System.out.print("Nachname: ");
        String lastName = stringScanner.nextLine();

        System.out.print("Kurzbeschreibung (z. B. \"schwedische Schauspielerin\"): ");
        String description = stringScanner.nextLine();

        System.out.print("Geburtstag (Jahr): ");
        String birthYear = stringScanner.nextLine();

        System.out.print("Geburtstag (Monat): ");
        String birthMonth = stringScanner.nextLine();

        System.out.print("Geburtstag (Tag): ");
        String birthDay = stringScanner.nextLine();

        System.out.print("Geburtsort: ");
        String birthPlace = stringScanner.nextLine();

        String pd = "{{Personendaten\n" +
                "|NAME=" + lastName + ", " + firstName + "\n" +
                "|ALTERNATIVNAMEN=\n" +
                "|KURZBESCHREIBUNG=" + description + "\n" +
                "|GEBURTSDATUM=" + birthDay + ". " + birthMonth + " " + birthYear + "\n" +
                "|GEBURTSORT=[[" + birthPlace + "]], Norwegen\n" +
                "|STERBEDATUM=\n" +
                "|STERBEORT=\n" +
                "}}";

        System.out.println(firstName + " " + lastName + " (* [[" + birthDay + ". " + birthMonth + "]] [[" + birthYear + "]]) ist ein " + description + "." +
                "\n\n== Leben ==" +
                "\n\n== Weblinks ==" +
                "\n{{Commonscat}}" +
                "\n\n== Einzelnachweise ==" +
                "\n<references />" +
                "\n\n{{Normdaten|TYP=p|GND=|LCCN=|VIAF=|GNDfehlt=ja|GNDCheck=}}" +
                "\n\n{{SORTIERUNG:" + lastName + ", " + firstName + "}}" +
                "\n[[Kategorie:Geboren " + birthYear + "]]" +
                "\n\n" + pd);
    }

}
