import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  test fire ant class.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class FireAntTest extends TestCase
{
    //~ Fields ................................................................
    private FireAnt test;
    private Colony myColony;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FireAntTest test object.
     */
    public FireAntTest()
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
        test = new FireAnt();
        myColony = new Colony();
        myColony.add(test, 2, 2);
    }


    // ----------------------------------------------------------
    /**
     * tests injure that does kill fire ant.
     */
    public void testInjureAlive()
    {
        test.setHealth(2);
        test.injure(1);
        assertNotNull(myColony.getOneObjectAt(2, 2, FireAnt.class));
    }

    
    /**
     * tests injure that does kill fire ant.
     */
    public void testInjureDead()
    {
        test.injure(1);
        assertNull(myColony.getOneObjectAt(2, 2, FireAnt.class));
    }
    
    
    /**
     * tests injure that does kill fire ant.
     */
    public void testInjureDeadKillOthers()
    {
        HarvesterAnt test1 = new HarvesterAnt();
        myColony.add(test1, 3, 2);
        test.injure(4);
        assertNull(myColony.getOneObjectAt(2, 2, FireAnt.class));
        assertNull(myColony.getOneObjectAt(3, 2, HarvesterAnt.class));
    }
}
