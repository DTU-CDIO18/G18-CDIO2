package dk.dtu.dicegame;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class GameTest 
{
    @Test
    public void testForAccountBalanceNotGoingNegative() {
        Account account = new Account(0);
        account.takeMoney(1);
        assertTrue(account.getBalance() == 0);
    }

    @Test
    public void testPlayerSwitchToNextPlayer() {
        Player player1 = new Player("Test1", new Account(0));
        Player player2 = new Player("Test2", new Account(0));

        GameManager gameManager = new GameManager(new Player[] {player1, player2});
        assertTrue(gameManager.getActivePlayer().equals(player1));
        gameManager.switchToNextPlayer();
        assertTrue(gameManager.getActivePlayer().equals(player2));
        gameManager.switchToNextPlayer();
        assertTrue(gameManager.getActivePlayer().equals(player1));
    }

    @RepeatedTest(100)
    public void testDie() {
        Die die1 = new Die(6);

        int dieRoll = die1.roll();

        assertTrue(dieRoll <= 6 && dieRoll >= 1);
    }

    @RepeatedTest(100)
    public void testRaffleCup() {
        RaffleCup raffleCup = new RaffleCup(new Die[] { new Die(6), new Die(6) });

        int[] raffleCupRoll = raffleCup.roll();

        assertTrue(raffleCupRoll.length == 2);

        int raffleCupRollSum = raffleCupRoll[0] + raffleCupRoll[1];
        assertTrue(raffleCupRollSum >= 2 && raffleCupRollSum <= 12);
    }
}
