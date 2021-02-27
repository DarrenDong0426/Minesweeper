import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Minesweeper implements ActionListener{
  
  private static int length;
  private static int width;
  private static int mines;
  private static JPanel otherPanel; 
  private static JPanel minePanel;
  public static JFrame frame; 
  public static JLabel label;
  public static int flags;
  private static JButton restart;

	public static void main(String[] args){
		
	  getLength();	
	  getWidth();
	  getMines();
	  
	  restart = new JButton("Click here to start a new game.");
	  restart.addActionListener(new ActionListener(){
		  
		  public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				gameRestart();
			}
		  
	  }); 
	  
	 
	  otherPanel = new JPanel();
	  otherPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	  otherPanel.setLayout(new GridLayout(1, 3, 0, 0));
	  otherPanel.setBackground(Color.BLUE);
	 		
	  minePanel = new JPanel(); 
	  minePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	  minePanel.setLayout(new GridLayout(length, width, 0, 0));
	 
	  frame = new JFrame();
	  minePanel.setBackground(Color.BLUE);
	 
	 
	  frame.add(otherPanel, BorderLayout.NORTH);
	  frame.add(minePanel, BorderLayout.CENTER);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setTitle("Minesweeper");
	  frame.setVisible(true); 
	  //frame.pack();
	  
	  label = new JLabel();
	  label.setText("Flags Remaining: " + flags);
	  otherPanel.add(label);
	  otherPanel.add(restart);
	 
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
        getLength();
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
        JOptionPane.showMessageDialog(frame, "Width must be a number between 10 and 30");
        getWidth();
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
          JOptionPane.showMessageDialog(frame, "Number of mines must be a number between 10 and 30");
          getMines();
        }
       }while (mines < 10 || mines > 30);

     }  
  
  public static JPanel getPanel(){
	  return minePanel; 
  }
   
   public static void gameRestart() {
	   main(null);
   }

}