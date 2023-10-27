package dk.dtu.CDIOg18.dicegame;

public class Player {

    private String name;
    private Account account;

    public Player(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
