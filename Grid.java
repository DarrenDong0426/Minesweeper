import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Grid extends Minesweeper{
	
	public int nonminecount = 0;
	
	public static Button[][] grid; 
	private ImageIcon mineIcon;
	private ImageIcon flagIcon; 
	
	public Grid(){}
	
	public Grid(int l, int w, int m) {
		
		grid = new Button[l][w];
		
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length; j++){
				final Button button = new Button();
				button.getButton().addMouseListener(new MouseAdapter(){
					
					public void mouseReleased(MouseEvent e) {
						if (SwingUtilities.isLeftMouseButton(e)){
							if (button.getButton().getIcon() == null){
								if (button.MineCheck() == true){
									mineIcon = new ImageIcon(new ImageIcon("Mine.png").getImage().getScaledInstance(button.getButton().getWidth(), button.getButton().getHeight(), Image.SCALE_DEFAULT));
									button.getButton().setIcon(mineIcon);
									
									int dialogButton = JOptionPane.showConfirmDialog (null, "You lost! Do you want to play again?","GAME OVER",JOptionPane.YES_NO_OPTION);
									
									if(dialogButton == JOptionPane.YES_OPTION) {
										frame.setVisible(false);
										gameRestart();
									}
									if(dialogButton == JOptionPane.NO_OPTION) 
										System.exit(0);
								}
								if (button.MineCheck() == false){
									button.getButton().setText("" + button.NumberCheck());
									button.getButton().setFont(new Font("Monospace", Font.BOLD, button.getButton().getHeight()/2));
									button.getButton().setBackground(new Color(7, 66, 115));
									button.getButton().setEnabled(false);	
									nonminecount++;
								}
							} 
						}
						else if (SwingUtilities.isRightMouseButton(e)){
							if (button.getButton().isEnabled() == true){
								if (button.getButton().getIcon() == null && flags > 0){
									flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(button.getButton().getWidth(), button.getButton().getHeight(), Image.SCALE_DEFAULT));
									button.getButton().setIcon(flagIcon);
									flags--;
								}
								else if(button.getButton().getIcon() == flagIcon && button.getButton().getIcon() != null){
									button.getButton().setIcon(null);
									flags++;
								}
							label.setText("Flags Remaining: " + flags);
							}
						}
					if(checkWin() == true)
						System.exit(0);
					}
				});
				grid[i][j] = button;
				getPanel().add((button.getButton()));
			}				
		}
		
		
		SetMines(l, w, m);
		setNumbers(l, w);
	}
		
	public boolean checkWin() {
		System.out.println("Work"); 
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				System.out.println(grid[i][j]);
				if (grid[i][j].MineCheck() == false){
					if (grid[i][j].getButton().isEnabled() == true)
						return false;
				}
			}
		}
		return true;
		
	} 

	public void SetMines(int l, int w, int m){
		while (m > 0){
			int x = (int)(Math.random() * l);
			int y = (int)(Math.random() * w);
			if (grid[x][y].MineCheck() == false){
				grid[x][y].IntoMine();
				m--;
			}
		}		
	}
	
	public void setNumbers(int l, int w){
		for(int i = 0; i < l; i++){
			for (int j = 0; j < w; j++){
				int nums = 0; 
				if (isInGrid(i - 1, j) == true){
					if (grid[i-1][j].MineCheck() == true)
						nums++;
				}
				if (isInGrid(i - 1, j - 1) == true){
					if (grid[i-1][j-1].MineCheck() == true)
						nums++;
				}
				if (isInGrid(i - 1, j + 1) == true){
					if (grid[i-1][j+1].MineCheck() == true)
						nums++;
				}
				if (isInGrid(i, j - 1) == true){
					if (grid[i][j-1].MineCheck() == true)
						nums++;
				}
				if (isInGrid(i, j + 1) == true){
					if (grid[i][j+1].MineCheck() == true)
						nums++;
				}
				if (isInGrid(i + 1, j) == true){
					if (grid[i+1][j].MineCheck() == true)
						nums++;
				}
				if (isInGrid(i + 1, j - 1) == true){
					if (grid[i+1][j-1].MineCheck() == true)
						nums++;		
				}
				if (isInGrid(i + 1, j + 1) == true){
					if (grid[i+1][j+1].MineCheck() == true)
						nums++;	
				}
				grid[i][j].IntoNumbers(nums);
			}
		}
	}
	
	public boolean isInGrid(int i, int j){
		if (i < 0 || j < 0 || i > grid.length - 1|| j > grid[i].length - 1)
			return false;
		return true;
	}
	
	
}