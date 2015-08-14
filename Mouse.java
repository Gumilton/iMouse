import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.io.*;
/**
 * This is a class of mouse with basic information, including gender, id, birthday, tag and genotype.
 * Tow reference will be given to its father and mother.
 * 
 * @author Goomilton
 * @version 1.0
 */
public class Mouse implements Serializable
{
    // instance variables - replace the example below with your own
    private int id;
    private Calendar birthday;
    private boolean isFemale;
    private String tag;
    private Mouse father;
    private Mouse mother;
    private String genotype;
    private Cage cage;
    private ArrayList<Mouse> pastMates;
    private ArrayList<Mouse> currentMates;
    private ArrayList<Mouse> offsprings;

    /**
     * Constructor for objects of class Mouse
     */
    public Mouse(int id, int year, int month, int day,
                    boolean isFemale, String tag, String genotype)
    {
        // initialise instance variables
        this.id = id;
        birthday = Calendar.getInstance();
        birthday.set(year, month - 1, day);
        this.isFemale = isFemale;
        this.tag = tag;
        this.genotype = genotype;
        cage = null;
        pastMates = new ArrayList<Mouse>();
        currentMates = new ArrayList<Mouse>();
        offsprings = new ArrayList<Mouse>();
    }
    
    // getter functions

    /**
     * a series of getter -- id
     * 
     * 
     * @return     the sum of x and y 
     */
    public int getID()
    {
        // put your code here
        return id;
    }
    
        /**
     * a series of getter -- cage
     * 
     * 
     * @return     the sum of x and y 
     */
    public Cage getCage()
    {
        // put your code here
        return cage;
    }
    
    /**
     * a series of getter -- birthday
     * 
     * @return     the sum of x and y 
     */
    public Calendar getBirthday()
    {
        // put your code here
        return birthday;
    }
    
    /**
     * a series of getter -- isFemale
     * 
     * @return     the sum of x and y 
     */
    public boolean isFemale()
    {
        // put your code here
        return isFemale;
    }
    
    /**
     * a series of getter -- tag
     * 
     * @return     the sum of x and y 
     */
    public String getTag()
    {
        // put your code here
        return tag;
    }
    
    /**
     * a series of getter -- genotype
     * 
     * @return     the sum of x and y 
     */
    public String getGenotype()
    {
        // put your code here
        return genotype;
    }
    
    /**
     * a series of getter -- father
     * 
     * @return     the sum of x and y 
     */
    public Mouse getFather()
    {
        // put your code here
        return father;
    }
    
    /**
     * a series of getter -- mother
     * 
     * @return     the sum of x and y 
     */
    public Mouse getMother()
    {
        // put your code here
        return mother;
    }
    
    // setter functions
    
    /**
     * a series of setter -- id
     * 
     * @param   unique id number
     * @return     the sum of x and y 
     */
    public void setID(int id)
    {
        // put your code here
        this.id = id;
    }
    
        /**
     * a series of setter -- cage
     * 
     * @param   unique cage number
     * @return     the sum of x and y 
     */
    public void setCage(Cage cage)
    {
        // put your code here
        Cage oldCage = this.cage;
        this.cage = cage;
        cage.addMouse(this);
        if( oldCage != null) {
            oldCage.removeMouse(this);
        }
    }
    
    /**
     * a series of setter -- birthday
     * 
     * @param       Date object as birthday
     * @return     the sum of x and y 
     */
    public void setBirthday(int year, int month, int day)
    {
        // put your code here
        this.birthday.set(year, month - 1, day);
    }
    
    /**
     * a series of setter -- isFemale
     * 
     * @return     the sum of x and y 
     */
    public void setGenderFemale(boolean gender)
    {
        // put your code here
        this.isFemale = gender;
    }
    
    /**
     * a series of setter -- tag
     * 
     * @return     the sum of x and y 
     */
    public void setTag(String tag)
    {
        // put your code here
        this.tag = tag;
    }
    
    /**
     * a series of setter -- genotype
     * 
     * @return     the sum of x and y 
     */
    public void setGenotype(String genotype)
    {
        // put your code here
        this.genotype = genotype;
    }
    
    /**
     * a series of setter -- father
     * 
     * @return     the sum of x and y 
     */
    public void setFather(Mouse dad)
    {
        // put your code here
        this.father = dad;
    }
    
    /**
     * a series of setter -- mother
     * 
     * @return     the sum of x and y 
     */
    public void setMother(Mouse mom)
    {
        // put your code here
        this.mother = mom;
    }
    
    // mouse function
        
    /**
     * calculate age
     * 
     * @return     the sum of x and y 
     */
    public float ageDay()
    {
        // put your code here
        Calendar today = Calendar.getInstance();
        long diff = today.getTime().getTime() - birthday.getTime().getTime();
        return diff/(float) (1000 * 60 * 60 * 24);
    }
            
    /**
     * calculate age
     * 
     * @return     the sum of x and y 
     */
    public float ageWeek()
    {
        // put your code here
        Calendar today = Calendar.getInstance();
        long diff = today.getTime().getTime() - birthday.getTime().getTime();
        return diff/(float) (1000 * 60 * 60 * 24 * 7);
    }
    
        /**
     * calculate age
     * 
     * @return     the sum of x and y 
     */
    public float ageMonth()
    {
        // put your code here
        Calendar today = Calendar.getInstance();
        long diff = today.getTime().getTime() - birthday.getTime().getTime();
        return diff/(float) (1000 * 60 * 60 * 24 * 7 * 30);
    }
    
    public void mate(){
        
    }
}
