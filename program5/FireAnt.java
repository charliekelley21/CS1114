import sofia.micro.*;
import java.util.List;

//-------------------------------------------------------------------------
/**
 *  Fire ant class attacks as a bomb when it dies.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class FireAnt extends Ant
{
    //~ Fields ................................................................

    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FireAnt object.
     */
    public FireAnt()
    {
        //pass
    }


    //~ Methods ...............................................................

    
    /**
     * injure method modifies the ant class injure to also damage
     * those around it.
     * @param n amount to injure by.
     */
    public void injure(int n)
    {
        super.setHealth(super.getHealth() - n);
        if (super.getHealth() <= 0)
        {
            List<Ant> victims = this.getNeighbors(1, true, Ant.class);
            victims.add(this.getOneIntersectingObject(Bee.class));
            int iterator = victims.size();
            this.getWorld().remove(this);
            for (int i = 0; i < iterator; i++)
            {
                if (victims.get(i) != null)
                {
                    victims.get(i).injure(3);
                }
            }
        }
    }
}
