package TP5_5;


/**
 * Write a description of class Noeud here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Noeud
{
    Noeud m_parent;
    Noeud[] m_enfants;
    private int x;

    /**
     * Constructor for objects of class Noeud
     */
    public Noeud()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
