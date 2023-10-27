package dk.dtu.CDIOg18.dicegame;
public class RaffleCup {
    
    private Die[] dice;

    public RaffleCup(Die[] dice) {
        this.dice = dice;
    }

    public int[] roll() {
        int[] results = new int[dice.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = dice[i].roll();
        }
        return results;
    }
}
