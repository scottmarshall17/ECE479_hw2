package solution;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by Scott on 2/23/2017.
 */
public class Puzzle {
    private PriorityQueue visitingQueue;
    private HashSet<State> visited;
    State startState;
    State goalState;

    public Puzzle() {
        this.visited = new HashSet<State>(100);
        this.visitingQueue = new PriorityQueue(100, new StateComparator()); //TODO: insert comparator here and make sure it is functionally correct
        int[] start = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] end = {3, 1, 2, 4, 0, 5, 6, 7, 8};
        this.startState = new State(start);
        this.goalState = new State(end);
    }
    public Puzzle(State start, State finish) {
        this.visited = new HashSet<State>(100);
        this.visitingQueue = new PriorityQueue(100, new StateComparator());
        this.startState = start;
        this.goalState = finish;
    }



}
