import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI implements ActionListener
{
    // instance variables - replace the example below with your own
    
    JFrame frame;
    JPanel roomFloor;
    ArrayList<cagePanel> cageList;
    
    public GUI() {
        frame = new JFrame("iMouse Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cageList = new ArrayList<cagePanel> ();
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
        
        panelWest.add(new JButton("Import"));
        panelWest.add(new JButton("Export"));
        panelWest.add(new JButton("Undo"));
        
        // set up center scroll
        panelCenter.setBackground(Color.darkGray);
        
        // text = new JTextArea(10,20);
        
        roomFloor = new JPanel();
        roomFloor.setBackground(Color.ORANGE);
        roomFloor.add(new cagePanel());
        JScrollPane scroller = new JScrollPane(roomFloor);
        // text.setLineWrap(true);
        
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        panelCenter.add(scroller);
        
        JButton addTextButton = new JButton("Add Text");
        addTextButton.addActionListener(this);
        panelSouth.add(addTextButton);
        
        frame.getContentPane().add(BorderLayout.NORTH, panelNorth);
        frame.getContentPane().add(BorderLayout.CENTER, roomFloor);
        frame.getContentPane().add(BorderLayout.WEST, panelWest);
        frame.getContentPane().add(BorderLayout.EAST, panelEast);
        frame.getContentPane().add(BorderLayout.SOUTH, panelSouth);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev) {
        // text.append("Hahaha \n");
        cageList.add(new cagePanel());
        for(cagePanel cage:cageList) {
            roomFloor.add(new cagePanel());
        }
        System.out.println(cageList.size());
        frame.repaint();
    }
    
    
    
    private class cagePanel extends JPanel implements ActionListener
    {
        public void actionPerformed(ActionEvent ev) {
            repaint();
            
        }
        
        public void paintComponent (Graphics g) {
            int r = (int) (Math.random() *250);
            int gr = (int) (Math.random() *250);
            int b = (int) (Math.random() *250);
            g.setColor(new Color(r,gr,b));
            g.fillRect(15,15, 300, 300);
        }
        
    }
}
