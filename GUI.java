import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI implements Serializable
{
    // instance variables - replace the example below with your own
    
    JFrame frame;
    floorPanel roomFloor;
    AnimalRoom room;
    
    public GUI() {
        frame = new JFrame("iMouse Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String roomID = JOptionPane.showInputDialog( "Type in room number:");
        room = new AnimalRoom(roomID);
    }
    
    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setUpGUI();
    }
    
    public void setUpGUI() {
        
        
        // set up panels
        JPanel panelNorth = new JPanel();
        JPanel panelSouth = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();
        JPanel panelCenter = new JPanel();
        
        // set up text header
        JTextField  roomNumText = new JTextField(10);
        JTextField  projectNameText = new JTextField(10);
        
        JLabel roomNum = new JLabel("Room Number: ");
        JLabel projectName = new JLabel("Project Name: ");
        
        panelNorth.setBackground(Color.RED);
        panelNorth.add(roomNum);
        roomNumText.setText("");
        panelNorth.add(roomNumText);
        panelNorth.add(projectName);
        projectNameText.setText("project name");
        panelNorth.add(projectNameText);
        
        // set up left control
        panelWest.setBackground(Color.YELLOW);
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
        
        JButton buttonImport = new JButton("Import");
        panelWest.add(buttonImport);
        
        JButton buttonExport = new JButton("Export");
        panelWest.add(buttonExport);
        
        JButton buttonUndo = new JButton("Undo");
        panelWest.add(buttonUndo);
        
        JButton buttonSave = new JButton("Save");
        buttonSave.addActionListener(new SaveListener());
        panelWest.add(buttonSave);
        
        // set up center scroll
        panelCenter.setBackground(Color.darkGray);
        
        // text = new JTextArea(10,20);
        
        roomFloor = new floorPanel();
        roomFloor.setLayout(new GridLayout(8,8));
        //roomFloor.setLayout(new BoxLayout(roomFloor, BoxLayout.X_AXIS));
        
        roomFloor.setBackground(Color.ORANGE);
        
        panelCenter.add(roomFloor);
        
        JButton addTextButton = new JButton("Add Cage");
        addTextButton.addActionListener(roomFloor);
        panelSouth.add(addTextButton);
        
        frame.getContentPane().add(BorderLayout.NORTH, panelNorth);
        frame.getContentPane().add(BorderLayout.CENTER, roomFloor);
        frame.getContentPane().add(BorderLayout.WEST, panelWest);
        frame.getContentPane().add(BorderLayout.EAST, panelEast);
        frame.getContentPane().add(BorderLayout.SOUTH, panelSouth);
        frame.setSize(800,600);
        //frame.pack();
        frame.setVisible(true);
    }
    
    
    private class cagePanel extends JPanel
    {
        int id;
        
        cagePanel(int id) {
            this.id = id;
        }
        
        public void paintComponent (Graphics g) {
            int r = (int) (Math.random() *250);
            int gr = (int) (Math.random() *250);
            int b = (int) (Math.random() *250);
            g.setColor(Color.BLUE);
            g.fillRect(15,15, 50, 50);
        }
        
    }
    
    
    private class floorPanel extends JPanel implements ActionListener
    {
        public void actionPerformed(ActionEvent ev) {
            String input = JOptionPane.showInputDialog("Type in cage number:");
            int cageID = 999;
            
            try {
                cageID = Integer.parseInt(input);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Only Integer Values Accepted, set cage number to 999 at default");
            }
            
            
            cagePanel cp = new cagePanel(cageID);
            cp.add(new JLabel(Integer.toString(cp.id)));
            roomFloor.add(cp);
            room.addCage(cp.id);
            roomFloor.revalidate();
            roomFloor.repaint();
            //frame.getContentPane().add(BorderLayout.CENTER, roomFloor);
            
        }
        
        
    }
    
    public void saveSession() {
        try { 
            FileOutputStream fs = new FileOutputStream("session.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(room);
            os.close();
            JOptionPane.showMessageDialog(frame, "Session Saved!");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            saveSession();
        }
    }
    
    
    
    
    
}













