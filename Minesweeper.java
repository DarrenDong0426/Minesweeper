import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

//import sun.text.resources.cldr.ext.FormatData_en_MT;

public class Minesweeper{
	public static int counter = 0;
	private static int length;
  private static int width;
  private static int mines;
  private static JPanel otherPanel; 
  private static JPanel minePanel;
  public static JFrame frame; 
  public static JLabel label;
  public static int flags;
  private static JButton restart;
  private static ImageIcon restartIcon;
public static Timer timer;
  public static JLabel time;
  
	public static void main(String[] args){
		
	
	  getLength();	
	  getWidth();
	  getMines();
	  
	  restart = new JButton();
	  restartIcon = new ImageIcon(new ImageIcon("restart.jpg").getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
		restart.setIcon(restartIcon);
		restart.setOpaque(false);
		restart.setFocusPainted(false);
		restart.setBorderPainted(false);
		restart.setContentAreaFilled(false);
		restart.setBorder(BorderFactory.createEmptyBorder(20,300,0,0));
	  restart.addActionListener(new ActionListener(){
		  
		  public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				
				if(timer.isRunning()){
					timer.stop();
					counter = 0;
				}
				gameRestart();
			
			}
		  
	  }); 
	  
	 
	time = new JLabel();
	 ActionListener taskPerformer = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	        counter++;
	        time.setText("Time: " + counter);
	        time.setFont(new Font("Monospace", Font.BOLD, 40));
	        time.setForeground(Color.WHITE);
	        time.setBorder(BorderFactory.createEmptyBorder(20,200,0,0));
	      }
	    };
	    timer = new Timer(1000 ,taskPerformer);
	    
	    timer.start();
	    
	  
	    
	  otherPanel = new JPanel();
	  otherPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	  otherPanel.setLayout(new GridLayout(1, 3, 0, 0));
	  otherPanel.setBackground(new Color(27, 11, 110));
	 		
	  minePanel = new JPanel(); 
	  minePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	  minePanel.setLayout(new GridLayout(length, width, 0, 0));
	  
	 
	  frame = new JFrame();
	  minePanel.setBackground(new Color(27, 11, 110));
	
	  //frame.setExtendedState(JFrame.NORMAL); 
	  //frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	 
	  frame.add(otherPanel, BorderLayout.NORTH);
	  frame.add(minePanel, BorderLayout.CENTER);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setTitle("Minesweeper");
	 
	  frame.pack();
	  
	  label = new JLabel();
	  label.setText("Flags Remaining: " + flags);
	  label.setFont(new Font("Monospace", Font.BOLD, 40));
	  label.setForeground(Color.WHITE);
	  label.setBorder(new EmptyBorder(20,20,0,0));
	  otherPanel.add(label);
	  otherPanel.add(time);
	  otherPanel.add(restart);
	  
	
	  frame.setVisible(true); 
	  
	 @SuppressWarnings("unused")
	  Grid grid = new Grid(length, width, mines);
	  
	
	  
	 
	
	}



	
    
  
	
	
	

  public static void getLength(){
   
    do{
     try{
        length = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the length of the grid from 10 to 30", "Length", JOptionPane.INFORMATION_MESSAGE));
       
        if (length < 10 || length > 30)
           JOptionPane.showMessageDialog(frame, "Length must be a number between 10 and 30");
        
      }catch(NumberFormatException e){	
    	  JOptionPane.showMessageDialog(frame, "Length must be a number between 10 and 30");
      }
     }while (length < 10 || length > 30);
    
   }
  
  public static void getWidth(){
    
    do{
     try{
        width = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the width of the grid from 10 to 30", "Width", JOptionPane.INFORMATION_MESSAGE));
        if (width < 10 || width > 30)
          JOptionPane.showMessageDialog(frame, "Width must be a number between 10 and 30");
      }catch(NumberFormatException e){	
        System.exit(0);
      }
     }while (width < 10 || width > 30);
    
   }
  
  public static void getMines(){
   
    do{
       try{
          mines = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of mines between 10 to 30", "Number of Mines", JOptionPane.INFORMATION_MESSAGE));
          flags = mines;
          if (mines < 10 || mines > 30)
            JOptionPane.showMessageDialog(frame, "Number of mines must be a number between 10 and 30");
        }catch(NumberFormatException e){	
          System.exit(0);
        }
       }while (mines < 10 || mines > 30);

     }  
  
  public static JPanel getPanel(){
	  return minePanel; 
  }
  public static int getMine() {
	   return mines;
  }
   public static int getGridWidth() {
	   return width;
   }
   public static int getGridLength() {
	   return length;
   }
  
   public static void gameRestart() {
	   main(null);
   }
 
}