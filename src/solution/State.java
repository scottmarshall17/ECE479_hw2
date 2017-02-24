package solution;

import java.lang.*;
import java.util.ArrayList;

/**
 * Created by Scott on 2/23/2017.
 */
public class State {
    private int[] state;
    private State from;
    private int g_x;
    private int h_x;

    public State() {
        this.state = new int[9];
        this.g_x = 0;
        this.h_x = 0;
        for (int i = 0; i < 9; i++) {
            this.state[i] = 0;
        }
    }

    public State(int[] vals) {
        this.state = new int[9];
        this.g_x = 0;
        this.h_x = 0;
        System.arraycopy(vals, 0, this.state, 0, 9);
    }

    public State(int[] vals, int g, int h) {
        this.state = new int[9];
        this.g_x = g;
        this.h_x = h;
        System.arraycopy(vals, 0, this.state, 0, 9);
    }

    public State(State s) {
        this.state = new int[9];
        System.arraycopy(s.getState(), 0, this.state, 0, 9);
        this.h_x = s.getH();
        this.g_x = s.getG();
    }

    public int[] getState() {
        return this.state;
    }

    public State getFrom() {
        return this.from;
    }

    public void setFrom(State lastState) {
        this.from = lastState;
    }

    public int getH() {
        return this.h_x;
    }

    public int getG() {
        return this.g_x;
    }

    public int getF() {
        return this.g_x + this.h_x;
    }

    public void setH(int val) {
        this.h_x = val;
    }

    public void setG(int val) {
        this.g_x = val;
    }

    public boolean moveUp() {
        boolean result = true;
        int location = -1;
        for (int i = 0; i < 9; i++) {
            if (this.state[i] == 0) {
                location = i;
                break;
            }
        }
        int newRow = (location / 3) - 1;
        int newCol = (location % 3);

        if (newRow < 0 || newRow > 2 || newCol < 0 || newCol > 2) {
            result = false;
        }
        else {
            int newLocation = (newRow * 3) + newCol;
            this.state[location] = this.state[newLocation];
            this.state[newLocation] = 0;
        }

        return result;
    }

    public boolean moveLeft() {
        boolean result = true;
        int location = -1;
        for (int i = 0; i < 9; i++) {
            if (this.state[i] == 0) {
                location = i;
                break;
            }
        }
        int newRow = (location / 3);
        int newCol = (location % 3) - 1;

        if (newRow < 0 || newRow > 2 || newCol < 0 || newCol > 2) {
            result = false;
        }
        else {
            int newLocation = (newRow * 3) + newCol;
            this.state[location] = this.state[newLocation];
            this.state[newLocation] = 0;
        }

        return result;
    }

    public boolean moveRight() {
        boolean result = true;
        int location = -1;
        for (int i = 0; i < 9; i++) {
            if (this.state[i] == 0) {
                location = i;
                break;
            }
        }
        int newRow = (location / 3);
        int newCol = (location % 3) + 1;

        if (newRow < 0 || newRow > 2 || newCol < 0 || newCol > 2) {
            result = false;
        }
        else {
            int newLocation = (newRow * 3) + newCol;
            this.state[location] = this.state[newLocation];
            this.state[newLocation] = 0;
        }

        return result;
    }

    public boolean moveDown() {
        boolean result = true;
        int location = -1;
        for (int i = 0; i < 9; i++) {
            if (this.state[i] == 0) {
                location = i;
                break;
            }
        }
        int newRow = (location / 3) + 1;
        int newCol = (location % 3);

        if (newRow < 0 || newRow > 2 || newCol < 0 || newCol > 2) {
            result = false;
        }
        else {
            int newLocation = (newRow * 3) + newCol;
            this.state[location] = this.state[newLocation];
            this.state[newLocation] = 0;
        }

        return result;
    }

    public ArrayList<State> expand() {
        ArrayList<State> result = new ArrayList<State>();
        State tempState;

        if (this.moveUp()) {
            tempState = new State(this);
            this.moveDown();
            tempState.setG(this.getG() + 1);
            result.add(tempState);
        }
        if (this.moveRight()) {
            tempState = new State(this);
            this.moveLeft();
            tempState.setG(this.getG() + 1);
            result.add(tempState);
        }
        if (this.moveDown()) {
            tempState = new State(this);
            this.moveUp();
            tempState.setG(this.getG() + 1);
            result.add(tempState);
        }
        if (this.moveLeft()) {
            tempState = new State(this);
            this.moveRight();
            tempState.setG(this.getG() + 1);
            result.add(tempState);
        }

        return result;
    }

    public boolean equalState(Object s) {   //Required...
        return this.toString().equals(s.toString());
    }

    public String toString() {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < 8; i++) {
            result.append(this.state[i] + ", ");
        }

        result.append(this.state[8]);

        return result.toString();
    }

    public int hashCode() {
        int result = 7;
        result = result * 13;
        result += this.toString().hashCode();
        return result;
    }

    public boolean equals(Object s) {
        return this.toString().equals(s.toString());
    }

}
