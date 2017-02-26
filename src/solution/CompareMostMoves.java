package solution;

import java.util.Comparator;

public class CompareMostMoves implements Comparator<State> {
    @Override
    public int compare(State o1, State o2) {
        if(o1.getG() > o2.getG()) {
            return -1;
        }
        else if (o1.getG() < o2.getG()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
