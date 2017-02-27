import org.junit.Test;
import solution.Puzzle;

/**
 * Created by Scott on 2/26/2017.
 */
public class PuzzleTester {
    @Test
    public void branchingFactorTester() {
        Puzzle aPuzzle = new Puzzle();
        System.out.println(aPuzzle.calculateBranchingFactor(5, 52));
    }
}
