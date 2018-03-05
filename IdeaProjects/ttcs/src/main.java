import java.util.Scanner;

public class main implements Runnable {

    public Player p1;
    public Player p2;
    public Board gBoard;
    public Scanner inputPos;
    public RefreshHandler updater;
    public Player curPlayer;
    public Thread trd;

    public static void main(String[] args) {
        new main();
        System.out.println("unnamed");
    }

    public main() {
        p1 = new Player(1, 'x');
        p2 = new Player(2, 'y');
        gBoard = new Board();
        inputPos = new Scanner(System.in);
        updater = new RefreshHandler();

        System.out.println("Pick a name for Player 1: ");
        String p1name = inputPos.nextLine();
        p1.setName(p1name);
        System.out.println("Pick a name for Player 2: ");
        String p2name = inputPos.nextLine();
        p2.setName(p2name);

        System.out.println("The index for the Board is as follows: ");
        gBoard.printIndex();
        System.out.println("Game Begins NOW!\n");

        trd = new Thread(this);
        trd.start();


    }

    public void run() {
        System.out.println("New thread");

        while (gBoard.gameState) {

            gBoard.printBoard();

            if (!p1.activeTurn && !p2.activeTurn) {
                p1.activeTurn = true;
                curPlayer = p1;
            } else if (p1.activeTurn) {
                p1.activeTurn = false;
                p2.activeTurn = true;
                curPlayer = p2;
            } else {
                p1.activeTurn = true;
                p2.activeTurn = false;
                curPlayer = p1;
            }

            int placeIndex;

            while (true) {
                System.out.println("Input the index at which you wish to place your maker " + curPlayer.playerName);
                int inputtedIndex;

                try {
                    inputtedIndex = inputPos.nextInt() - 1;
                } catch (Exception e) {
                    System.err.println("ERROR U FUCKED UP");
                    inputPos.next();
                    continue;
                }

                if (!(inputtedIndex >= 0 && inputtedIndex <= 8)) continue;
                if (gBoard.available(inputtedIndex)) {
                    placeIndex = inputtedIndex;
                    break;
                }
                else {
                    System.out.println("Position already filled");
                }
            }

            gBoard.state[placeIndex] = curPlayer.playerNum;
            gBoard.gameState = updater.gameStateUpdate(gBoard);

            if (updater.winnerExists(gBoard)) {
                gBoard.printBoard();
                System.out.println("The WINNER is " + curPlayer.playerName);
            } else if (updater.boardFilled(gBoard)) {
                gBoard.printBoard();
                System.out.println("Oh no ONLY CHRISTINA SUCKS!");
            }
        }
        inputPos.close();
    }

}


