package dk.dtu.CDIOg18.dicegame.TranslationManager;

public enum Output implements TranslationId {
    player_turn,
    game_over,
    ;

    @Override
    public String id() {
        return String.format("Output.%s", this.name());
    }
}