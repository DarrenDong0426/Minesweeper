import java.util.ArrayList;

public class Grid extends Minesweeper{
	
	public Grid(){}
	
	public Grid(int l, int w, int m) {
		
		ArrayList<Button> length = new ArrayList<Button>(l);
		ArrayList<ArrayList<Button>> width = new ArrayList<ArrayList<Button>>(w);
		
		for (int i = 0; i < l; i++){
			for (int j = 0; j < w; j++){
				Button button = new Button();
				getPanel().add((button.getButton()));
			}				
		}
		
		
		
	}
				
}
