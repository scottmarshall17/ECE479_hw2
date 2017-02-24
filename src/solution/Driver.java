package solution;

/**
 * Created by Scott on 2/23/2017.
 */
public class Driver {
    public static void main(String[] args) {
        Puzzle simplePuzzle = new Puzzle();
        int[] start_arr = {1, 2, 3, 0, 4, 5, 6, 7, 8};
        int[] goal_arr = {4, 1, 2, 7, 8, 3, 6, 0, 5};
        State complexStart = new State(start_arr);
        State complexGoal = new State(goal_arr);
        Puzzle complexPuzzle = new Puzzle(complexStart, complexGoal, new DisplacedTiles());

        simplePuzzle.solve();
        complexPuzzle.solve();

        return;
    }
}
