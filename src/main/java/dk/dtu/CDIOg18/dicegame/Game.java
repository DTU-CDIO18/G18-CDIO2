package dk.dtu.CDIOg18.dicegame;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

import dk.dtu.CDIOg18.dicegame.Language.LanguageProcessor;
import dk.dtu.CDIOg18.dicegame.Language.MessageKey;

public class Game {

    private LanguageProcessor languageProcessor;
    Scanner scanner = new Scanner(System.in);
    private int numOfPlayers = 2;
    private int winningAmount = 3000;
    private double playerStartAmount = 2999;
    private boolean isRunning = false;
    private Player[] players;
    private GameManager gameManager;
    private RaffleCup raffleCup;
    private int sides = 6;

    public Game() {
        setup();
    }

    private void setup() {
        setupLanguage(new Locale("en"));
        setupPlayers(numOfPlayers, playerStartAmount);
        setupDice(sides);
    }

    private void setupLanguage(Locale locale) {
        languageProcessor = new LanguageProcessor(locale);
    }

    private void setupPlayers(int playerAmount, double startAmount) {
        players = new Player[playerAmount]; 

        for (int i = 0; i < playerAmount; i++) {
            System.out.print(languageProcessor.getString(MessageKey.PLAYER_NAME_STARTUP, i + 1) + ": ");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName, new Account(startAmount));
        }

        gameManager = new GameManager(players);
    }

    private void setupDice(int sides) {
        Die[] dice = {
            new Die(sides),
            new Die(sides)
        };

        raffleCup = new RaffleCup(dice);
    }

    public void startGame() {
        isRunning = true;
        
        while(isRunning) {
            Player player = gameManager.getActivePlayer();
            System.out.println(languageProcessor.getString(MessageKey.PLAYER_TURN_NOTICE, player.getName()));
            try {
                if(Integer.parseInt(scanner.nextLine()) != 1) {
                    System.out.println(languageProcessor.getString(MessageKey.PLAYER_DICE_ROLL_FAILURE));
                    continue;
                }
            } catch (Exception e) {
                System.out.println(languageProcessor.getString(MessageKey.PLAYER_DICE_ROLL_FAILURE));
                continue;
            }
            int[] diceResults = raffleCup.roll();
            int diceResultsSum = IntStream.of(diceResults).sum();
            
            System.out.println(languageProcessor.getString(MessageKey.PLAYER_ROLLED_DICE, player.getName(), diceResults[0], diceResults[1],  diceResultsSum));

            Field field = Field.getFieldFromDiceValue(diceResultsSum);

            System.out.println(languageProcessor.getString(field.getLanguageKey()));

            if(field.getAmount() < 0) {
                player.getAccount().takeMoney(-field.getAmount());
                System.out.println(languageProcessor.getString(MessageKey.PLAYER_LOST_AMOUNT, player.getName(), field.getAmount()));
            } else {
                player.getAccount().giveMoney(field.getAmount());
                System.out.println(languageProcessor.getString(MessageKey.PLAYER_GOT_AMOUNT, player.getName(), field.getAmount()));
            }
            
            System.out.println(languageProcessor.getString(MessageKey.PLAYER_BALANCE_INFO, player.getName(), player.getAccount().getBalance()));

            if(hasPlayerWon(player)) {
                System.out.println(languageProcessor.getString(MessageKey.PLAYER_WON, player.getName()));
                System.out.println(languageProcessor.getString(MessageKey.ASK_FOR_RESTART));
                boolean hasMadeChose = false;
                while (!hasMadeChose) {
                    int result = 0;
                    try {
                        result = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        hasMadeChose = false;
                    }
                    switch(result) {
                        case 1:
                            restartGame();
                            hasMadeChose = true;
                            break;
                        case 2:
                            endGame();
                            hasMadeChose = true;
                            break;
                    }
                } 
            }
            
            if(field.givesExtraTurn()) {
                System.out.println(languageProcessor.getString(MessageKey.PLAYER_EXTRA_TURN, player.getName()));
                System.out.println("==============================================");
                continue;
            }
            System.out.println("==============================================");
            gameManager.switchToNextPlayer();
        }
    }

    private void endGame() {
        scanner.close();
        isRunning = false;
    }

    private void restartGame() {

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(players[i].getName(), new Account(2990));
        }

        gameManager = new GameManager(players);
        System.out.println(languageProcessor.getString(MessageKey.GAME_RESTART));
        startGame();
    }

    private boolean hasPlayerWon(Player player) {
        return player.getAccount().getBalance() >= winningAmount;
    }
    
}