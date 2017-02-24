package solution;

/**
 * Created by Scott on 2/24/2017.
 */
public class DisplacedManhattan implements Heuristic {
    @Override
    public int calculateH(State current, State goal) {
        int result = 0;
        ManhattanDistance manhattan = new ManhattanDistance();
        DisplacedTiles displaced = new DisplacedTiles();
        result = manhattan.calculateH(current, goal) + displaced.calculateH(current, goal);
        return result;
    }
}
