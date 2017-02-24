package solution;

import java.util.Comparator;

/**
 * Created by Scott on 2/23/2017.
 */
public class StateComparator implements Comparator<State> {
    public int compare(State s1, State s2) {
        int result = 0;
        if (s1.getF() < s2.getF()) {
            result = -1;
        }
        else if (s1.getF() == s2.getF()) {
            result = 0;
        }
        else {
            result = 1;
        }
        return result;
    }

}
