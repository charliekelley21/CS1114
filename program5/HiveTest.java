import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  tests hive class.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class HiveTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HiveTest test object.
     */
    public HiveTest()
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
        //
    }


    // ----------------------------------------------------------
    /**
     * tests act method
     */
    public void testAct()
    {
        Hive test = new Hive();
        Colony myColony = new Colony();
        myColony.add(test, 9, 3);
        run(myColony, 700);
        assertTrue(myColony.getObjects(Bee.class).size() > 0);
    }

}
