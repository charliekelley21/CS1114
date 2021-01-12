// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Charles Kelley (charlk21)
import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The agent class is an object that prefers one drink over another
 *  and moves towards where it is satisfied.
 *  The agent is meant to be called from a world object and called
 *  to act(), moving it across the world if the agent is not
 *  satisfied at its current location.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.03.22
 */
public class Agent extends Actor
{
    //~ Fields ................................................................
    private String kind;
    private double threshold;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Agent object.
     * @param animal    string of the animal type
     * @param threshold threshold of animal for satisfaction
     */
    public Agent(String animal, double threshold)
    {
        this.kind = animal;
        super.setImage(animal + ".png");
        this.threshold = threshold;
    }
    /**
     * The act method is called every tick of time and sends a 
     * request for the agent object to move if they are not
     * satisfied at their current position.
     */
    public void act()
    {
        if (!this.isSatisfied())
        {
            this.relocate();
        }
    }
    /**
     * The getKind() method is a getter method, returning
     * the kind of animal, elephant or monkey, that the 
     * agent object is.
     * @return  returns the kind of animal as a string
     */
    public String getKind()
    {
        return this.kind;
    }
    /**
     * The getThreshold() method is a getter method, returning
     * the threshold for which the object will be satisfied in
     * its current position.
     * @return  returns the threshold of the agent as a double.
     */
    public double getThreshold()
    {
        return this.threshold;
    }
    /**
     * The isSameKindAs() method is a boolean method that
     * takes in a agent object and compares it to the 
     * current agent object. It checks whether the agents
     * are the same drinker or not.
     * 
     * @param agent     agent object to compare to the current
     *  agent that calls this method.
     *  @return     returns boolean wether agents are the same 
     *              type.
     */
    public boolean isSameKindAs(Agent agent)
    {
        return ((agent.getKind()).equals(this.getKind()));
    }
    /**
     * The isSatisfied() method takes in a (x, y) coordinate
     * and returns a boolean whether the agent object is 
     * satisfied at this location.
     * 
     * @param x the x-coordinate for the method to check
     * @param y the y-coordinate for the method to check
     * @return  boolean for an agent if it is satisfied or not
     */
    public boolean isSatisfiedAt(int x, int y)
    {
        int lowX = Math.max(0, x - 1);
        int lowY = Math.max(0, y - 1); 
        int highX = Math.min(this.getWorld().getWidth() - 1, x + 1);
        int highY = Math.min(this.getWorld().getHeight() - 1, y + 1);
        int sameCount = 0;
        int totalCount = 0;
        for (int i = lowX; i <= highX; i++)
        {
            for (int j = lowY; j <= highY; j++)
            {
                Agent agent = this.getWorld().getOneObjectAt(i, j, Agent.class);
                if (agent != null)
                {
                    totalCount++;
                    if (this.isSameKindAs(agent))
                    {
                        sameCount++;
                    }
                }
            }
        }
        double surroundings = (double) (sameCount - 1) / totalCount;
        return (surroundings >= this.getThreshold());
    }
    /**
     * The isSatisfied() method returns a boolean 
     * whether the agent object is satisfied at 
     * its current location.
     * @return boolean for satisfaction at current location.
     */
    public boolean isSatisfied()
    {
        return this.isSatisfiedAt(this.getGridX(), this.getGridY());
    }
    /**
     * The relocate() method moves the agent object
     * to the first open space that the agent would
     * be satisfied in.
     */
    public void relocate()
    {
        int lowX = Math.max(0, this.getGridX() - 1);
        int lowY = Math.max(0, this.getGridY() - 1); 
        int highX = Math.min(this.getWorld().getWidth() - 1, 
            this.getGridX() + 1);
        int highY = Math.min(this.getWorld().getHeight() - 1, 
            this.getGridY() + 1);
        for (int i = lowX; i <= highX; i++)
        {
            for (int j = lowY; j <= highY; j++)
            {
                Agent agent = this.getWorld().getOneObjectAt(i, j, Agent.class);
                if (agent == null && this.isSatisfiedAt(i, j))
                {
                    this.setGridLocation(i, j);
                    break;
                }
            }
        }
    }
    

    //~ Methods ...............................................................


}
