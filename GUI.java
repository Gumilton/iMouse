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
    
    
    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setUpGUI();
    }
    
    public void setUpGUI() {
        frame = new JFrame("iMouse Inventory");        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton newStart = new JButton("Start New");
        newStart.addActionListener(new NewStartListener());
        
        // set up menu bar
            JMenuBar menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            JMenuItem fileItemNew = new JMenuItem("New");
            JMenuItem fileItemSave = new JMenuItem("Save");
            JMenuItem fileItemImport = new JMenuItem("Import");
            JMenuItem fileItemExport = new JMenuItem("Export");
            
            fileItemNew.addActionListener(new NewStartListener());
            fileItemSave.addActionListener(new SaveListener());
            fileItemImport.addActionListener(new ImportListener());
            fileItemExport.addActionListener(new ExportListener());
            
            fileMenu.add(fileItemNew);
            fileMenu.add(fileItemSave);
            fileMenu.add(fileItemImport);
            fileMenu.add(fileItemExport);
            menuBar.add(fileMenu);
            
            JMenu aboutMenu = new JMenu("About");
            JMenuItem aboutItemHelp = new JMenuItem("Help");
            JMenuItem aboutItemAbout = new JMenuItem("About");
            aboutMenu.add(aboutItemHelp);
            aboutMenu.add(aboutItemAbout);
            menuBar.add(aboutMenu);
            
            frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, newStart);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    
    
    private class NewStartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ev) {
            String roomID = JOptionPane.showInputDialog( "Type in room number:");
            room = new AnimalRoom(roomID);
            
            // set up panels
            JPanel panelNorth = new JPanel();
            JPanel panelSouth = new JPanel();
            //JPanel panelWest = new JPanel();
            //JPanel panelEast = new JPanel();
            JPanel panelCenter = new JPanel();
            
            // set up text header
            JTextField  roomNumText = new JTextField(10);
            roomNumText.setText(room.getRoomID());
            JTextField  projectNameText = new JTextField(20);
            projectNameText.setText(JOptionPane.showInputDialog( "Type in Project Description:"));
            
            JLabel roomNum = new JLabel("Room Number: ");
            JLabel projectName = new JLabel("Project Name: ");
            
            panelNorth.setBackground(Color.RED);
            panelNorth.add(roomNum);
            panelNorth.add(roomNumText);
            panelNorth.add(projectName);
            panelNorth.add(projectNameText);
            
            // set up left control
            //panelWest.setBackground(Color.YELLOW);
            //panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
            
            //JButton buttonImport = new JButton("Import");
            //panelWest.add(buttonImport);
            
            //JButton buttonExport = new JButton("Export");
            //panelWest.add(buttonExport);
            
            //JButton buttonUndo = new JButton("Undo");
            //panelWest.add(buttonUndo);
            
            // set up menu bar
            JMenuBar menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            JMenuItem fileItemNew = new JMenuItem("New");
            JMenuItem fileItemSave = new JMenuItem("Save");
            JMenuItem fileItemImport = new JMenuItem("Import");
            JMenuItem fileItemExport = new JMenuItem("Export");
            
            fileItemNew.addActionListener(new NewStartListener());
            fileItemSave.addActionListener(new SaveListener());
            fileItemImport.addActionListener(new ImportListener());
            fileItemExport.addActionListener(new ExportListener());
            
            fileMenu.add(fileItemNew);
            fileMenu.add(fileItemSave);
            fileMenu.add(fileItemImport);
            fileMenu.add(fileItemExport);
            menuBar.add(fileMenu);
            
            JMenu aboutMenu = new JMenu("About");
            JMenuItem aboutItemHelp = new JMenuItem("Help");
            JMenuItem aboutItemAbout = new JMenuItem("About");
            aboutMenu.add(aboutItemHelp);
            aboutMenu.add(aboutItemAbout);
            menuBar.add(aboutMenu);
            
            frame.setJMenuBar(menuBar);
            //panelWest.add(buttonSave);
            
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
            
            frame.getContentPane().removeAll();
            frame.getContentPane().add(BorderLayout.NORTH, panelNorth);
            frame.getContentPane().add(BorderLayout.CENTER, roomFloor);
            //frame.getContentPane().add(BorderLayout.WEST, panelWest);
            //frame.getContentPane().add(BorderLayout.EAST, panelEast);
            frame.getContentPane().add(BorderLayout.SOUTH, panelSouth);
            frame.validate();
        }
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
    
    public void saveSession(File file) {
        try { 
            FileOutputStream fs = new FileOutputStream(file);
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
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveSession(new File(fileSave.getSelectedFile() + ".ims"));
        }
    }
    
    
    class ImportListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                JFileChooser fileImport = new JFileChooser();
                fileImport.showSaveDialog(frame);
                FileInputStream fis = new FileInputStream(fileImport.getSelectedFile());
                ObjectInputStream ois = new ObjectInputStream(fis);
                AnimalRoom one = (AnimalRoom) ois.readObject();
                ois.close();
                System.out.println("Obejct is " + one.getRoomID());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
        
    
    class ExportListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //importSession();
        }
    }
    
    
}













