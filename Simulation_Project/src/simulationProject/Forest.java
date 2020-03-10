package simulationProject;

import java.util.Arrays;
import java.util.Random;

public class Forest {
	Random r = new Random();
	private int initialForestSquares;
	private int forestReproductionRate;
	private boolean[][] forestGrid;
	private boolean[][] reproducibleSquares;
	private int[][] treeAge;
	public Forest(int fs, int fr) {
		initialForestSquares = fs;
		forestReproductionRate = fr;
		forestGrid = new boolean[20][20];
		treeAge = new int[20][20];
		reproducibleSquares = new boolean[20][20];
	}
	
	public void generateForestGrid() {
		int x, y;
		
		for(int i = 0;i < initialForestSquares;i++) {
			
			do {
				
				x = r.nextInt(20);
				y = r.nextInt(20);
				
			}while(forestGrid[x][y] == true);
			forestGrid[x][y] = true;
			
		}
	}
	
	public boolean[][] returnForestGrid() {
		return forestGrid;
	}
	
	public void checkForestReproductionSquares() {
		int error;
		//Compile a list of squares that are next to trees
		//For each square in the forest grid:
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {	
				try {
						if(forestGrid[i][j] == true) {
							if(forestGrid[i + 1][j] == false) {
								reproducibleSquares[i + 1][j] = true;
								
							}if(forestGrid[i - 1][j] == false) {
								reproducibleSquares[i - 1][j] = true;
								
							}if(forestGrid[i][j + 1] == false) {
								reproducibleSquares[i][j + 1] = true;
								
							}if(forestGrid[i][j - 1] == false) {
								reproducibleSquares[i][j - 1] = true;
								
							}	
						}
					}catch(Exception e) {
						error = e.getStackTrace()[0].getLineNumber();
						if(error == 49) {
							if(forestGrid[0][j] == false) {
								reproducibleSquares[0][j] = true;
							}else if(error == 52) {
								reproducibleSquares[19][j] = true;
							}else if(error == 55) {
								reproducibleSquares[i][0] = true;
							}else if(error == 58) {
								reproducibleSquares[i][19] = true;
							}
						}
					}
					
			}
		}
	}
	
	public void reproduce() {
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				
				
				if(reproducibleSquares[i][j] == true) {
					forestGrid[i][j] = true;
				}
			}
		}
	}
	
	public void tick() {
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				//Increments age of all trees
				if(forestGrid[i][j] == true) {
					treeAge[i][j] = treeAge[i][j] + 1;
				}
				//Kills trees which reach a certain age
				if(treeAge[i][j] >= 50) {
					forestGrid[i][j] = false;
					treeAge[i][j] = 0;
				}
			}
		}
	}
}
