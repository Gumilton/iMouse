import java.io.*;

/**
 * Write a description of class Import here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Import
{
    // instance variables - replace the example below with your own
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void load()
    {
        // put your code here
        
        try {
            FileInputStream fs = new FileInputStream("session.ser");
            ObjectInputStream is = new ObjectInputStream(fs);
            AnimalRoom one = (AnimalRoom) is.readObject();
            is.close();
            System.out.println("Obejct is " + one.getRoomID());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
