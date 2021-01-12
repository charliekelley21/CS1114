import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Hungry ant eats bees and then chews them up.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class HungryAnt extends Ant
{
    //~ Fields ................................................................

    private int count;
    private boolean eating;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HungryAnt object.
     */
    public HungryAnt()
    {
        super.setFoodCost(5);
        count = 0;
    }


    //~ Methods ...............................................................

    /**
     * The act method counts as a turn in our game - calling actions
     * on a count based system.
     */
    public void act()
    {
        Bee target = this.getOneIntersectingObject(Bee.class);
        if (target != null && !eating)
        {
            Colony myColony = (Colony) this.getWorld();
            myColony.remove(target);
            eating = true;
        }
        if (eating)
        {
            this.count++;
            if (this.count == 240)
            {
                count = 0;
                eating = false;
            }
        }
    }
}
