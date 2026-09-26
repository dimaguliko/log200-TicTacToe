import java.util.ArrayList;
import java.util.Stack;

// IMPORTANT : Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas).
class Board
{
    private Mark[][] board;
    private ArrayList<Move> coupsPossibles;
    private Stack<Move> coupsJoues;

    // Ne pas changer la signature de cette méthode
    public Board() {
        coupsPossibles = new ArrayList<>();
        board = new Mark[3][3];
        coupsJoues = new Stack<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = Mark.EMPTY;
                coupsPossibles.add(new Move(i, j));
            }
        }
    }

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    //
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark){
        board[m.getRow()][m.getCol()] = mark;
        Move newMove = new Move(m.getRow(), m.getCol());
        coupsPossibles.remove(newMove);
        coupsJoues.push(newMove);
    }

    public void unplay(){
        Move move = coupsJoues.pop();
        board[move.getRow()][move.getCol()] = Mark.EMPTY;
        coupsPossibles.add(move);
    }


    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark){
        Mark winner = isAWin();
        if(winner == mark){
            return 100;

        } else if(winner != Mark.EMPTY){
            return -100;
        }
        return 0; // Match nul ou la partie continue.
    }

    public ArrayList<Move> coupsPossibles(){
        return coupsPossibles;
    }

    public Mark isAWin(){
        // Lignes
        for (Mark[] marks : board) {
            if (marks[0] != Mark.EMPTY &&
                marks[0] == marks[1] && marks[0] == marks[2]) {
                return marks[0];
            }
        }

        // Colonnes
        for(int j = 0; j < board[0].length; j++){
            if(board[0][j] != Mark.EMPTY &&
               board[0][j] == board[1][j] && board[0][j] == board[2][j]){
                return board[0][j];
            }
        }

        // Condition du milieu pour les deux diagonales
        if(board[1][1] == Mark.EMPTY) return Mark.EMPTY;

        // Diagonale 1
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            return board[1][1];
        }

        // Diagonale 2
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return board[1][1];
        }

        return Mark.EMPTY;
    }
}
