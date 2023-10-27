package dk.dtu.CDIOg18.dicegame;

import dk.dtu.CDIOg18.dicegame.Language.FieldKey;

public enum Field {

    TOWER(2, FieldKey.TOWER, 250, false),
    CRATER(3, FieldKey.CRATER, -100, false),
    PALACE_GATES(4, FieldKey.PALACE_GATES, 100, false),
    COLD_DESERT(5, FieldKey.COLD_DESERT, -20, false),
    WALLED_CITY(6, FieldKey.WALLED_CITY, 180, false),
    MONASTERY(7, FieldKey.MONASTERY, 0, false),
    BLACK_CAVE(8, FieldKey.BLACK_CAVE, -70, false),
    HUTS_IN_THE_MOUNTAIN(9, FieldKey.HUTS_IN_THE_MOUNTAIN, 60, false),
    WEREWOLF_WALL(10, FieldKey.WEREWOLF_WALL, -80, true),
    THE_PIT(11, FieldKey.THE_PIT, -50, false),
    GOLDMINE(12, FieldKey.GOLDMINE, 650, false);

    private int dieNumber;
    private FieldKey languageKey;
    private double amount;
    private boolean extraTurn;

    private Field(int dieNumber, FieldKey languageKey, double amount, boolean extraTurn) {
        this.dieNumber = dieNumber;
        this.languageKey = languageKey;
        this.amount = amount;
        this.extraTurn = extraTurn;
    }

    public int getDieNumber() {
        return dieNumber;
    }

    public FieldKey getLanguageKey() {
        return languageKey;
    }

    public double getAmount() {
        return amount;
    }

    public boolean givesExtraTurn() {
        return extraTurn;
    }

    public static Field getFieldFromDiceValue(int diceValue) {
        for (Field field : Field.values()) {
            if (field.getDieNumber() == diceValue) {
                return field;
            }
        }
        return null;
    }
}
