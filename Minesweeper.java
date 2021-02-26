import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Minesweeper {
  
  private static int length;
  private static int width;
  private static int mines;
  private static JPanel panel;
  private static JFrame frame; 
  private static JLabel label;
  private static GridBagConstraints gbc;

	public static void main(String[] args){
		
	  getLength();	
	  getWidth();
	  getMines();
	 // gbc = new GridBagConstraints();
	  panel = new JPanel(); 
	  panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	  panel.setLayout(new GridLayout(length, width, 0, 0));
	 // panel.setLayout(new GridBagLayout());
	 
	  frame = new JFrame();
	panel.setBackground(Color.BLUE);
	 
	 
		
	  frame.add(panel, BorderLayout.CENTER);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setTitle("Minesweeper");
	  frame.setVisible(true); 
	  frame.pack();
	 
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
          if (mines < 10 || mines > 30)
            JOptionPane.showMessageDialog(frame, "Number of mines must be a number between 10 and 30");
        }catch(NumberFormatException e){	
          JOptionPane.showMessageDialog(frame, "Number of mines must be a number between 10 and 30");
          getMines();
        }
       }while (mines < 10 || mines > 30);

     }  
  
  public static JPanel getPanel(){
	  return panel; 
  }
   public static GridBagConstraints getGBC() {
	   return gbc;
   }
}