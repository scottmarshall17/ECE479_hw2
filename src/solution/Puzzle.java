package solution;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by Scott on 2/23/2017.
 */
public class Puzzle {
    private PriorityQueue<State> visitingQueue;
    private HashSet<State> visited;
    State startState;
    State goalState;

    public Puzzle() {
        this.visited = new HashSet<State>(100);
        this.visitingQueue = new PriorityQueue<State>(100, new StateComparator()); //TODO: insert comparator here and make sure it is functionally correct
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

    public boolean solve() {
        boolean result = false;
        State currState;
        State tempState;
        visitingQueue.add(this.startState);
        while (!visitingQueue.isEmpty()) {
            currState = visitingQueue.poll();
            if (currState.equals(this.goalState)) {
                System.out.println("A solution was found!");
                result = true;
                break;
            }
            else if (visited.contains(currState)) {
                continue;
            }
            else {
                if (currState.moveUp()) {
                    tempState = new State(currState);
                    currState.moveDown();
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(0); //TODO: add a heuristic here
                    if (!this.visited.contains(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }
                if (currState.moveRight()) {
                    tempState = new State(currState);
                    currState.moveLeft();
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(0); //TODO: add a heuristic here
                    if (!this.visited.contains(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }

                if (currState.moveDown()) {
                    tempState = new State(currState);
                    currState.moveUp();
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(0); //TODO: add a heuristic here
                    if (!this.visited.contains(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }

                if (currState.moveLeft()) {
                    tempState = new State(currState);
                    currState.moveRight();
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(0); //TODO: add a heuristic here
                    if (!this.visited.contains(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }

                visited.add(currState);
            }

        }
        return result;
    }


}
