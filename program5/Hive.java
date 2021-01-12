import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  Hive object spawns bees randomly.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class Hive extends Actor
{
    //~ Fields ................................................................

    private int beesRemaining;
    private int count;
    private boolean started;
    private int randomCount;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Hive object.
     */
    public Hive()
    {
        beesRemaining = 30;
        count = 0;
        started = false;
    }


    //~ Methods ...............................................................
    
    
    /**
     * act method for the hive releases bees into the world to attack
     * the queens chamber.
     */
    public void act()
    {
        if (!started)
        {
            this.count++;
            if (this.count == 399)
            {
                started = true;
                this.count = 0;
            }
        }
        else
        {
            if (count == 0)
            {
                this.randomCount = Random.generator().nextInt(320) + 80;
            }
            if (this.beesRemaining > 0 && count == this.randomCount)
            {
                Bee stingerBee = new Bee();
                int place = Random.generator().nextInt(5) + 1;
                this.getWorld().add(stingerBee, 9, place);
                this.count = 0;
                this.beesRemaining--;
            }
            this.count++;
        }
    }
   
       
    /**
     * getBees() method checks how many bees are left in the hive.
     * @return  number of bees in thehive object.
     */
    public int getBees()
    {
        return this.beesRemaining;
    }
    
    
    /**
     * setBees() method is a setter method for bees in a hive.
     * @param addBees   number of bees to set in hive.
     */
    public void setBees(int addBees)
    {
        this.beesRemaining = addBees;
    }
    
}
