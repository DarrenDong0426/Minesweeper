import java.util.ArrayList;

public class Grid{
  
  private ArrayList<Integer> length;
  private ArrayList<ArrayList<Integer>> width;
  private int numberOfMines;
  
  public Grid(int l, int w, int m){
    
    length = new ArrayList<Integer>(l);
    width = new ArrayList<ArrayList<Integer>>(w);
    numberOfMines = m;
    
  }
  
}
