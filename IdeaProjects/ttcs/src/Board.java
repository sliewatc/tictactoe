public class Board {

    int state[];
    boolean gameState;

    public Board() {
        this.state = new int[9];
        this.gameState = true;
    }

    public void addMark(int index, char playerMark) {
        if (state[index] == 0) {
            state[index] = playerMark;
        } else {
            System.out.println("Position Filled");
        }

    }

    public void completeTurn(Player p) {
        if (p.activeTurn) {
            p.activeTurn = false;
        }
    }

    public boolean available(int index) {
        return (this.state[index] == 0);
    }


    public void printBoard() {
        System.out.println(state[0] + "|" + state[1] + "|" + state[2]);
        System.out.println("-----");
        System.out.println(state[3] + "|" + state[4] + "|" + state[5]);
        System.out.println("-----");
        System.out.println(state[6] + "|" + state[7] + "|" + state[8]);
    }

    public void printIndex() {
        System.out.println(1 + "|" + 2 + "|" + 3);
        System.out.println("-----");
        System.out.println(4 + "|" + 5 + "|" + 6);
        System.out.println("-----");
        System.out.println(7 + "|" + 8 + "|" + 9);
    }

}
