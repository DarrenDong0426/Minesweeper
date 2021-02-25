import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Button extends JFrame{

	private JButton button;
	private boolean isMine;
		
	public Button(){
		button = new JButton("Yes");
		button.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)){
			//Change to mine (to be implemented)
					if(!isMine){
						int g = getNumber();
						if(g == 1)
							button = new JButton("1");
						if(g == 2)
							button = new JButton("2");
						if(g == 3)
							button = new JButton("3");
						if(g == 4)
							button = new JButton("4");	
						if(g == 5)
							button = new JButton("5");		
						if(g == 6)
							button = new JButton("6");			
						if(g == 7)
							button = new JButton("7");
						if(g == 8)
							button = new JButton("8");			
					}else{
						ImageIcon mine = new ImageIcon("Mine.png");
						button = new JButton(mine);
					}
				}
				else if (SwingUtilities.isRightMouseButton(e)){
			//Change to Flag (to be implemented)
					ImageIcon flag = new ImageIcon("Flag_img.png");
					button = new JButton(flag);
				}
			}
			
		});
		
		isMine = false;
	}
	
	public int getNumber(){
		int num = 0;
		if()
			num++;
		if()
			num++;
		if()
			num++;
		if()
			num++;
		if()
			num++;
		if()
			num++;
		if()
			num++;
		if()
			num++;
		return num;
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
