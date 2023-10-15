package dk.dtu.CDIOg18.dicegame.TranslationManager;

public enum Field implements TranslationId {
    Tower,
    Crater,
    Palace_Gates,
    Cold_Desert,
    Walled_City,
    Monastery,
    Black_Cave,
    Huts_in_the_mountain,
    The_Werewall,
    The_pit,
    Goldmine
    ;

    @Override
    public String id() {
        return String.format("Fields.%s", this.name());
    }
}