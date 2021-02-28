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
				final Button button = new Button(i, j);
				button.getButton().addMouseListener(new MouseAdapter(){
					
					public void mouseReleased(MouseEvent e) {
						if (SwingUtilities.isLeftMouseButton(e)){
							if (button.getButton().getIcon() == null){
								if (button.MineCheck() == true){
									mineIcon = new ImageIcon(new ImageIcon("Mine.png").getImage().getScaledInstance(button.getButton().getWidth(), button.getButton().getHeight(), Image.SCALE_DEFAULT));
									button.getButton().setIcon(mineIcon);
									reveal();
									
									int dialogButton = JOptionPane.showConfirmDialog (null, "You lost! Do you want to play again?","GAME OVER",JOptionPane.YES_NO_OPTION);
									
									if(dialogButton == JOptionPane.YES_OPTION) {
										frame.setVisible(false);
										if(timer.isRunning()){
											timer.stop();
											counter = 0;
										}
										gameRestart();
									}
									if(dialogButton == JOptionPane.NO_OPTION) 
										System.exit(0);
								}
								if (button.MineCheck() == false){
									if (button.NumberCheck() != 0)
										button.getButton().setText("" + button.NumberCheck());
									button.getButton().setFont(new Font("Monospace", Font.BOLD, button.getButton().getHeight()/2));
									button.getButton().setBackground(new Color(7, 66, 115));
									button.getButton().setEnabled(false);
									if (button.NumberCheck() == 0)
										checkEmpty(button.getIndex1(), button.getIndex2());
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
								else if (button.getButton().getIcon() != null){
									button.getButton().setIcon(null);
									flags++;
								}
							label.setText("Flags Remaining: " + flags);
							}
						}
					if(checkWin() == true){
						int dialogButton2 = JOptionPane.showConfirmDialog (null, "You won! Do you want to play again?","GAME WON",JOptionPane.YES_NO_OPTION);

						if(dialogButton2 == JOptionPane.YES_OPTION) {
							frame.setVisible(false);
							if(timer.isRunning()){
								timer.stop();
								counter = 0;
							}
							gameRestart();
						}
						if(dialogButton2 == JOptionPane.NO_OPTION) 
							System.exit(0);
					}
					label.setText("Flags Remaining: " + flags);
					}
				});
				grid[i][j] = button;
				getPanel().add((button.getButton()));
			}				
		}
		
		
		SetMines(l, w, m);
		setNumbers(l, w);
	}
		
	protected void reveal() {
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j].MineCheck() == true)
					grid[i][j].getButton().setIcon(mineIcon);
			}
		}
		
	}

	public boolean checkWin() { 
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if (grid[i][j].MineCheck() == false){
					if (grid[i][j].getButton().isEnabled() == true)
						return false;
				}
			}
		}
		return true;
	} 
	
	public void checkEmpty(int i, int j){
		if (isInGrid(i - 1, j) == true && grid[i-1][j].getButton().isEnabled() == true){
			flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(grid[i-1][j].getButton().getWidth(), grid[i-1][j].getButton().getHeight(), Image.SCALE_DEFAULT)); 
			if (grid[i-1][j].getButton().getIcon() == flagIcon){
				flags++;
			}
			if (grid[i-1][j].NumberCheck() != 0)
				grid[i-1][j].getButton().setText("" + grid[i-1][j].NumberCheck());
			grid[i-1][j].getButton().setIcon(null);
			grid[i-1][j].getButton().setFont(new Font("Monospace", Font.BOLD, grid[i-1][j].getButton().getHeight()/2));
			grid[i-1][j].getButton().setBackground(new Color(7, 66, 115));
			grid[i-1][j].getButton().setEnabled(false);	
			if (grid[i-1][j].NumberCheck() == 0)
				checkEmpty(i-1, j);
		}
		if (isInGrid(i - 1, j - 1) == true && grid[i-1][j-1].getButton().isEnabled() == true){
			flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(grid[i-1][j-1].getButton().getWidth(), grid[i-1][j-1].getButton().getHeight(), Image.SCALE_DEFAULT)); 
			if (grid[i-1][j-1].getButton().getIcon() == flagIcon){
				flags++;
			}
			if (grid[i-1][j-1].NumberCheck() != 0)
				grid[i-1][j-1].getButton().setText("" + grid[i-1][j-1].NumberCheck());
			grid[i-1][j-1].getButton().setIcon(null);
			grid[i-1][j-1].getButton().setFont(new Font("Monospace", Font.BOLD, grid[i-1][j-1].getButton().getHeight()/2));
			grid[i-1][j-1].getButton().setBackground(new Color(7, 66, 115));
			grid[i-1][j-1].getButton().setEnabled(false);	
			if (grid[i-1][j-1].NumberCheck() == 0)
				checkEmpty(i-1, j-1);
		}
		if (isInGrid(i - 1, j + 1) == true && grid[i-1][j+1].getButton().isEnabled() == true){
			flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(grid[i-1][j+1].getButton().getWidth(), grid[i-1][j+1].getButton().getHeight(), Image.SCALE_DEFAULT)); 
			if (grid[i-1][j+1].getButton().getIcon() == flagIcon){
				flags++;
			}
			if (grid[i-1][j+1].NumberCheck() != 0)
				grid[i-1][j+1].getButton().setText("" + grid[i-1][j+1].NumberCheck());
			grid[i-1][j+1].getButton().setIcon(null);
			grid[i-1][j+1].getButton().setFont(new Font("Monospace", Font.BOLD, grid[i-1][j+1].getButton().getHeight()/2));
			grid[i-1][j+1].getButton().setBackground(new Color(7, 66, 115));
			grid[i-1][j+1].getButton().setEnabled(false);	
			if (grid[i-1][j+1].NumberCheck() == 0)
				checkEmpty(i-1, j+1);
		}
		if (isInGrid(i, j - 1) == true && grid[i][j-1].getButton().isEnabled() == true){
			flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(grid[i][j-1].getButton().getWidth(), grid[i][j-1].getButton().getHeight(), Image.SCALE_DEFAULT)); 
			if (grid[i][j-1].getButton().getIcon() == flagIcon){
				flags++;
			}
			if (grid[i][j-1].NumberCheck() != 0)
				grid[i][j-1].getButton().setText("" + grid[i][j-1].NumberCheck());
			grid[i][j-1].getButton().setIcon(null);
			grid[i][j-1].getButton().setFont(new Font("Monospace", Font.BOLD, grid[i][j-1].getButton().getHeight()/2));
			grid[i][j-1].getButton().setBackground(new Color(7, 66, 115));
			grid[i][j-1].getButton().setEnabled(false);	
			if (grid[i][j-1].NumberCheck() == 0)
				checkEmpty(i, j-1);
		}
		if (isInGrid(i, j + 1) == true && grid[i][j+1].getButton().isEnabled() == true){
			flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(grid[i][j+1].getButton().getWidth(), grid[i][j+1].getButton().getHeight(), Image.SCALE_DEFAULT)); 
			if (grid[i][j+1].getButton().getIcon() == flagIcon){
				flags++;
			}
			if (grid[i][j+1].NumberCheck() != 0)
				grid[i][j+1].getButton().setText("" + grid[i][j+1].NumberCheck());
			grid[i][j+1].getButton().setIcon(null);
			grid[i][j+1].getButton().setFont(new Font("Monospace", Font.BOLD, grid[i][j+1].getButton().getHeight()/2));
			grid[i][j+1].getButton().setBackground(new Color(7, 66, 115));
			grid[i][j+1].getButton().setEnabled(false);	
			if (grid[i][j+1].NumberCheck() == 0)
				checkEmpty(i, j+1);
		}
		if (isInGrid(i + 1, j) == true && grid[i+1][j].getButton().isEnabled() == true){
			flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(grid[i+1][j].getButton().getWidth(), grid[i+1][j].getButton().getHeight(), Image.SCALE_DEFAULT)); 
			if (grid[i+1][j].getButton().getIcon() == flagIcon){
				flags++;
			}
			if (grid[i+1][j].NumberCheck() != 0)
				grid[i+1][j].getButton().setText("" + grid[i+1][j].NumberCheck());
			grid[i+1][j].getButton().setIcon(null);
			grid[i+1][j].getButton().setFont(new Font("Monospace", Font.BOLD, grid[i+1][j].getButton().getHeight()/2));
			grid[i+1][j].getButton().setBackground(new Color(7, 66, 115));
			grid[i+1][j].getButton().setEnabled(false);	
			if (grid[i+1][j].NumberCheck() == 0)
				checkEmpty(i+1, j);
		}
		if (isInGrid(i + 1, j - 1) == true && grid[i+1][j-1].getButton().isEnabled() == true){
			flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(grid[i+1][j-1].getButton().getWidth(), grid[i+1][j-1].getButton().getHeight(), Image.SCALE_DEFAULT)); 
			if (grid[i+1][j-1].getButton().getIcon() == flagIcon){
				flags++;
			}
			if (grid[i+1][j-1].NumberCheck() != 0)
				grid[i+1][j-1].getButton().setText("" + grid[i+1][j-1].NumberCheck());
			grid[i+1][j-1].getButton().setIcon(null);
			grid[i+1][j-1].getButton().setFont(new Font("Monospace", Font.BOLD, grid[i+1][j-1].getButton().getHeight()/2));
			grid[i+1][j-1].getButton().setBackground(new Color(7, 66, 115));
			grid[i+1][j-1].getButton().setEnabled(false);
			if (grid[i+1][j-1].NumberCheck() == 0)
				checkEmpty(i+1, j-1);
		}
		if (isInGrid(i + 1, j + 1) == true && grid[i+1][j+1].getButton().isEnabled() == true){
			flagIcon = new ImageIcon(new ImageIcon("Flag.png").getImage().getScaledInstance(grid[i+1][j+1].getButton().getWidth(), grid[i+1][j+1].getButton().getHeight(), Image.SCALE_DEFAULT)); 
			if (grid[i+1][j+1].getButton().getIcon() == flagIcon){
				flags++;
			}
			if (grid[i+1][j+1].NumberCheck() != 0)
				grid[i+1][j+1].getButton().setText("" + grid[i+1][j+1].NumberCheck());
			grid[i+1][j+1].getButton().setIcon(null);
			grid[i+1][j+1].getButton().setFont(new Font("Monospace", Font.BOLD, grid[i+1][j+1].getButton().getHeight()/2));
			grid[i+1][j+1].getButton().setBackground(new Color(7, 66, 115));
			grid[i+1][j+1].getButton().setEnabled(false);
			if (grid[i+1][j+1].NumberCheck() == 0)
				checkEmpty(i+1, j+1);
		}
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