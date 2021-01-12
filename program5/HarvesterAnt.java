import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Harvester ant adds food to the colony.
 *
 *  @author Chrles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class HarvesterAnt extends Ant
{
    //~ Fields ................................................................
    private int count;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HarvesterAnt object.
     */
    public HarvesterAnt()
    {
        super.setFoodCost(2);
        count = 0;
    }


    //~ Methods ...............................................................


    /**
     * The act method counts as a turn in our game - calling actions
     * on a count based system.
     */
    public void act()
    {
        if (this.count == 39)
        {
            this.count = 0;
            Colony world = (Colony)this.getWorld();
            world.addFood(1);
        }
        this.count++;
    }
}
