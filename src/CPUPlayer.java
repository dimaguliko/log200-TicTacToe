import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer
{

    // Contient le nombre de noeuds visités (le nombre
    // d'appel à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;

    private Mark cpu;

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
        this.cpu = cpu;
    }

    // Ne pas changer cette méthode
    public int  getNumOfExploredNodes(){
        return numExploredNodes;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board)
    {
        numExploredNodes = 0;
        int val = miniMax(board, "MAX");
        return
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;

    }

    public int miniMax(Board board, String joueur){
        numExploredNodes++;
        if(!winPresent || board.coupsPossibles.isEmpty()) {
            return board.evaluate(feuille);
        }

        ArrayList<Move> coups = board.coupsPossibles();
        int meilleur;
        if(joueur.equals("MAX")){
            meilleur = Integer.MIN_VALUE;

            for(Move coup: coups){
               board.play(coup, cpu);
               int score = miniMax(board, "MIN");
               board.unplay();
               meilleur = Integer.max(meilleur, score);
            }

        } else {

            meilleur = Integer.MAX_VALUE;

            for(Move coup: coups){
                board.play(coup, cpu);
                int score = miniMax(board, "MAX");
                board.unplay();
                meilleur = Integer.min(meilleur, score);
            }
        }
    }

}
