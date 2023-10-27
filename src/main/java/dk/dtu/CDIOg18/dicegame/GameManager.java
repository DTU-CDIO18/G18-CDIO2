package dk.dtu.CDIOg18.dicegame;

public class GameManager {

    private Player[] players;
    private int activePlayerIndex = 0;

    public GameManager(Player[] players) {
        this.players = players;
    }

    public void resetPlayerIndex() {
        activePlayerIndex = 0;
    }

    public Player getActivePlayer() {
        return players[activePlayerIndex];
    }

    public void switchToNextPlayer() {
        if (activePlayerIndex + 1 > players.length - 1) {
            activePlayerIndex = 0;
            return;
        }
        activePlayerIndex++;
    }
}
