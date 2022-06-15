public enum Gender {

    FEMALE("sie", "Frau", "eine"),
    MALE("er", "Mann", "ein"),
    NON_BINARY("?", "Nichtbinäre Person", "eine/r");

    private final String pronoun;
    private final String wikipediaCategory;
    private final String article;

    Gender(String pronoun, String wikipediaCategory, String article) {
        this.pronoun = pronoun;
        this.wikipediaCategory = wikipediaCategory;
        this.article = article;
    }

    public String getPronoun(String lastName) {
        if (this == NON_BINARY) {
            return lastName;
        }

        return pronoun;
    }

    public String getWikipediaCategory() {
        return wikipediaCategory;
    }

    public String getArticle() {
        return article;
    }

    public static Gender getGenderByName(String input) {
        return switch (input.toLowerCase()) {
            case "m", "male", "mann" -> MALE;
            case "f", "w", "female", "frau" -> FEMALE;
            case "d", "other", "divers", "o", "nb" -> NON_BINARY;
            default -> null;
        };
    }
}
