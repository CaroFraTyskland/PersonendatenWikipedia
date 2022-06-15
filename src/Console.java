import java.util.Scanner;

public class Console {

    private static String BIRTH_INDICATOR = "*"; //'*' oder 'geboren am'
    private String firstName;
    private String lastName;
    private DateValue birthday;
    private String birthPlace;
    private String description;
    private Gender gender;

    public static void main(String[] args) {
        Console console = new Console();
    }

    public Console() {
        getInfo();
        printArticle();
    }

    private void getInfo() {
        Scanner stringScanner = new Scanner(System.in);

        System.out.print("Vorname(n): ");
        firstName = stringScanner.nextLine();

        System.out.print("Nachname: ");
        lastName = stringScanner.nextLine();

        gender = getGender(stringScanner);

        System.out.print("Kurzbeschreibung (z. B. \"schwedische Schauspielerin\"): ");
        description = stringScanner.nextLine();

        birthday = getBirthday(stringScanner);

        System.out.print("Geburtsort: ");
        birthPlace = stringScanner.nextLine();
    }

    public void printArticle() {
        String pd = Personendaten.getPersonendaten(lastName, firstName, description, birthday, birthPlace);

        String birthInfo = getBirthInfo(birthday, birthPlace);

        System.out.println("[[Datei:|mini|alt=|" + firstName + " " + lastName + "]]");
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
        System.out.println("[[Kategorie:" + gender.getWikipediaCategory() + "]]");
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

    private static Gender getGender(Scanner stringScanner) {
        Gender g = null;

        while (g == null) {
            System.out.print("Geschlecht (m,w,d): ");
            String input = stringScanner.nextLine();

            g = Gender.getGenderByName(input);
        }

        return g;
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
            String indicator = BIRTH_INDICATOR;

            if (indicator.equals("geboren am")) {
                indicator = "geboren";
            }

            birthInfo = "(" + indicator + " in [[" + birthPlace + "]])";
        }

        return birthInfo;
    }

}
