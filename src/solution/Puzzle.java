package solution;

import java.util.*;

/**
 * Created by Scott on 2/23/2017.
 */
public class Puzzle {
    private PriorityQueue<State> visitingQueue;
    private HashMap<State, State> visited;
    State startState;
    State goalState;
    Heuristic heuristic;

    public Puzzle() {
        this.visited = new HashMap<State, State>(100);
        this.visitingQueue = new PriorityQueue<State>(100, new StateComparator()); //TODO: insert comparator here and make sure it is functionally correct
        int[] start = {1, 2, 3, 0, 4, 5, 6, 7, 8};
        int[] end = {1, 2, 3, 4, 7, 5, 6, 8, 0};
        this.startState = new State(start);
        this.goalState = new State(end);
        this.heuristic = new DisplacedTiles();
    }
    public Puzzle(State start, State finish, Heuristic h) {
        this.visited = new HashMap<State, State>(100);
        this.visitingQueue = new PriorityQueue<State>(100, new StateComparator());
        this.startState = start;
        this.goalState = finish;
        this.heuristic = h;
    }

    public boolean solve() {
        boolean result = false;
        int iteration = 0;
        Stack<State> solutionPath = new Stack<State>();
        State currState;
        State tempState;
        visitingQueue.add(this.startState);
        while (!visitingQueue.isEmpty()) {
            currState = visitingQueue.poll();
            if (currState.equals(this.goalState)) {
                System.out.println("A solution was found!");
                System.out.println("The solution was found in " + currState.getG() + " steps");
                currState.setIteration(iteration);
                solutionPath.push(currState);
                tempState = currState.getFrom();
                while (tempState != null) {
                    solutionPath.push(tempState);
                    tempState = this.visited.get(tempState);
                }
                this.printSolution(solutionPath);
                result = true;
                break;
            }
            else if (visited.containsKey(currState)) {
                continue;
            }
            else {
                if (currState.moveUp()) {
                    tempState = new State(currState);
                    currState.moveDown();
                    tempState.setFrom(currState);
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(this.heuristic.calculateH(tempState, this.goalState));
                    if (!this.visited.containsKey(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }
                if (currState.moveRight()) {
                    tempState = new State(currState);
                    currState.moveLeft();
                    tempState.setFrom(currState);
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(this.heuristic.calculateH(tempState, this.goalState)); //TODO: add a heuristic here
                    if (!this.visited.containsKey(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }

                if (currState.moveDown()) {
                    tempState = new State(currState);
                    currState.moveUp();
                    tempState.setFrom(currState);
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(this.heuristic.calculateH(tempState, this.goalState)); //TODO: add a heuristic here
                    if (!this.visited.containsKey(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }

                if (currState.moveLeft()) {
                    tempState = new State(currState);
                    currState.moveRight();
                    tempState.setFrom(currState);
                    tempState.setG(currState.getG() + 1);
                    tempState.setH(this.heuristic.calculateH(tempState, this.goalState)); //TODO: add a heuristic here
                    if (!this.visited.containsKey(tempState)) {
                        this.visitingQueue.add(tempState);
                    }
                }

                currState.setIteration(iteration);
                visited.put(currState, currState.getFrom());
                iteration++;
            }

        }
        return result;
    }

    private void printSolution(Stack<State> solution) {
        State tempState;
        while (!solution.isEmpty()) {
            tempState = solution.pop();
            System.out.println(tempState + "; G: " + tempState.getG() + ", H: " + this.heuristic.calculateH(tempState, this.goalState) + ", Iteration: " + tempState.getIteration());
        }
        return;
    }

    public State[] order() { //Required method for assignment. Deprecated by priority queue
        State[] result = this.visitingQueue.toArray(new State[0]);
        Arrays.sort(result, new StateComparator());
        return result;
    }

}
