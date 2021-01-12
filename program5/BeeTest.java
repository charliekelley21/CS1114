import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Tests the bee class.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class BeeTest extends TestCase
{
    //~ Fields ................................................................
    
    private Bee test;
    private Colony myColony;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BeeTest test object.
     */
    public BeeTest()
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
        test = new Bee();
        myColony = new Colony();
        myColony.add(test, 5, 2);
    }


    // ----------------------------------------------------------
    /**
     * test act method for bee class.
     */
    public void testActMove()
    {
        run(myColony, 80);
        assertTrue(5 > test.getGridX());
    }

    
    /**
     * test act() when block by an ant count = 0.
     */
    public void testActBlocked()
    {
        HarvesterAnt test2 = new HarvesterAnt();
        myColony.add(test2, 4, 2);
        run(myColony, 20);
        assertEquals(test2, myColony.getOneObjectAt(4, 2, HarvesterAnt.class));
    }
    
    
    /**
     * test act() when block by an ant count = 0.
     */
    public void testActBlockedSting()
    {
        HarvesterAnt test2 = new HarvesterAnt();
        myColony.add(test2, 4, 2);
        run(myColony, 100);
        assertNull(myColony.getOneObjectAt(4, 2, HarvesterAnt.class));
    }
}
