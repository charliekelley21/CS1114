import sofia.micro.*;
import sofia.battleship.*;
import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 *  All test cases to test the implimentation of battleship
 *  interface on my strategy of battleship playing.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.05
 */
public class MyStrategyTest extends TestCase
{
    //~ Fields ................................................................
    private TestableGameState testGame;
    private BattleshipStrategy myStrategy;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MyStrategyTest test object.
     */
    public MyStrategyTest()
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
        testGame = new TestableGameState();
        myStrategy = new myStrategy();
        myStrategy.newGame();
    }

    //-------------------------------------------------------------------
    /**
     * tests the getName() method to return name of
     * strategy.
     */
    public void testGetName()
    {
        assertEquals(myStrategy.getName(), "Charlk21 - basic");
    }
    /**
     * tests the playDeviously() method to return false.
     */
    public void testPlayDeviouly()
    {
        assertFalse(myStrategy.canPlayDeviously());
    }
    /**
     * tests the placeShips method for a random placement
     * of ships.
     */
    public void testPlaceShips()
    {
        Random.setNextInts(1, 0, 0, 1, 1, 1, 0, 3);
        ShipPlacementMove placements = myStrategy.placeShips(testGame);
        assertEquals(placements.getShip(ShipType.BATTLESHIP).getX(), 0);
        assertEquals(placements.getShip(ShipType.BATTLESHIP).getY(), 0);
        assertEquals(placements.getShip(ShipType.CARRIER).getX(), 2);
        assertEquals(placements.getShip(ShipType.CARRIER).getY(), 1);
        assertEquals(placements.getShip(ShipType.DESTROYER).getX(), 3);
        assertEquals(placements.getShip(ShipType.DESTROYER).getY(), 3);
        assertEquals(placements.getShip(ShipType.PATROL).getX(), 5);
        assertEquals(placements.getShip(ShipType.PATROL).getY(), 5);
        assertEquals(placements.getShip(ShipType.SUBMARINE).getX(), 6);
        assertEquals(placements.getShip(ShipType.SUBMARINE).getY(), 2);
    }
    /**
     * tests the callNextShotMEethod for a case where last shot was in
     * the middle of a row.
     */
    public void testCallNextShotMiddleRow()
    {
        TestableBoard gameToShootAt = testGame.getOpponentsBoard();
        gameToShootAt.placeShips(
            ".........." +
            "CCCCC....." +
            ".BBBB....." +
            ".....DDD.." +
            ".SSS......" +
            "........PP" +
            ".........." +
            ".........." +
            ".........." +
            "..........");
        gameToShootAt.firePattern(
            "**********" +
            "**********" +
            "**********" +
            "*****....." +
            ".........." +
            ".........." +
            ".........." +
            ".........." +
            ".........." +
            "..........");
        CallShotMove nextShot = myStrategy.callNextShot(testGame);
        assertEquals(5, nextShot.getX());
        assertEquals(3, nextShot.getY());
    }
    /**
     * tests the callNextShotMEethod for a case on the end of a line
     * for brute force strategy that loops to x = 0.
     */
    public void testCallNextShotXEqualsNine()
    {
        TestableBoard gameToShootAt = testGame.getOpponentsBoard();
        gameToShootAt.placeShips(
            ".........." +
            "CCCCC....." +
            ".BBBB....." +
            ".....DDD.." +
            ".SSS......" +
            "........PP" +
            ".........." +
            ".........." +
            ".........." +
            "..........");
        gameToShootAt.firePattern(
            "**********" +
            "**********" +
            "**********" +
            "**********" +
            ".........." +
            ".........." +
            ".........." +
            ".........." +
            ".........." +
            "..........");
        CallShotMove nextShot = myStrategy.callNextShot(testGame);
        assertEquals(0, nextShot.getX());
        assertEquals(4, nextShot.getY());
    }
    
    
    /**
     * tests the callNextShotMEethod for a case on the bottom right
     * corenr.
     */
    public void testCallNextShotBottomRight()
    {
        TestableBoard gameToShootAt = testGame.getOpponentsBoard();
        gameToShootAt.placeShips(
            ".........." +
            "CCCCC....." +
            ".BBBB....." +
            ".....DDD.." +
            ".SSS......" +
            "........PP" +
            ".........." +
            ".........." +
            ".........." +
            "..........");
        gameToShootAt.firePattern(
            ".........." +
            ".........." +
            ".........." +
            ".........." +
            "**********" +
            "**********" +
            "**********" +
            "**********" +
            "**********" +
            "**********");
        CallShotMove nextShot = myStrategy.callNextShot(testGame);
        assertEquals(0, nextShot.getX());
        assertEquals(0, nextShot.getY());
    }
}
