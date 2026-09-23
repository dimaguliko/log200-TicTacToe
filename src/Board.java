import java.util.ArrayList;
import java.util.Stack;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board
{
    private Mark[][] board;
    public ArrayList<Move> coupsPossibles;
    public Stack<Move> coupsJoues;

    // Ne pas changer la signature de cette méthode
    public Board() {
        coupsPossibles = new ArrayList<>();
        board = new Mark[2][2];
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
        coupsJoues.pop();
    }


    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark){

    }

    public ArrayList<Move> coupsPossibles(){
        return coupsPossibles;
    }
}
