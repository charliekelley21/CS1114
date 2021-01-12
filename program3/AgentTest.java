// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Charles Kelley (charlk21)
import sofia.micro.*;
import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 *  This tests the Agent subclass of the Actor class.
 *  These tests test the methods that allow the agent
 *  class to check whether it is happy in its lcoation
 *  and the methods to determine if it can move to a
 *  place where it will be satisfied.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.03.21
 */
public class AgentTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * City object for setup.
     */
    private Agent elephant1;
    private Agent elephant2;
    private Agent elephant3;
    private Agent monkey1;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AgentTest test object.
     */
    public AgentTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        City space = new City(5, 5);
        elephant1 = new Agent("elephant", 0.4);
        space.add(elephant1, 1, 2);
        elephant2 = new Agent("elephant", 0.4);
        space.add(elephant2, 1, 3);
        elephant3 = new Agent("elephant", 0.4);
        space.add(elephant3, 2, 0);
        Agent elephant4 = new Agent("elephant", 0.4);
        space.add(elephant4, 3, 0);
        monkey1 = new Agent("monkey", 0.4);
        space.add(monkey1, 2, 2);
        Agent monkey2 = new Agent("monkey", 0.4);
        space.add(monkey2, 2, 3);
    }
    
    // ----------------------------------------------------------
    
    /**
     * Check act(), assuming that the elephant is not
     * satisfied with its current location.
     */
    public void testActUnsatisfied()
    {
        elephant1.act();
        assertEquals(elephant1.getGridX(), 0);
        assertEquals(elephant1.getGridY(), 2);
        assertTrue(elephant1.isSatisfied());
    }
    /**
     * Check act(), assuming that the elephant is
     * satisfied with its current location.
     */
    public void testActSatisfied()
    {
        elephant3.act();
        assertEquals(elephant3.getGridX(), 2);
        assertEquals(elephant3.getGridY(), 0);
        assertTrue(elephant3.isSatisfied());
    }
    /**
     * Check populate() method such that it fills a 2x2 world
     * with 25% elephants and 25% monkeys.
     */
    public void testPopulate()
    {
        City frontier = new City(2, 2);
        Random.generator().setNextDoubles(0.89, 0.02, 0.47, 0.99);
        frontier.populate(0.25, 0.25, 0.5);
        int monkeyCount = 0;
        int elephantCount = 0;
        int nullCount = 0;
        for (int i = 0; i < frontier.getWidth(); i++)
        {
            for (int j = 0; j < frontier.getHeight(); j++)
            {
                Agent agent = frontier.getOneObjectAt(i, j, Agent.class);
                if (agent != null)
                {
                    if ((agent.getKind()).equals("elephant"))
                    {
                        elephantCount++;
                    }
                    if ((agent.getKind()).equals("monkey"))
                    {
                        monkeyCount++;
                    }
                }
                else
                {
                    nullCount++;
                }
            }
        }
        double percentageElephant = (double) elephantCount / 
            (frontier.getWidth() * frontier.getHeight());
        double percentageMonkey = (double) monkeyCount / 
            (frontier.getWidth() * frontier.getHeight());
        double percentageNull = (double) nullCount / 
            (frontier.getWidth() * frontier.getHeight());
        assertEquals(0.25, percentageElephant, 0.01);
        assertEquals(0.25, percentageMonkey, 0.01);
        assertEquals(0.50, percentageNull, 0.01);
    }
    /**
     * Check getKind() method for an agent object.
     */
    public void testGetKind()
    {
        String elephantKind = elephant1.getKind();
        assertEquals(elephantKind, "elephant");
    }
    /**
     * Check getThreshold() method for an agent object.
     */
    public void testGetThreshold()
    {
        double elephantThreshold = elephant1.getThreshold();
        assertEquals(elephantThreshold, 0.4, 0.01);
    }
    /**
     * Check isSameAs() method for two agents who are of
     * the same kind.
     */
    public void testIsSameKindAsTrue()
    {
        boolean sameKind = elephant1.isSameKindAs(elephant2);
        assertTrue(sameKind);
    }
    /**
     * Check isSameAs() method for two agents who are of
     * a different kind.
     */
    public void testIsSameKindAsFalse()
    {
        boolean sameKind = elephant1.isSameKindAs(monkey1);
        assertFalse(sameKind);
    }
    /**
     * Check isSatisfied() method for an elephant that is
     * satisfied with it location.
     */
    public void testIsSatisfiedHereTrue()
    {
        boolean satisfactionHere = elephant3.isSatisfied();
        assertTrue(satisfactionHere);
    }
    /**
     * Check isSatisfied() method for an elephant that is
     * unsatisfied with it location.
     */
    public void testIsSatisfiedHereFalse()
    {
        boolean satisfactionHere = elephant1.isSatisfied();
        assertFalse(satisfactionHere);
    }
    /**
     * Check isSatisfiedAt() method for an elephant that is
     * satisfied with (x, y) location.
     */
    public void testIsSatisfiedAtXYTrue()
    {
        boolean satisfactionXY = elephant1.isSatisfiedAt(2, 1);
        assertTrue(satisfactionXY);
    }
    /**
     * Check isSatisfiedAt() method for an elephant that is
     * unsatisfied with (x, y) location.
     */
    public void testIsSatisfiedAtXYFalse()
    {
        boolean satisfactionXY = elephant2.isSatisfiedAt(2, 4);
        assertFalse(satisfactionXY);
    }
    /**
     * Check relocate() method for an object that will move
     * to a spot that satisfies it.
     */
    public void testRelocate()
    {
        elephant1.relocate();
        assertEquals(elephant1.getGridX(), 0);
        assertEquals(elephant1.getGridY(), 2);
        assertTrue(elephant1.isSatisfied());
    }
}
