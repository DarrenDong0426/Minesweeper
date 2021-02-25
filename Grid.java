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
	}
	
	public void SetMines(int l, int w, int m){
		while (m > 0){
			int x = (int)(Math.random() * l);
			int y = (int)(Math.random() * w);
			if ((((width.get(y)).get(x)).MineCheck()) == false){
				((width.get(y)).get(x)).IntoMine();
				m--;
			}
		}		
	}
				
}
