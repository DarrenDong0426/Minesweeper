import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Grid extends Minesweeper
					implements ActionListener{
	
	public int nonminecount = 0;
	
	public static Button[][] grid; 
	
	public Grid(){}
	
	public Grid(int l, int w, int m) {
		
		grid = new Button[l][w];
		
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length; j++){
				Button button = new Button();
				grid[i][j] = button;
				getPanel().add((button.getButton()));
			}				
		}
		
		SetMines(l, w, m);
		setNumbers(l, w);
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