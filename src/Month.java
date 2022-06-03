public enum Month {

    JANUARY(1, "Januar", 31),
    FEBRUARY(2, "Februar", 29),
    MARCH(3, "März", 31),
    APRIL(4, "April", 30),
    MAY(5, "Mai", 31),
    JUNE(6, "Juni", 30),
    JULY(7, "Juli", 31),
    AUGUST(8, "August", 31),
    SEPTEMBER(9, "September", 30),
    OCTOBER(10, "Oktober", 31),
    NOVEMBER(11, "November", 30),
    DECEMBER(12, "Dezember", 31);

    final int number;
    final String name;
    final int maxDays;

    Month(int number, String name, int maxDays) {
        this.name = name;
        this.number = number;
        this.maxDays = maxDays;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public static Month getMonthByNumber(int number) {
        for (Month month : Month.values()) {
            if (month.getNumber() == number) {
                return month;
            }
        }

        return null;
    }

    public static Month getMonthByName(String nameOfMonth) {
        for (Month month : Month.values()) {
            if (month.getName().toLowerCase().equals(nameOfMonth.toLowerCase())) {
                return month;
            }
        }

        return null;
    }

    public static boolean acceptDay(Month month, int day) {
        return day <= month.getMaxDays() && day > 0;
    }

    public String toString() {
        return name;
    }

}
