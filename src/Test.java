import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Mark x = Mark.X;
        Mark o = Mark.O;
        Board board1 = new Board();
        CPUPlayer cpu1 = new CPUPlayer(o);

        Move m1 = new Move(0,0);
        Move m2 = new Move(1,0);
        Move m3 = new Move(2,0);

        Move m4 = new Move(0,1);
        Move m5 = new Move(1,1);
        Move m6 = new Move(2,1);

        Move m7 = new Move(0,2);
        Move m8 = new Move(1,2);
        Move m9 = new Move(2,2);

        board1.play(m1, x);
        board1.play(m5, o);
        board1.play(m2, x);

        ArrayList<Move> meilleursCoupsMinMax = cpu1.getNextMoveMinMax(board1);

        System.out.println("Board 1 : ");
        System.out.println("Best moves : ");
        for (Move coupsMinMax : meilleursCoupsMinMax) {
            System.out.println(coupsMinMax.getRow() + "i " + coupsMinMax.getCol() + "j");
        }
        System.out.println("Number of nodes explored with min-max : " + cpu1.getNumOfExploredNodes());
        System.out.println();

        Board board2 = new Board();
        CPUPlayer cpu2 = new CPUPlayer(x);
        board2.play(m5, o);
        board2.play(m1, x);
        board2.play(m3, o);
        board2.play(m7, x);
        board2.play(m4, o);
        board2.play(m6, x);
        board2.play(m8, o);
//        board2.play(m2, x);
//        board2.play(m9, o);
        ArrayList<Move> meilleursCoupsMinMax2 = cpu2.getNextMoveMinMax(board2);

        System.out.println("Board 2 : ");
        System.out.println("Best moves : ");
        for (Move coupsMinMax : meilleursCoupsMinMax2) {
            System.out.println(coupsMinMax.getRow() + "i " + coupsMinMax.getCol() + "j");
        }
        System.out.println("Number of nodes explored with min-max : " + cpu1.getNumOfExploredNodes());
    }
}
