// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Charles Kelley (charlk21)
import sofia.micro.*;
import sofia.micro.jeroo.*;
import static sofia.micro.jeroo.CompassDirection.*;
import static sofia.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *  This test case is to test all methods of the MazeRunner subclass.
 *  The objectuve of these tests is to verify if all three methods of
 *  the MazeRunner subclass work towards the solution to the rubric
 *  of Program 1.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.02.15
 */
public class MazeRunnerTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Test the myProgram() method on 100 different iterations of the MazeIsland
     */
    public void testMyProgram()
    {
        int caseCounter;
        caseCounter = 0;
        while (caseCounter != 100)
        {
            // 1. Set up initial conditions
            Island island = new MazeIsland(caseCounter + 1);
            MazeRunner wally = new MazeRunner();
            island.add(wally, (island.getWidth() - 2), 
                (island.getHeight() - 2));
            //2. Call the method(s) you are testing
            wally.myProgram();
            caseCounter = caseCounter + 1;
            //3. Make assertions capturing your expected outcomes
            assertEquals(1, wally.getGridX());
            assertEquals(1, wally.getGridY());
            assertEquals(0, island.getObjects(Flower.class).size());
            assertEquals(0, island.getObjects(Net.class).size());
        }
    }
    /**
     * Test the hugRightWall() method on all iterations of MazeIsland such that
     * the MazeRunner starts in the south east and ends in the northwest.
     */
    public void testHugRightWallRepeated()
    {
        int caseCounter;
        caseCounter = 0;
        while (caseCounter != 100)
        {
            // 1. Set up initial conditions
            Island island = new MazeIsland(75);
            MazeRunner wally = new MazeRunner();
            island.add(wally, 3, 10);
            //2. Call the method(s) you are testing
            wally.hugRightWall(1, 1);
            //3. Make assertions capturing your expected outcomes
            assertEquals(1, wally.getGridX());
            assertEquals(1, wally.getGridY());
            caseCounter = caseCounter + 1;
        }
    }
    /**
     * Test the hugRightWall() method on an empty island to test if the loop
     * is skipped and operates properly.
     */
    public void testHugRightWallSkipped()
    {
        // 1. Set up initial conditions
        Island island = new Island();
        MazeRunner wally = new MazeRunner();
        island.add(wally, 1, 1);
        //2. Call the method(s) you are testing
        wally.hugRightWall(1, 1);
        //3. Make assertions capturing your expected outcomes
        assertEquals(1, wally.getGridX());
        assertEquals(1, wally.getGridY());
    }
    /**
     * Test the lookBeforeHop() method on the 75th iteration of MazeIsland
     * when the path is clear.
     */
    public void testLookBeforeHopClear()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(75);
        MazeRunner wally = new MazeRunner();
        island.add(wally, 1, 1);
        //2. Call the method(s) you are testing
        wally.lookBeforeHop();
        //3. Make assertions capturing your expected outcomes
        assertEquals(2, wally.getGridX());
        assertEquals(1, wally.getGridY());
    }
    /**
     * Test the lookBeforeHop() method on the 75th iteration of MazeIsland
     * when the path is Blocked by water.
     */
    public void testLookBeforeHopWater()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(75);
        MazeRunner walter = new MazeRunner();
        island.add(walter, 3, 11);
        //2. Call the method(s) you are testing
        walter.lookBeforeHop();
        //3. Make assertions capturing your expected outcomes
        assertEquals(3, walter.getGridX());
        assertEquals(11, walter.getGridY());
    }
    /**
     * Test the lookBeforeHop() method on the 75th iteration of MazeIsland
     * when the path is Blocked by a Net.
     */
    public void testLookBeforeHopNet()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(75);
        MazeRunner walter = new MazeRunner();
        island.add(walter, 2, 7);
        //2. Call the method(s) you are testing
        walter.lookBeforeHop();
        //3. Make assertions capturing your expected outcomes
        assertEquals(2, walter.getGridX());
        assertEquals(7, walter.getGridY());
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
