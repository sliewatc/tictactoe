public class RefreshHandler {

    public Player currentPlayer(Player p1, Player p2) {
        if (p1.activeTurn) return p1;
        else return p2;
    }

    public boolean gameStateUpdate(Board curBoard) {
        if (boardFilled(curBoard)) return false;
        else if (winnerExists(curBoard)) return false;
        else return true;
    }

    public boolean boardFilled(Board b) {
        for (int pos : b.state) {
            if (pos == 0) return false;
        }
        return true;
    }

    public boolean winnerExists(Board b) {
        int s[] = b.state;
        // Row equality check
        if ((s[0] != 0 && s[0] == s[1] && s[0] == s[2]) || (s[3] != 0 && s[3] == s[4] && s[3] == s[5]) || (s[6] != 0 && s[6] == s[7] && s[6] == s[8])) {
            return true;
        }
        // Column equality check
        else if ((s[0] != 0 && s[0] == s[3] && s[0] == s[6]) || (s[1] != 0 && s[1] == s[4] && s[1] == s[7]) || (s[2] != 0 && s[2] == s[5] && s[2] == s[8])) {
            return true;
        }
        // Diagonal equality check
        else if ((s[0] != 0 && s[0] == s[4] && s[0] == s[8]) || (s[2] != 0 && s[2] == s[4] && s[2] == s[6])) {
            return true;
        }
        else return false;
    }
}
