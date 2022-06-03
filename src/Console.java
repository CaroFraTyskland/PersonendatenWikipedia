import java.util.Scanner;

public class Console {

    private static String BIRTH_INDICATOR = "*"; //'*' oder 'geboren am'

    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);

        System.out.print("Vorname(n): ");
        String firstName = stringScanner.nextLine();

        System.out.print("Nachname: ");
        String lastName = stringScanner.nextLine();

        System.out.print("Kurzbeschreibung (z. B. \"schwedische Schauspielerin\"): ");
        String description = stringScanner.nextLine();

        DateValue birthday = getBirthday(stringScanner);

        System.out.print("Geburtsort: ");
        String birthPlace = stringScanner.nextLine();

        String pd = "{{Personendaten\n" +
                "|NAME=" + lastName + ", " + firstName + "\n" +
                "|ALTERNATIVNAMEN=\n" +
                "|KURZBESCHREIBUNG=" + description + "\n" +
                "|GEBURTSDATUM=" + birthday.getDateWithoutLinks() + "\n" +
                "|GEBURTSORT=[[" + birthPlace + "]]\n" +
                "|STERBEDATUM=\n" +
                "|STERBEORT=\n" +
                "}}";

        String birthInfo = getBirthInfo(birthday, birthPlace);

        System.out.println(firstName + " " + lastName + " " + birthInfo + " ist ein " + description + "." +
                "\n\n== Leben ==" +
                "\n\n== Weblinks ==" +
                "\n{{Commonscat}}" +
                "\n\n== Einzelnachweise ==" +
                "\n<references />" +
                "\n\n{{Normdaten|TYP=p|GND=|LCCN=|VIAF=|GNDfehlt=ja|GNDCheck=}}" +
                "\n\n{{SORTIERUNG:" + lastName + ", " + firstName + "}}");

        if (birthday.isSet()) {
            System.out.println("[[Kategorie:Geboren " + birthday.getYear() + "]]");
        }
        System.out.println("\n" + pd);
    }

    private static DateValue getBirthday(Scanner stringScanner) {
        DateValue birthday = null;
        boolean acceptInput = false;

        do {
            System.out.print("Geburtstag (-, 2020-12-31, 2020-?-?): ");
            String input = stringScanner.nextLine();
            AcceptMessage message = DateValue.acceptUserInput(input);

            if (message.isAccept()) {
                birthday = new DateValue(input);
                acceptInput = true;
            } else {
                System.out.println("Nicht akzeptiert: " + message.getMessage());
            }
        } while (!acceptInput);

        return birthday;
    }

    private static String getBirthInfo(DateValue birthday, String birthPlace) {
        String birthInfo = "";

        if (birthday.isSet()) {
            birthInfo = birthInfo + "(" + BIRTH_INDICATOR + " " + birthday.getDateWithLinks();

            if (birthPlace.equals("") || birthPlace.equals("-")) {
                birthInfo = birthInfo + ")";
            } else {
                birthInfo = birthInfo + " in [[" + birthPlace + "]])";
            }
        } else if (!(birthPlace.equals("") || birthPlace.equals("-"))) {
            birthInfo = "(" + BIRTH_INDICATOR + " in [[" + birthPlace + "]])";
        }

        return birthInfo;
    }

}
