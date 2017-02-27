package solution;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
            int problemSet = 0;
            int[] goalState_arr = {1, 2, 3, 8, 0, 4, 7, 6, 5};
            State goalState = new State(goalState_arr);
            int[] puzzleMoves = new int[9];
            int problemNumber = 0;
            while ((fileLine = bufferedReader.readLine()) != null) {
                problemSet = 1 + (problemNumber / 5);
                puzzleString = fileLine.split(",");
                for (int i = 0; i < puzzleString.length; i++) {
                    puzzleMoves[i] = Integer.parseInt(puzzleString[i]);
                }
                puzzleStart = new State(puzzleMoves);
                EightPuzzleSolver.printProblemHeader("OutfileHeuristic1.txt", problemSet, (problemNumber%5)+1);
                myPuzzle = new Puzzle(puzzleStart, goalState, new DisplacedTiles());
                myPuzzle.solve("OutfileHeuristic1.txt");
                EightPuzzleSolver.printProblemHeader("OutfileHeuristic2.txt", problemSet, (problemNumber%5)+1);
                myPuzzle = new Puzzle(puzzleStart, goalState, new ManhattanDistance());
                myPuzzle.solve("OutfileHeuristic2.txt");
                EightPuzzleSolver.printProblemHeader("OutfileHeuristic3.txt", problemSet, (problemNumber%5)+1);
                myPuzzle = new Puzzle(puzzleStart, goalState, new DisplacedManhattan());
                myPuzzle.solve("OutfileHeuristic3.txt");
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

    public static void printProblemHeader(String outputFileName, int problemSet, int problemNum) {
        String printString;
        int previousSet = problemSet - 1;
        if ( problemNum == 1 && problemSet == 1) {
            try {
                printString = "Start of Problem Set " + problemSet + "\n\tProblem " + problemNum + ", Set " + problemSet + "\n";
                Files.write(Paths.get(outputFileName), printString.getBytes(), StandardOpenOption.CREATE_NEW);
            }
            catch (IOException e) {
                try {
                    printString = "Start of Problem Set " + problemSet + "\n\tProblem " + problemNum + ", Set " + problemSet + "\n";
                    Files.write(Paths.get(outputFileName), printString.getBytes(), StandardOpenOption.APPEND);
                }
                catch (IOException f) {
                    f.printStackTrace();
                }
            }
        }
        else if (problemNum == 1) {
            try {
                printString = "\tEnd of Problem Set " + previousSet + "\nStart of Problem Set " + problemSet + "\n\tProblem " + problemNum + ", Set " + problemSet + "\n";
                Files.write(Paths.get(outputFileName), printString.getBytes(), StandardOpenOption.CREATE_NEW);
            }
            catch (IOException e) {
                try {
                    printString = "\tEnd of Problem Set " + previousSet + "\nStart of Problem Set " + problemSet + "\n\tProblem " + problemNum + ", Set " + problemSet + "\n";
                    Files.write(Paths.get(outputFileName), printString.getBytes(), StandardOpenOption.APPEND);
                }
                catch (IOException f) {
                    f.printStackTrace();
                }
            }
        }
        else {
            try {
                printString = "\tProblem " + problemNum + ", Set " + problemSet + "\n";
                Files.write(Paths.get(outputFileName), printString.getBytes(), StandardOpenOption.APPEND);
            }
            catch (IOException f) {
                f.printStackTrace();
            }
        }
    }
}
