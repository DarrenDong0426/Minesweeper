import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
						ImageIcon mine = new ImageIcon("Mine.png");
						button = new JButton(mine);
					}
					if (MineCheck() == false){
						button.setText("" + number);
						button.setFont(new Font("Monospace", Font.BOLD, 40));
					}
				}
				else if (SwingUtilities.isRightMouseButton(e)){
					ImageIcon flag = new ImageIcon("Flag_img.png");
					button = new JButton(flag);
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