
import java.util.ArrayList;

public class Grid extends Minesweeper{
	
	
	
	ArrayList<Button> length;
	ArrayList<ArrayList<Button>> width;
	
	public Grid(){}
	
	public Grid(int l, int w, int m) {
		
		width = new ArrayList<ArrayList<Button>>(w);
		
		for (int i = 0; i < l; i++){
			length = new ArrayList<Button>(l);
			width.add(length);
			for (int j = 0; j < w; j++){
				Button button = new Button();
				getPanel().add((button.getButton()));
				(width.get(i)).add(button);
			}				
		}
		
		SetMines(l, w, m);
		SetNumbers(l, w);
	}
		
	public void SetMines(int l, int w, int m){
		while (m > 0){
			int x = (int)(Math.random() * l);
			int y = (int)(Math.random() * w);
			if ((((width.get(x)).get(y)).MineCheck()) == false){
				((width.get(x)).get(y)).IntoMine();
				m--;
			}
		}		
	}
	
	public void SetNumbers(int l, int w){
		for(int i = 0; i < l; i++){
			for (int j = 0; j < w; j++){
				int nums = 0; 
				if (isInGrid(i - 1, j) == true){
					if (((width.get(i-1)).get(j)).MineCheck() == true)
						nums++;
				}
				if (isInGrid(i - 1, j - 1) == true){
					if (((width.get(i-1)).get(j-1)).MineCheck() == true)
						nums++;
				}
				if (isInGrid(i - 1, j + 1) == true){
					if (((width.get(i-1)).get(j+1)).MineCheck() == true)
						nums++;
				}
				if (isInGrid(i, j - 1) == true){
					if (((width.get(i)).get(j-1)).MineCheck() == true)
						nums++;
				}
				if (isInGrid(i, j + 1) == true){
					if (((width.get(i)).get(j+1)).MineCheck() == true)
						nums++;
				}
				if (isInGrid(i + 1, j) == true){
					if (((width.get(i+1)).get(j)).MineCheck() == true)
						nums++;
				}
				if (isInGrid(i + 1, j - 1) == true){
					if (((width.get(i+1)).get(j-1)).MineCheck() == true)
						nums++;		
				}
				if (isInGrid(i + 1, j + 1) == true){
					if (((width.get(i + 1)).get(j+1)).MineCheck() == true)
						nums++;	
				}
				((width.get(i)).get(j)).IntoNumbers(nums);
			}
		}
	}
	
	public boolean isInGrid(int i, int j){
		if (i < 0 || j < 0 || i > width.size() - 1|| j > length.size() - 1)
			return false;
		return true;
	}
}
