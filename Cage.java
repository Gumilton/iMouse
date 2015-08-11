
import java.util.ArrayList;

/**
 * Write a description of class Cage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cage
{
    // instance variables - replace the example below with your own
    private int id;
    private int adultNum;
    private int pupNum;
    private boolean isMating;
    private ArrayList<String> notes;
    private ArrayList<Mouse> mouses;
    

    /**
     * Constructor for objects of class Cage
     */
    public Cage(int id)
    {
        // initialise instance variables
        id = id;
        adultNum = 0;
        pupNum = 0;
        isMating = false;
        
    }
    
    // getter functions

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getID()
    {
        // put your code here
        return id;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getAdultNum()
    {
        // put your code here
        return adultNum;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getPupNum()
    {
        // put your code here
        return pupNum;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean getMating()
    {
        // put your code here
        return isMating;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public ArrayList<String> getNote()
    {
        // put your code here
        return notes;
    }
    // setter functions

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setID(int id)
    {
        // put your code here
        this.id = id;
    }


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setMating(boolean mating)
    {
        // put your code here
        this.isMating = mating;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addNote(String note)
    {
        // put your code here
        this.notes.add(note);
    }
    
    public void removeNote(String note)
    {
        // put your code here
        this.notes.remove(note);
    }
    
    // cage function
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addMouse(Mouse m)
    {
        // put your code here
        
        
        if( m.getCage() == null) {
            m.setCage(this);
        }
        
        if(m.ageWeek() < 3) {
            pupNum ++;
        }
        else adultNum ++;
        
        mouses.add(m);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void removeMouse(Mouse m)
    {
        // put your code here
        mouses.remove(m);
    }
}
