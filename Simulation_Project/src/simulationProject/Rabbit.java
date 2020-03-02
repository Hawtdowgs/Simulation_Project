/*
 * Konner Friesen	
 * Feb 19, 2020
 */
package simulationProject;

import java.util.Random;
import java.util.Scanner;
public class Rabbit {
	int inSpawn;
	boolean[][] rabbitSpawn, alive, fed, roam, reproduce, actionUsed;
	
	public Rabbit() {
		fed = new boolean[20][20];
		alive = new boolean[20][20];
		roam = new boolean[20][20];
		reproduce = new boolean[20][20];
		rabbitSpawn = new boolean[20][20];
		actionUsed = new boolean[20][20];
	}
	/**
	 * Gets number of rabbits on the grid
	 * @return
	 */
	public static int getRabbits() {
		int spawnNum;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("how many rabbits?");
			spawnNum = input.nextInt();
		}while(spawnNum < 1 || spawnNum > 399);
		return spawnNum;
	}
	/**
	 * Creates grid which shows where all the rabbits are
	 */
	public void createRabbitGrid() {
		int x, y, inp;
		Random r = new Random();
		
		inp = Rabbit.getRabbits();
		
		for(int i = 0; i < inp; i++) {
			x = r.nextInt(20);
			y = r.nextInt(20);
		
			rabbitSpawn[x][y] = true;	
		}
			
	}
	/**
	 * Codes what the rabbits do when the simulation increments
	 */
	public boolean[][] tick(boolean[][]forestGrid) {
		//Wrap edges - when i or j = 20, set i or j = 0, and when i or j = -1, set i or j = 19
		Random r = new Random();
		int chooseTree, error, exception, direction;
		boolean validMove;
		//For each rabbit:
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				if(rabbitSpawn[i][j] == true) {
					//If not fed and next to a tree, eat
					if(fed[i][j] == false) {
						try {
							if(forestGrid[i - 1][j] == true) {
								fed[i][j] = true;
								forestGrid[i - 1][j] = false;
								actionUsed[i][j] = true;
							}else if(forestGrid[i + 1][j] == true) {
								fed[i][j] = true;
								forestGrid[i + 1][j] = false;
								actionUsed[i][j] = true;
							}else if(forestGrid[i][j - 1] == true) {
								fed[i][j] = true;
								forestGrid[i][j - 1] = false;
								actionUsed[i][j] = true;
							}else if(forestGrid[i][j + 1] == true) {
								fed[i][j] = true;
								forestGrid[i][j + 1] = false;
								actionUsed[i][j] = true;
							}
						}catch(Exception e) {
							/*
							 * This catch statement wraps the edges
							 * by adding or subtracting 20 when an
							 * OutOfBoundsException is thrown
							 */
							error = e.getStackTrace()[0].getLineNumber();
							if(error == 64) {
								fed[i][j] = true;
								forestGrid[19][j] = false;
								actionUsed[i][j] = true;
							}else if(error == 68) {
								fed[i][j] = true;
								forestGrid[0][j] = false;
								actionUsed[i][j] = true;
							}else if(error == 72) {
								fed[i][j] = true;
								forestGrid[i][19] = false;
								actionUsed[i][j] = true;
							}else if(error == 76) {
								fed[i][j] = true;
								forestGrid[i][0] = false;
								actionUsed[i][j] = true;
							}
						}
					}
					//If fed and next to another rabbit, reproduce
					if(fed[i][j] == true) {
						try {
							//If next to another rabbit, place a rabbit on the first available space without one
							if(rabbitSpawn[i - 1][j] == true || rabbitSpawn[i + 1][j] == true || rabbitSpawn[i][j - 1] == true || rabbitSpawn[i][j + 1] == true) {
								if(rabbitSpawn[i - 1][j] == false)	{
									rabbitSpawn[i - 1][j] = true;
									actionUsed[i][j] = true;
								}else if(rabbitSpawn[i + 1][j] == false) {
									rabbitSpawn[i + 1][j] = true;
									actionUsed[i][j] = true;
								}else if(rabbitSpawn[i][j - 1] == false) {
									rabbitSpawn[i][j - 1] = true;
									actionUsed[i][j] = true;
								}else if(rabbitSpawn[i][j + 1] == false) {
									rabbitSpawn[i][j + 1] = true;
									actionUsed[i][j] = true;
								}
							}
						}catch(Exception e) {
							error = e.getStackTrace()[0].getLineNumber();
							if(error == 112) {
								try {
									if(rabbitSpawn[i - 1][j] == false)	{
										rabbitSpawn[i - 1][j] = true;
										actionUsed[i][j] = true;
									}else if(rabbitSpawn[i + 1][j] == false) {
										rabbitSpawn[i + 1][j] = true;
										actionUsed[i][j] = true;
									}else if(rabbitSpawn[i][j - 1] == false) {
										rabbitSpawn[i][j - 1] = true;
										actionUsed[i][j] = true;
									}else if(rabbitSpawn[i][j + 1] == false) {
										rabbitSpawn[i][j + 1] = true;
										actionUsed[i][j] = true;
									}
								}catch(Exception ex) {
									exception = ex.getStackTrace()[0].getLineNumber();
									
									if(exception == 131) {
										rabbitSpawn[19][j] = true;
										actionUsed[i][j] = true;
									}else if(exception == 134) {
										rabbitSpawn[0][j] = true;
										actionUsed[i][j] = true;
									}else if(exception == 137) {
										rabbitSpawn[i][19] = true;
										actionUsed[i][j] = true;
									}else if(exception == 140) {
										rabbitSpawn[i][0] = true;
										actionUsed[i][j] = true;
									}
								}
							}else if(error == 113) {
								rabbitSpawn[19][j] = true;
								actionUsed[i][j] = true;
							}else if(error == 116) {
								rabbitSpawn[0][j] = true;
								actionUsed[i][j] = true;
							}else if(error == 119) {
								rabbitSpawn[i][19] = true;
								actionUsed[i][j] = true;
							}else if(error == 122) {
								rabbitSpawn[i][0] = true;
								actionUsed[i][j] = true;
							}
						}
					}
					
					//Else, move
					validMove = false;
					
					if(actionUsed[i][j] == false) {
						direction = r.nextInt(4);
						
						try {
							if(direction == 0) {
								if(rabbitSpawn[i - 1][j] == false) {
									validMove = true;
								}
							}else if(direction == 1) {
								if(rabbitSpawn[i + 1][j] == false) {
									validMove = true;
								}
							}else if(direction == 2) {
								if(rabbitSpawn[i][j - 1] == false) {
									validMove = true;
								}
							}else if(direction == 3) {
								if(rabbitSpawn[i][j + 1] == false) {
									validMove = true;
								}
							}
						}catch(Exception e) {
							error = e.getStackTrace()[0].getLineNumber();
							
							if(error == 186) {
								if(rabbitSpawn[19][j] == false) {
									validMove = true;
								}
							}else if(error == 190) {
								if(rabbitSpawn[0][j] == false) {
									validMove = true;
								}
							}else if(error == 194) {
								if(rabbitSpawn[i][19] == false) {
									validMove = true;
								}
							}else if(error == 198) {
								if(rabbitSpawn[i][0] == false) {
									validMove = true;
								}
							}
						}
						
						if(validMove == true) {
							try {
								if(direction == 0) {
									rabbitSpawn[i][j] = false;
									rabbitSpawn[i - 1][j] = true;
								}else if(direction == 1) {
									rabbitSpawn[i][j] = false;
									rabbitSpawn[i + 1][j] = true;
								}else if(direction == 2) {
									rabbitSpawn[i][j] = false;
									rabbitSpawn[i][j - 1] = true;
								}else if(direction == 3) {
									rabbitSpawn[i][j] = false;
									rabbitSpawn[i][j + 1] = true;
								}
							}catch(Exception e) {
								error = e.getStackTrace()[0].getLineNumber();
								
								if(error == 228) {
									rabbitSpawn[19][j] = true;
								}else if(error == 231) {
									rabbitSpawn[0][j] = true;
								}else if(error == 234) {
									rabbitSpawn[i][19] = true;
								}else if(error == 237) {
									rabbitSpawn[i][0] = true;
								}
							}
							
						}
						
					}
					
				}
			}
		}
		
		return forestGrid;
	}
	
	public boolean[][] returnRabbitGrid() {
		return rabbitSpawn;
	}
}