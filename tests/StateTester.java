import org.junit.Assert;
import org.junit.Test;
import solution.*;

import java.util.Arrays;

/**
 * Created by Scott on 2/23/2017.
 */
public class StateTester {

    @Test
    public void stateConstructorTester() {
        State s1 = new State();
        int[] s1_arr = {0,0,0,0,0,0,0,0,0};
        int[] s2_arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        State s2 = new State(s2_arr);

        Assert.assertTrue(Arrays.equals(s1.getState(), s1_arr));
        Assert.assertFalse(s2_arr.equals(s2.getState()));
        Assert.assertTrue(Arrays.equals(s2.getState(), s2_arr));
    }

    @Test
    public void stateStringTester() {
        int[] s1_arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        State s1 = new State(s1_arr);

        String intendedResult = "1, 2, 3, 4, 5, 6, 7, 8, 9";
        Assert.assertEquals(true, s1.toString().equals(intendedResult));

    }

    @Test
    public void stateHashCodeTester() {
        int[] s1_arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] s2_arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] s3_arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        State s1 = new State(s1_arr);
        State s2 = new State(s2_arr);
        State s3 = new State(s3_arr);

        Assert.assertEquals(s1.hashCode(), s2.hashCode());
        Assert.assertNotEquals(s1.hashCode(), s3.hashCode());
    }

    @Test
    public void comparatorTest() {
        int[] s1_arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] s2_arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        State s1 = new State(s1_arr, 1, 3);
        State s2 = new State(s2_arr, 2, 2);
        State s3 = new State(s2_arr, 1, 1);
        StateComparator comparator = new StateComparator();

        Assert.assertEquals(0, comparator.compare(s1, s2));
        Assert.assertEquals(1, comparator.compare(s1, s3));
        Assert.assertEquals(-1, comparator.compare(s3, s2));
    }

    @Test
    public void moveTester() {
        int[] s1_arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] s2_arr = {1, 2, 3, 4, 0, 5, 6, 7, 8};
        State s1 = new State(s1_arr, 1, 3);
        State s2 = new State(s2_arr, 2, 2);

        Assert.assertFalse(s1.moveUp());

    }
}
