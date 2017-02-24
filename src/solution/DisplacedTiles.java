package solution;

/**
 * Created by Scott on 2/24/2017.
 */
public class DisplacedTiles implements Heuristic {
    @Override
    public int calculateH(State current, State goal) {
        int result = 0;
        int[] curr_arr = current.getState();
        int[] goal_arr = goal.getState();
        for (int i = 0; i < 9; i++) { //Calculate the number of displaced tiles
            if (curr_arr[i] != 0) {
                if (curr_arr[i] != goal_arr[i]) {
                    result++;
                }
            }
        }
        return result;
    }
}
