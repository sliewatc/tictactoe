public class Player {
    char type;
    int playerNum;
    String playerName;
    boolean activeTurn;

    public Player (int playerNum, char letterFill) {
        this.type = letterFill;
        this.playerNum = playerNum;
        this.activeTurn = false;
    }

    public void setName(String name) {
        this.playerName = name;
    }
}
