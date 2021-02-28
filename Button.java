import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;





public class Button extends Grid{

	private JButton button;
	private boolean isMine;
	private int number; 
	private int index1;
	private int index2;
		
	public Button(int i, int j){
		
		index1 = i;
		index2 = j;
		button = new JButton();
		button.setBackground(Color.GRAY);
		button.setForeground(Color.BLUE);
		button.setBorder(BorderFactory.createBevelBorder(1));
	
		isMine = false;
		number = 0;
	}
	
	public JButton getButton(){
		return button;
	}
	
	public void IntoMine(){
		isMine = true;
	}
	
	public boolean MineCheck(){
		return isMine; 
	}
	
	public void IntoNumbers(int n){
		number = n;
	}
	
	public int NumberCheck(){
		return number;
	}
	
	public int getIndex1(){
		return index1;
	}
	
	public int getIndex2(){
		return index2; 
	}
	



	
}