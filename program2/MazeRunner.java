// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Charles Kelley (charlk21)
import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  This MazeRunner class is a subclass of Jeroo an is meant to walk 
 *  through a maze.
 *  This subclass is esigned to created a method to walk a MazeRunner
 *  through a maze cointaining flowers and nets, clearing all other
 *  objects and navigating to the NorthWest corner of MazeIsland.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.02.15
 */
public class MazeRunner extends Jeroo
{
    //~ Fields ................................................................


    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunner object.
     */
    public MazeRunner()
    {
        super(15);
    }
    /**
     * The myProgram() method is designed to be a solution to Program 1.
     * <p>
     * the myProgram() method brings together the other methods of the 
     * MazeRunner subclass to walk a MazeRunner object through a randomized
     * maze from the MazeIsland subclass of Island.
     */
    public void myProgram()
    {
        int xValue;
        int yValue;
        xValue = this.getGridX();
        yValue = this.getGridY();
        this.hugRightWall(1, 1);
        this.hugRightWall(xValue, yValue);
        this.hugRightWall(1, 1);
    }
    /**
     * The hugRightWall() method fallows the right hand side of the maze.
     * <p>
     * the hugRightWall() method guides a MazeRunner object through any 
     * instance of a mze by following the ride hand side of the maze. 
     * The MazeRunner object will also diable any nets and pick up any
     * flowers along the way.
     * 
     * @param x the x-coordinate of the Jeroo's starting position.
     * @param y the y-coordinate of the Jeroo's starting position.
     */
    public void hugRightWall(int x, int y)
    {
        while (this.getGridX() != x || this.getGridY() != y)
        {
            if (!this.seesWater(RIGHT))
            {
                this.turn(RIGHT);
            }
            else if (!this.seesWater(AHEAD))
            {
                //pass
            }
            else 
            {
                this.turn(LEFT);
            }
            if (this.seesNet(AHEAD))
            {
                this.toss();
            }
            this.lookBeforeHop();
            this.pick();
        }
    }
    /**
     * The lookBeforeHop() method has the MazeRunner subclass hop forward if
     * the path is clear.
     */
    public void lookBeforeHop()
    {
        if (!(this.seesWater(AHEAD) || this.seesNet(AHEAD)))
        {
            this.hop();
        }
    }
    //~ Methods ...............................................................


}
