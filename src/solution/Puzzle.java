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
    Heuristic heuristic;

    public Puzzle() {
        this.visited = new HashSet<State>(100);
        this.visitingQueue = new PriorityQueue<State>(100, new StateComparator()); //TODO: insert comparator here and make sure it is functionally correct
        int[] start = {1, 2, 3, 0, 4, 5, 6, 7, 8};
        int[] end = {1, 2, 3, 4, 7, 5, 6, 8, 0};
        this.startState = new State(start);
        this.goalState = new State(end);
        this.heuristic = new DisplacedTiles();
    }
    public Puzzle(State start, State finish, Heuristic h) {
        this.visited = new HashSet<State>(100);
        this.visitingQueue = new PriorityQueue(100, new StateComparator());
        this.startState = start;
        this.goalState = finish;
        this.heuristic = h;
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
                System.out.println("The solution was found in " + currState.getG() + " steps");
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
                    tempState.setH(this.heuristic.calculateH(tempState, this.goalState)); //TODO: add a heuristic here
                    if (!this.visited.contains(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }
                if (currState.moveRight()) {
                    tempState = new State(currState);
                    currState.moveLeft();
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(this.heuristic.calculateH(tempState, this.goalState)); //TODO: add a heuristic here
                    if (!this.visited.contains(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }

                if (currState.moveDown()) {
                    tempState = new State(currState);
                    currState.moveUp();
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(this.heuristic.calculateH(tempState, this.goalState)); //TODO: add a heuristic here
                    if (!this.visited.contains(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }

                if (currState.moveLeft()) {
                    tempState = new State(currState);
                    currState.moveRight();
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(this.heuristic.calculateH(tempState, this.goalState)); //TODO: add a heuristic here
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
