// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Charles Kelley (charlk21)
import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  The City class is a sub class of the World class and is
 *  inhabitted by sweet tea drinkers and unsweet tea drinkers.
 *  The city class initializes with a certain percentage of 
 *  each agent and sets their threshold.
 *
 *  @author Charles Kelley (charlk21)
 *  @version 2018.03.22
 */
public class City extends World
{
    //~ Fields ................................................................
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new City object.
     */
    public City()
    {
        this(5, 5);
        this.populate(0.4, 0.3, 0.4);
    }
    /**
     * Creates a new City object.
     * 
     * @param width     width of new city object
     * @param height    height of new city object
     */
    public City(int width, int height)
    {
        super(width, height, 24);
    }
    /**
     * The populate() method fills the City world with elephants 
     * and monkeys and passes a threshold to each for which they
     * will be satisfied with a given location.
     * 
     * @param elephants   approximate population percentage of 
     *  elephants.
     * @param monkeys   approximate population percentage of 
     *  monkeys.
     * @param threshold the threshold value for all agent objects.
     */
    public void populate(double elephants, double monkeys, double threshold)
    {
        for (int i = 0; i < this.getWidth(); i++)
        {
            for (int j = 0; j < this.getHeight(); j++)
            {
                double variable = Random.generator().nextDouble(0.0, 1.0);
                if (variable <= elephants)
                {
                    Agent elephant = new Agent("elephant", threshold);
                    this.add(elephant, i, j);
                }
                else if (variable <= (elephants + monkeys))
                {
                    Agent monkey = new Agent("monkey", threshold);
                    this.add(monkey, i, j);
                }
            }
        }
    }

    //~ Methods ...............................................................


}
