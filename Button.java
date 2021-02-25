import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Button extends JFrame{

	private JButton button;
	private boolean isMine;
		
	public Button(){
		button = new JButton("Yes");
		button.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)){
			//Change to mine (to be implemented)
				}
				else if (SwingUtilities.isRightMouseButton(e)){
			//Change to Flag (to be implemented)
				}
			}
			
		});
		
		isMine = false;
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

	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {

	}

	
}
