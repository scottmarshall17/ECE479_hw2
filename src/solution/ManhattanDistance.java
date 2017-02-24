package solution;

/**
 * Created by Scott on 2/24/2017.
 */
public class ManhattanDistance implements Heuristic {
    @Override
    public int calculateH(State current, State goal) {
        int result = 0;
        int[] curr_arr = current.getState();
        int[] locations = new int[9];
        int[] goal_arr = goal.getState();
        int currRow = 0;
        int currCol = 0;
        int goalRow = 0;
        int goalCol = 0;
        int tempLocation = 0;

        for (int i = 0; i < 9; i++) {
            locations[curr_arr[i]] = i;
        }

        for (int i = 0; i < 9; i++) {
            if (goal_arr[i] != 0) {
                currRow = i / 3;
                currCol = i % 3;
                tempLocation = locations[goal_arr[i]];
                goalRow = tempLocation / 3;
                goalCol = tempLocation % 3;
                result += Math.abs(currRow - goalRow) + Math.abs(currCol - goalCol);
            }
        }

        return result;
    }
}
