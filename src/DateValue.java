public class DateValue {

    private final String userInput;
    private int year;
    private Month month;
    private int day;

    public DateValue(String userInput) {
        this.userInput = userInput.trim();

        if (!userInput.equals("-")) {
            String[] array = userInput.split("-");

            year = Integer.parseInt(array[0]);

            if (!array[1].equals("?")) {
                month = Month.getMonthByNumber(Integer.parseInt(array[1]));
            } else { //month = ?
                month = null;
            }

            if (!array[2].equals("?")) {
                day = Integer.parseInt(array[2]);
            }
        }
    }

    /**
     * [[x. Month]] [[Year]], [[Month]] [[Year]], [[Year]] or "";
     *
     * @return the date
     */
    public String getDateWithLinks() {
        if (userInput.equals("-")) {
            return "";
        }

        if (month == null) { //xxxx-?-?
            return "[[" + year + "]]";
        } else if (day == 0) { //xxxx-xx-?
            return "[[" + month + "]] [[" + year + "]]";
        }

        return "[[" + day + ". " + month + "]] [[" + year + "]]";
    }

    public String getDateWithoutLinks() {
        if (userInput.equals("-")) {
            return "";
        }

        if (month == null) {
            return Integer.toString(year);
        } else if (day == 0) {
            return month + " " + year;
        }

        return "" + day + ". " + month + " " + year;
    }

    public int getYear() {
        return year;
    }

    /**
     * Whether or not the birthday is known (- or not)
     * @return birthday known or not
     */
    public boolean isSet(){
        return !userInput.equals("-");
    }

    //accepts -, 2000-12-31, 2000-1-05, 2000-?-? or 2000-1-?
    public static AcceptMessage acceptUserInput(String userInput) {
        if (userInput.trim().equals("-")) {
            return new AcceptMessage(true);
        }

        String[] array = userInput.trim().split("-");
        if (array.length != 3) {
            return new AcceptMessage(false, "Datumsformat inkorrekt: Weder '-' noch drei Zahlen.");
        }

        int month = 0;
        int day = 0;

        try {
            Integer.parseInt(array[0]);

            if (!array[1].equals("?")) {
                month = Integer.parseInt(array[1]);
            }
            if (!array[2].equals("?")) {
                day = Integer.parseInt(array[2]);
            }
        } catch (NumberFormatException e) {
            return new AcceptMessage(false, "Datum enthält Nicht-Zahlwert.");
        }

        if (array[1].equals("?")) {
            return new AcceptMessage(true);
        }

        Month monthObject = Month.getMonthByNumber(month);

        if (monthObject == null) {
            return new AcceptMessage(false, "Ungültiger Monatswert.");
        }

        if (array[2].equals("?")) {
            return new AcceptMessage(true);
        }

        if (Month.acceptDay(monthObject, day)) {
            return new AcceptMessage(true);
        }

        return new AcceptMessage(false, "Ungültiger Tag.");
    }
}
