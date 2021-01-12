import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  The SearchingJeroo subclass extends the Jeroo class
 *  The Searching Jeroo subclass adds methods in order for
 *  a more seemless approach to Program 1.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.02.01
 */
public class SearchingJeroo extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SearchingJeroo object facing east with no flowers.
     * @param x     the x-coordinate of the Jeroo's location.
     * @param y     the y-coordinate of the Jeroo's location.
     */
    public SearchingJeroo(int x, int y)
    {
        super(x, y);
    }

    /**
     * The harvestRow() method allows the Jeroo to move forward until it 
     * hits water or a net, collecting flowers as it goes.
     * <p>
     * This method utilizes a while loop and boolean logic to create a 
     * loop that terminates when the SearchingJeroo sees water or a net
     * ahead. While the loop is cycling the Jeroo hops forward and picks 
     * a flower after each hop.
     * 
     * @param dirTurn   the value for determining the direction to turn.
     */
    public void harvestRow(int dirTurn)
    {
        if (dirTurn > 0)
        {
            this.turn(RIGHT);  
        }
        else
        {
            this.turn(LEFT);
        }
        while (!seesWater(AHEAD) && !seesNet(AHEAD))
        {
            this.hop();
            this.pick();
        }
    }
    /**
     * The turnAround() method turns the SearchingJeroo around
     * 180 degrees.
     * <p>
     * This method uses the turn method and executes it twice in 
     * order to easily turn the SearchingJeroo around.
     */
    public void turnAround()
    {
        this.turn(RIGHT);
        this.turn(RIGHT);
    }
    /**
     * The zigZag() method moves the Searching Jeroo in a zigzag
     * pattern and picks a flower.
     * <p>
     * This method combines several hops and two turns in order 
     * to move diagonally south east. The method ends with picking a flower.
     */
    public void zigZag()
    {
        this.hop(2);
        this.turn(RIGHT);
        this.hop(2);
        this.turn(LEFT);
        this.pick();
    }
    //~ Methods ...............................................................


}
