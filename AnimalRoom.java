import java.util.ArrayList;
import java.io.*;
/**
 * Write a description of class AnimalRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimalRoom implements Serializable
{
    // instance variables - replace the example below with your own
    private ArrayList<Mouse> listMouse;
    private ArrayList<Cage> listCage;
    private String roomID;
    

    /**
     * Constructor for objects of class AnimalRoom
     */
    public AnimalRoom(String roomID)
    {
        // initialise instance variables
        this.roomID = roomID;
        listCage = new ArrayList<Cage> ();
        listMouse = new ArrayList<Mouse> ();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addMouse(int id, int year, int month, int day, 
                            boolean isFemale, String tag, String genotype)
    {
        // put your code here
        Mouse m = new Mouse(id, year, month, day, isFemale, tag, genotype);
        listMouse.add(m);
        
    }
    
    public void addCage(int id)
    {
        // put your code here
        Cage c = new Cage(id);
        listCage.add(c);
        
    }
    
    public void removeMouse(Mouse m)
    {
        // put your code here
        listMouse.remove(m);
    }
    
    public void removeCage(Cage c)
    {
        // put your code here
        listCage.remove(c);
    }
    
    public int getNumMouse (){
        return listMouse.size();
    }
    
    public int getNumCage (){
        return listCage.size();
    }    
        
    public String getRoomID (){
        return this.roomID;
    }    
    
    
    public ArrayList<Mouse> getMouseList (){
        return listMouse;
    }
    
    public ArrayList<Cage> getCageList (){
        return listCage;
    }
    
    public Mouse getMouse (int id){
        for(Mouse m:listMouse) {
            if (m.getID() == id) return m;
        }
        return null;
    }
}
