import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  tests ant class.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class AntTest extends TestCase
{
    //~ Fields ................................................................
    private Ant test;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AntTest test object.
     */
    public AntTest()
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
        test = new Ant();
    }


    // ----------------------------------------------------------
    
    /**
     * tests getHealth()
     */
    public void testGetHealth()
    {
        assertEquals(1, test.getHealth());
    }
    
    
    
    /**
     * tests setHealth()
     */
    public void testSetHealth()
    {
        test.setHealth(2);
        assertEquals(2, test.getHealth());
    }
    
    
    /**
     * tests getFoodCost()
     */
    public void testGetFoodCost()
    {
        assertEquals(4, test.getFoodCost());
    }
    
    
    /**
     * tests setFoodCost()
     */
    public void testSetFoodCost()
    {
        test.setFoodCost(2);
        assertEquals(2, test.getFoodCost());
    }
    
    /**
     * test injure() method when still alive after
     */
    public void testInjureAlive()
    {
        test.setHealth(2);
        test.injure(1);
        assertEquals(1, test.getHealth());
    }
    
    
    /**
     * test injure() method when ant dies
     */
    public void testInjureDead()
    {
        Colony myColony = new Colony();
        myColony.add(test, 2, 2);
        test.injure(1);
        assertEquals(0, test.getHealth());
        assertNull(myColony.getOneObjectAt(2, 2, Ant.class));
    }
}
