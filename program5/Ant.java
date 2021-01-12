import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Parent Ant class for all other ants.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.17
 */
public class Ant extends Actor
{
    //~ Fields ................................................................
    private int health;
    private int foodCost;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ant object.
     */
    public Ant()
    {
        health = 1;
        foodCost = 4;
    }


    //~ Methods ...............................................................

    /**
     * getter method for health of an ant.
     * @return health of ant object.
     */
    public int getHealth()
    {
        return this.health;
    }
    
    
    /**
     * setter method for health of an ant.
     * @param n     set health to n 
     */
    public void setHealth(int n)
    {
        this.health = n;
    }
    
    
    /**
     * setter method for food cost of an ant.
     * @param n     set food cost to n 
     */
    public void setFoodCost(int n)
    {
        this.foodCost = n;
    }
    
   
    /**
     * injure method injures an ant object.
     * @param n damage dealt to ant object
     */
    public void injure(int n)
    {
        this.setHealth(this.getHealth() - n);
        if (this.health <= 0)
        {
            this.getWorld().remove(this);
        }
    }
    
    
    /**
     * getter method for foodCost of an ant.
     * @return food cost of ant object. 
     */
    public int getFoodCost()
    {
        return this.foodCost;
    }
}
