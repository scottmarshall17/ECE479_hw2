package solution;

import java.lang.*;

/**
 * Created by Scott on 2/23/2017.
 */
public class State {
    private int[] state;
    int g_x;
    int h_x;

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

    public int[] getState() {
        return this.state;
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

}
