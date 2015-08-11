
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
    private String[] notes;
    private Mouse[] mouses;
    

    /**
     * Constructor for objects of class Cage
     */
    public Cage()
    {
        // initialise instance variables
        id = 0;
        adultNum = 0;
        pupNum = 0;
        isMating = false;
        mouses = new Mouse[adultNum + pupNum];
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
    public String[] getNote()
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
    public void setNote(String[] notes)
    {
        // put your code here
        this.notes = notes;
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
        
        
        adultNum ++;
        
        Mouse[] oldMouses = mouses;
        mouses = new Mouse[adultNum + pupNum];
        
        for(int i = 0; i < oldMouses.length; i ++) {
            mouses[i] = oldMouses[i];
        }
        
        mouses[mouses.length -1] = m;
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
        this.notes = notes;
    }
}
