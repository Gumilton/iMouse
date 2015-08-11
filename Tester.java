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
        
        Mouse m1 = new Mouse();
        m1.setBirthday(2015, 8, 10);
        
        DateFormat dateFormat = DateFormat.getDateInstance();
        System.out.println(dateFormat.format(m1.getBirthday().getTime()));
        System.out.println(m1.ageDay());
        System.out.println(m1.ageWeek());
        System.out.println(m1.ageMonth());
        
        
    }
}
