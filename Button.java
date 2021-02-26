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




@SuppressWarnings("serial")
public class Button extends JFrame{

	private JButton button;
	private boolean isMine;
	public int number; 
		
	public Button(){
		
		button = new JButton();
		button.setBackground(Color.GRAY);
		button.setForeground(Color.BLUE);
		button.setBorder(BorderFactory.createBevelBorder(1));
		button.addMouseListener(new MouseAdapter(){
			
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)){
					if (MineCheck() == true){
						ImageIcon imageIcon = new ImageIcon(new ImageIcon("Mine.png").getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
						button.setIcon(imageIcon);
						/*Object[] options = {"Yes",
			                    "No",
						};
			int n = JOptionPane.showOptionDialog(null,
			    "You are trash. Do you want to replay the game?",
			    "Game Over!",
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[1]);
				if (n ==  JOptionPane.QUESTION_MESSAGE) {
					System.exit(0);
				}*/
						int n = JOptionPane.showConfirmDialog(null, "Press something");
						if(n == JOptionPane.YES_NO_OPTION) {
							JOptionPane.showMessageDialog(null, "Hey");
						}
				}
					if (MineCheck() == false){
						button.setText("" + number);
						button.setFont(new Font("Monospace", Font.BOLD, button.getHeight()/2));
					}
				}
				else if (SwingUtilities.isRightMouseButton(e)){
					ImageIcon imageIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
					button.setIcon(imageIcon);
				}
			}
			
		});
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



	
}