import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  tests hungry ant class.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class HungryAntTest extends TestCase
{
    //~ Fields ................................................................

    private HungryAnt test;
    private Colony myColony;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HungryAntTest test object.
     */
    public HungryAntTest()
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
        test = new HungryAnt();
        myColony = new Colony();
        myColony.add(test, 2, 2);
    }


    // ----------------------------------------------------------
    /**
     * test act method()
     */
    public void testAct()
    {
        Bee test1 = new Bee();
        myColony.add(test1, 2, 2);
        test.act();
        assertNull(myColony.getOneObjectAt(2, 2, Bee.class));
    }
    
    
    /**
     * test act method()
     */
    public void testActEating()
    {
        Bee test1 = new Bee();
        myColony.add(test1, 2, 2);
        test.act();
        Bee test2 = new Bee();
        myColony.add(test2, 2, 2);
        test.act();
        assertEquals(myColony.getObjectsAt(2, 2, Bee.class).size(), 1);
    }

}
