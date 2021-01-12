import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Bee class is the main enemy of this game. subclass of ant.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class Bee extends Ant
{
    //~ Fields ................................................................

    private int count;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bee object.
     */
    public Bee()
    {
        this.rotateBy(180);
        super.setHealth(3);
        count = 0;
    }


    //~ Methods ...............................................................

    /**
     * The act method guides a bee object towards Homebase to beat 
     * the ants.
     */
    public void act()
    {
        Ant blocker = this.getOneIntersectingObject(Ant.class);
        if (blocker == null)
        {
            super.move(0.0125);
        }
        else
        {
            if (this.count == 39)
            {
                blocker.injure(1);
                this.count = 0;
            }
            else
            {
                this.count++;
            }
        }
    }
}
