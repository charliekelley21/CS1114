import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  tests colony class.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class ColonyTest extends TestCase
{
    //~ Fields ................................................................

    private Colony myColony;
    private Bee test;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ColonyTest test object.
     */
    public ColonyTest()
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
        myColony = new Colony();
        test = new Bee();
    }


    // ----------------------------------------------------------
    /**
     * tests ontouchdown method for in bounds.
     */
    public void testOnTouchDownInBounds()
    {
        myColony.setSelectedActor(HarvesterAnt.class);
        myColony.onTouchDown(2, 2);
        
        assertEquals(myColony.getObjectsAt(
            2, 2, HarvesterAnt.class).size(), 1);
    }
    /**
     * tests ontouchdown method for no food
     */
    public void testOnTouchDownNoFood()
    {
        myColony.setSelectedActor(HarvesterAnt.class);
        myColony.consumeFood(30);
        myColony.onTouchDown(2, 2);
        
        assertEquals(myColony.getObjectsAt(
            2, 2, HarvesterAnt.class).size(), 0);
    }
    /**
     * tests ontouchdown method for out bounds.
     */
    public void testOnTouchFarLeft()
    {
        myColony.setSelectedActor(HarvesterAnt.class);
        myColony.onTouchDown(0, 2);
        
        assertEquals(myColony.getObjectsAt(
            2, 2, HarvesterAnt.class).size(), 0);
    }
    /**
     * tests ontouchdown method for out bounds.
     */
    public void testOnTouchFarRight()
    {
        myColony.setSelectedActor(HarvesterAnt.class);
        myColony.onTouchDown(9, 2);
        
        assertEquals(myColony.getObjectsAt(
            2, 2, HarvesterAnt.class).size(), 0);
    }
    /**
     * tests ontouchdown method for out bounds.
     */
    public void testOnTouchFarUp()
    {
        myColony.setSelectedActor(HarvesterAnt.class);
        myColony.onTouchDown(2, 0);
        
        assertEquals(myColony.getObjectsAt(
            2, 2, HarvesterAnt.class).size(), 0);
    }
    /**
     * tests ontouchdown method for out bounds.
     */
    public void testOnTouchFarDown()
    {
        myColony.setSelectedActor(HarvesterAnt.class);
        myColony.onTouchDown(2, 6);
        
        assertEquals(myColony.getObjectsAt(
            2, 2, HarvesterAnt.class).size(), 0);
    }
    
    
    
    /**
     * tests getFood() method
     */
    public void testGetFood()
    {
        assertEquals(30, myColony.getFood());
    }
    
    
    /**
     * tests addFood() method
     */
    public void testAddFood()
    {
        myColony.addFood(20);
        assertEquals(50, myColony.getFood());
    }
    
    
    /**
     * tests consumeFood() method
     */
    public void testConsumeFood()
    {
        myColony.consumeFood(20);
        assertEquals(10, myColony.getFood());
    }

    
    /**
     * test act() method when game goes on
     */
    public void testActContinueGame()
    {
        myColony.add(test, 2, 2);
        myColony.act();
        assertFalse(myColony.isGameWon());
        assertFalse(myColony.isGameOver());
    }
    
    
    /**
     * test act() method when you lose
     */
    public void testActLose()
    {
        myColony.add(test, 1, 2);
        myColony.act();
        assertFalse(myColony.isGameWon());
        assertTrue(myColony.isGameOver());
    }
}
