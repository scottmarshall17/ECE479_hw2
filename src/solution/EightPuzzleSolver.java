package solution;

import java.io.*;

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
        Puzzle puzzleCreator = new Puzzle();
        int[] moveCreator = {5, 10, 15};

        //Read in the input file
        File file = new File("inputFile.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine;
            String[] puzzleString;
            State puzzleStart;
            Puzzle myPuzzle;
            int[] goalState_arr = {1, 2, 3, 8, 0, 4, 7, 6, 5};
            State goalState = new State(goalState_arr);
            int[] puzzleMoves = new int[9];
            int problemNumber = 0;
            while ((fileLine = bufferedReader.readLine()) != null) {
                puzzleString = fileLine.split(",");
                for (int i = 0; i < puzzleString.length; i++) {
                    puzzleMoves[i] = Integer.parseInt(puzzleString[i]);
                }
                puzzleStart = new State(puzzleMoves);
                myPuzzle = new Puzzle(puzzleStart, goalState, new ManhattanDistance());
                myPuzzle.solve("stdout");
                problemNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        simplePuzzle.solve();
        complexPuzzle.solve();
        manhattanPuzzle.solve();
        hardestPuzzle.solve();
        puzzleCreator.createProblemSet(moveCreator, 5);
        */

        return;
    }
}
