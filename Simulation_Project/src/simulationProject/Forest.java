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
					if(forestGrid[i - 1][j] == true || forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true || forestGrid[i][j + 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}catch(Exception e) {
					error = e.getStackTrace()[0].getLineNumber();
					
					if(error == 41) {
						if(i == 0 && forestGrid[19][j] == true) {
							reproducibleSquares[i][j] = true;
						}else if(j == 0 && forestGrid[i][19] == true) {
							reproducibleSquares[i][j] = true;
						}else if(i == 19 && forestGrid[0][j] == true) {
							reproducibleSquares[i][j] = true;
						}else if(j == 19 && forestGrid[19][j] == true) {
							reproducibleSquares[i][j] = true;
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
