package simulationProject;

import java.util.Random;

public class Forest {
	Random r = new Random();
	private int initialForestSquares;
	private int forestReproductionRate;
	private boolean[][] forestGrid;
	private boolean[][] reproducibleSquares;
	public Forest(int fs, int fr) {
		initialForestSquares = fs;
		forestReproductionRate = fr;
		forestGrid = new boolean[20][20];
	}
	
	public void generateForestGrid() {
		int x, y;
		for(int i = 0;i < initialForestSquares;i++) {
			do {
				x = r.nextInt(20);
				y = r.nextInt(20);
			}while(forestGrid[x][y] = true);
			forestGrid[x][y] = true;
		}
	}
	
	public void checkForestReproductionSquares() {
		//Compile a list of squares that are next to trees
		//For each square in the forest grid:
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				//Corner cases: check only the squares next to the selected square which are inside the grid
				if(i == 0 && j == 0) {
					if(forestGrid[i + 1][j] == true || forestGrid[i][j + 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}else if(i == 0 && j == 19) {
					if(forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}else if(i == 19 && j == 0) {
					if(forestGrid[i - 1][j] == true || forestGrid[i][j + 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}else if(i == 19 && j == 19) {
					if(forestGrid[i - 1][j] == true || forestGrid[i][j - 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				//Edge cases: check only the squares next to the selected square which are inside the grid	
				}else if(i == 0) {
					if(forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true || forestGrid[i][j + 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}else if(i == 19) {
					if(forestGrid[i - 1][j] == true || forestGrid[i][j - 1] == true || forestGrid[i][j + 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}else if(j == 0) {
					if(forestGrid[i - 1][j] == true || forestGrid[i + 1][j] == true || forestGrid[i][j + 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}else if(j == 19) {
					if(forestGrid[i - 1][j] == true || forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}else{
					if(forestGrid[i - 1][j] == true || forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true || forestGrid[i][j + 1] == true) {
						if(forestGrid[i][j] == false) {
							reproducibleSquares[i][j] = true;
						}else{
							reproducibleSquares[i][j] = false;
						}
					}else{
						reproducibleSquares[i][j] = false;
					}
				}
			}
		}
	}
}
