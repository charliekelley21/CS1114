import sofia.micro.*;
import java.util.List;

//-------------------------------------------------------------------------
/**
 *  Colony class is the world that our game will be played on. 
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.04.23
 */
public class Colony extends HomeBase
{
    //~ Fields ................................................................
    private int food;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Colony object.
     */
    public Colony()
    {
        super();
        
        // Add the queen's chamber and hive to the world here
        QueensChamber homeBase = new QueensChamber();
        this.add(homeBase, 0, 3);
        Hive enemyBase = new Hive();
        this.add(enemyBase, 9, 3);
        
        // Lay out the ant choices the player can click on in the
        // method call commented out below.  As you add ants, you
        // can add them to this list, so you have a playable
        // version of your game to try out, no matter how much
        // you have left to finish.

        setActorChoices(
            HarvesterAnt.class,
            ThrowerAnt.class,
            WallAnt.class,
            FireAnt.class,
            HungryAnt.class);
             
        this.addFood(30);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Add an ant to the screen when a specific location is clicked.
     * This method is automatically called while the simulation is
     * running, whenever the user clicks on (or taps on) a location
     * in the colony (one that isn't covered by an actor already).
     * 
     * @param x The x-coordinate of the click
     * @param y The y-coordinate of the click
     */
    public void onTouchDown(int x, int y)
    {
        // Complete this method yourself.
        
        // Only allow ants to be added between (1, 1) - (8, 5),
        // which makes up the playable area of the colony.   You
        // should ignore clicks/taps in locations outside of that
        // range.
        if (x > 0 && x < 9 && y > 0 && y < 6)
        {
            Ant selectedAnt = ((Ant)newActorOfSelectedType());
            if (this.food >= selectedAnt.getFoodCost())
            {
                this.add(selectedAnt, x, y);
                this.consumeFood(selectedAnt.getFoodCost());
            }
        }
        // call newActorOfSelectedType() to create a new ant of the
        // type that the user selected from the choices shown at
        // the top of the screen, then add it at the location of
        // the screen "touch".
        
        // Don't forget that adding an ant costs food!
    }
    
    
    
    /**
     * getFood() method returns number of food of the Colony
     * @return food remaining in colony store.
     */
    public int getFood()
    {
        return this.food;
    }
    
    
    /**
     * addFood() method adds n food to colony
     * @param stock     number of food to add to colony
     */
    public void addFood(int stock)
    {
        this.food += stock;
    }
    
    
    /**
     * consumeFood() consumes a given amount of food from the colony's
     * supply of food.
     * @param consumption     number of food to remove to colony
     */
    public void consumeFood(int consumption)
    {
        this.food -= consumption;
    }
    
    
    /**
     * method ends the game when you lose
     */
    public void lose()
    {
        this.stop();
        System.out.println("YOU LOSE! THE BEES HAVE REACHED YOUR COLONY");
    }
    
    
    /**
     * method ends the game when you win
     */
    public void win()
    {
        this.stop();
        System.out.println("YOU WIN! YOU HAVE KILLED ALL THE BEES");
    }
    
    /**
     * act method called for each clock tick. updates food of colony
     * and checks if the game has ended.
     */
    public void act()
    {
        super.act();
        List<Bee> evaluate = this.getObjects(Bee.class);
        for (int i = 0; i < evaluate.size(); i++)
        {
            if (evaluate.get(i).getOneIntersectingObject(
                QueensChamber.class) != null)
            {
                this.lose();
            }
        }
        Hive enemyHive = this.getOneObjectAt(9, 3, Hive.class);
        if (enemyHive.getBees() == 0)
        {
            this.win();   
        }
    }
}
