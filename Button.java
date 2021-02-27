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
	public int number; 
	private ImageIcon mineIcon;
	private ImageIcon flagIcon; 
	//public int nonminecount = 0;
		
	public Button(){
		
		button = new JButton();
		button.setBackground(Color.GRAY);
		button.setForeground(Color.BLUE);
		button.setBorder(BorderFactory.createBevelBorder(1));
		button.addMouseListener(new MouseAdapter(){
			
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)){
					if (button.getIcon() == null){
						if (MineCheck() == true){
							mineIcon = new ImageIcon(new ImageIcon("Mine.png").getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
							button.setIcon(mineIcon);
							
							int dialogButton = JOptionPane.showConfirmDialog (null, "You lost! Do you want to play again?","GAME OVER",JOptionPane.YES_NO_OPTION);
							
							if(dialogButton == JOptionPane.YES_OPTION) {
								frame.setVisible(false);
								gameRestart();
							}
							if(dialogButton == JOptionPane.NO_OPTION) {
								System.exit(0);
							}
						}

							
						
				
						
						if (MineCheck() == false){
							button.setText("" + number);
							button.setFont(new Font("Monospace", Font.BOLD, button.getHeight()/2));
							button.setBackground(new Color(7, 66, 115));
							button.setEnabled(false);	
							nonminecount++;
						}
						
						if(nonminecount == getGridLength()*getGridWidth() - getMine()){
							System.exit(0);
						}
					} 
				}
				else if (SwingUtilities.isRightMouseButton(e)){
					if (button.isEnabled() == true){
						if (button.getIcon() == null && flags > 0){
							flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
							button.setIcon(flagIcon);
							flags--;
						}
						else if(button.getIcon() == flagIcon && button.getIcon() != null){
							button.setIcon(null);
							flags++;
						}
					label.setText("Flags Remaining: " + flags);
					}
				}
			}
			
		});
		isMine = false;
		number = 0;
		
		if(isRevealed() == true) {
			System.out.print("you are fat");
		}
		else {
			System.out.print("it worked");
		}
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
	
	/*public boolean hasWon() {
		boolean val = true;
		if(grid[0][1] == null) {
			System.out.println("You are fat");
		}
		for(int i = 0; i<Grid.grid.length; i++) {
			for(int j = 0; j<Grid.grid[i].length; j++) {
				if(Grid.grid[i][j].getButton().isEnabled() && Grid.grid[i][j].MineCheck() == false) {
					val = false;
				}
			}
		}
		return val;
	}*/



	
}