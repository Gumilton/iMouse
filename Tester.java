import java.text.DateFormat;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    public static void  main(String[] args) {
        
        System.out.println("Initiate Animal Room:");
        AnimalRoom room = new AnimalRoom("134c");
        
        
        System.out.println("Adding Mouse:");
        room.addMouse(1,2015,8,1,false,"","WT");
        room.addMouse(2,2015,7,0,true,"","WT");
        room.addMouse(3,2015,6,1,true,"","WT");
        
        
        System.out.println("Adding Cage:");
        room.addCage(1);
        
        
        System.out.println("Print Mouse Birthday:");
        DateFormat dateFormat = DateFormat.getDateInstance();
        for(Mouse m:room.getMouseList()){
            System.out.println(m.getID());
            System.out.println(dateFormat.format(m.getBirthday().getTime()));
        }
        
        
        System.out.println("Print Mouse ID 2 information:");
        Mouse s = room.getMouse(2);        
        System.out.println("ID is: " + s.getID());
        System.out.println("ID is: " + s.getID() + "\n" +
                            "Birthday is: " + dateFormat.format(s.getBirthday().getTime()) + "\n" +
                            "Gender: " + s.isFemale() + "\n" +
                            "Age is: " + s.ageWeek() + " weeks");
        
        
    }
}
