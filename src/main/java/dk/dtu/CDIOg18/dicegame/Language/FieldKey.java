package dk.dtu.CDIOg18.dicegame.Language;

public enum FieldKey implements LanguageKey {

    TOWER("TOWER"),
    CRATER("CRATER"),
    PALACE_GATES("PALACE_GATES"),
    COLD_DESERT("COLD_DESERT"),
    WALLED_CITY("WALLED_CITY"),
    MONASTERY("MONASTERY"),
    BLACK_CAVE("BLACK_CAVE"),
    HUTS_IN_THE_MOUNTAIN("HUTS_IN_THE_MOUNTAIN"),
    WEREWOLF_WALL("WEREWOLF_WALL"),
    THE_PIT("THE_PIT"),
    GOLDMINE("GOLDMINE");

    final String prefix = "Field";
    String key;

    FieldKey(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return prefix + "." + key;
    }
    
}
