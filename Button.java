import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Button extends JFrame
			implements MouseListener{

	private JButton button;
		
	public Button(){
		button = new JButton("Yes");
		button.addMouseListener(this);
	}
	
	public JButton getButton(){
		return button;
	}

	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {

	}

	
}
