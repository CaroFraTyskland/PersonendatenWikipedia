public class Personendaten {

    public static String getPersonendaten(String lastName, String firstName, String description, DateValue birthday, String birthPlace) {
        return "{{Personendaten\n" +
                "|NAME=" + lastName + ", " + firstName + "\n" +
                "|ALTERNATIVNAMEN=\n" +
                "|KURZBESCHREIBUNG=" + description + "\n" +
                "|GEBURTSDATUM=" + birthday.getDateWithoutLinks() + "\n" +
                "|GEBURTSORT=[[" + birthPlace + "]]\n" +
                "|STERBEDATUM=\n" +
                "|STERBEORT=\n" +
                "}}";
    }

}
