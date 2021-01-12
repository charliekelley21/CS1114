import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  The ScavengerHunt island subclass extends LongIsland.
 *  This subclass is designed to run through LongIsland 
 *  and collect all flowers. This subclass requires no 
 *  futher inputs.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.02.01
 */
public class ScavengerHunt extends LongIsland
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ScavengerHunt object.
     */
    public ScavengerHunt()
    {
        // Nothing to initialize, leaving the world a default size
    }

   /**
     * myProgram() is my soltion to Program 1.
     * <p>
     * myProgram() guides the SearchingJeroo subclaa through 
     * longIsland to collect all eight flowers and avoid all
     * water and nets.
     */
    public void myProgram()
    {
        SearchingJeroo walter = new SearchingJeroo(2, 2);
        this.add(walter, 2, 2);
        walter.turn(RIGHT);
        walter.hop(4);
        walter.turn(LEFT);
        walter.hop(4);
        walter.harvestRow(1);
        walter.turnAround();
        walter.hop();
        walter.turn(RIGHT);
        walter.hop(2);
        walter.harvestRow(1);
        walter.harvestRow(-1);
        walter.harvestRow(-1);
        walter.turn(LEFT);
        walter.hop();
        walter.harvestRow(1);
        walter.harvestRow(-1);
        walter.turnAround();
        walter.zigZag();
        walter.zigZag();
    }
    //~ Methods ...............................................................


}
