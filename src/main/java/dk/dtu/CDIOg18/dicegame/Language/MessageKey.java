package dk.dtu.CDIOg18.dicegame.Language;

public enum MessageKey implements LanguageKey {
    ASK_FOR_RESTART("ASK_FOR_RESTART"),
    PLAYER_ROLLED_DICE("PLAYER_ROLLED_DICE"),
    PLAYER_LOST_AMOUNT("PLAYER_LOST_AMOUNT"),
    PLAYER_GOT_AMOUNT("PLAYER_GOT_AMOUNT"),
    PLAYER_TURN_NOTICE("PLAYER_TURN_NOTICE"),
    PLAYER_NAME_STARTUP("PLAYER_NAME_STARTUP"),
    PLAYER_BALANCE_INFO("PLAYER_BALANCE_INFO"),
    PLAYER_EXTRA_TURN("PLAYER_EXTRA_TURN"),
    PLAYER_DICE_ROLL_FAILURE("PLAYER_DICE_ROLL_FAILURE"),
    GAME_RESTART("Message.GAME_RESTART"),
    PLAYER_WON("PLAYER_WON");
    

    final String prefix = "Message";
    String key;

    MessageKey(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return prefix + "." + key;
    }


}
