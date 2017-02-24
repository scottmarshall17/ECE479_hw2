package solution;

/**
 * Created by Scott on 2/23/2017.
 */
public class EightPuzzleSolver {
    public static void main(String[] args) {
        Puzzle simplePuzzle = new Puzzle();
        int[] start_arr = {1, 2, 3, 0, 4, 5, 6, 7, 8};
        int[] goal_arr = {4, 1, 2, 7, 8, 3, 6, 0, 5};
        int[] hardest_arr = {8, 6, 7, 2, 5, 4, 3, 0, 1};
        int[] hardest_goal = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        State complexStart = new State(start_arr);
        State complexGoal = new State(goal_arr);
        State hardStart = new State(hardest_arr);
        State hardGoal = new State(hardest_goal);
        Puzzle complexPuzzle = new Puzzle(complexStart, complexGoal, new DisplacedTiles());
        Puzzle manhattanPuzzle = new Puzzle(complexStart, complexGoal, new ManhattanDistance());
        Puzzle hardestPuzzle = new Puzzle(hardStart, hardGoal, new ManhattanDistance());


        simplePuzzle.solve();
        complexPuzzle.solve();
        manhattanPuzzle.solve();
        hardestPuzzle.solve();

        return;
    }
}
