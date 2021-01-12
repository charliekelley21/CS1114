import sofia.battleship.*;
import sofia.util.Random;
import static sofia.battleship.CellStatus.*;

//-------------------------------------------------------------------------
/**
 *  My strategy for playing battleship is similar to 
 *  the brute force strategy of the provided smaples.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.05
 */
public class myStrategy implements BattleshipStrategy
{
    //~ Fields ................................................................
    
    private int x = 0;
    private int y = 4;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new myStrategy object.
     */
    public myStrategy()
    {
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * the main "play" method - calls your next shot when its the
     * players turn.
     *
     * @param  currentGameState     current state of the game.
     * @return shot         the next hsot to be taken.
     */
    public CallShotMove callNextShot(GameState currentGameState)
    {
        if (!currentGameState.getOpponentsBoard().canFireAt(
            currentGameState.getOpponentsBoard().getLastAttackX(), 
            currentGameState.getOpponentsBoard().getLastAttackY()))
        {
            if (currentGameState.getOpponentsBoard().getLastAttackX() == 9 
                && currentGameState.getOpponentsBoard().getLastAttackY() == 9)
            {
                y = 0;
                x = 0;
            }
            else if (currentGameState.getOpponentsBoard().getLastAttackX() == 9)
            {
                y = currentGameState.getOpponentsBoard().getLastAttackY() + 1;
                x = 0;
            }
            else
            {
                x = currentGameState.getOpponentsBoard().getLastAttackX() + 1;
                y = currentGameState.getOpponentsBoard().getLastAttackY();
            }
        }
        CallShotMove shot = new CallShotMove(x, y);
        return shot;
    }
    
    
    /**
     * canPlayDeviously() determines whether you can cheat in your game
     * or not.
     *
     * @return cheating     true or false for cheating during the game.
     */
    public boolean canPlayDeviously()
    {
        return false;
    }
    
    
    /**
     * getter method that returns the name of the player and thier
     * strategy.
     *
     * @return  name of your strategy and player.
     */
    public String getName()
    {
        return "Charlk21 - basic";
    }
    
    
    /**
     * calls strategy to initalize a new game.
     */
    public void newGame()
    {
        //nothing to initialize
    }
    
    
    /**
     * method to place ships in the locations called by your
     * strategy.
     *
     * @param  currentGameState provides the current game state.
     * @return ship placements
     */
    public ShipPlacementMove placeShips(GameState currentGameState)
    {
        ShipPlacementMove shipPlacement = 
            new ShipPlacementMove(currentGameState);
        int x2 = 0;
        int y2 = 0;
        shipPlacement.placeShip(ShipType.BATTLESHIP, x2, y2, false);
        x2 += (Random.generator().nextInt(2) + 1);
        y2 += (Random.generator().nextInt(2) + 1);
        shipPlacement.placeShip(ShipType.CARRIER, x2, y2, false);
        x2 += (Random.generator().nextInt(2) + 1);
        y2 += (Random.generator().nextInt(2) + 1);
        shipPlacement.placeShip(ShipType.DESTROYER, x2, y2, false);
        x2 += (Random.generator().nextInt(2) + 1);
        y2 += (Random.generator().nextInt(2) + 1);
        shipPlacement.placeShip(ShipType.PATROL, x2, y2, false);
        x2 += (Random.generator().nextInt(2) + 1);
        y2 -= Random.generator().nextInt(4);
        shipPlacement.placeShip(ShipType.SUBMARINE, x2, y2, false);
        return shipPlacement;
    }
    
    
}
