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
		int chooseTree, error;
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
								}else if(rabbitSpawn[i + 1][j] == false) {
									rabbitSpawn[i + 1][j] = true;
								}else if(rabbitSpawn[i][j - 1] == false) {
									rabbitSpawn[i][j - 1] = true;
								}else if(rabbitSpawn[i][j + 1] == false) {
									rabbitSpawn[i][j + 1] = true;
								}
							}
						}catch(Exception e) {
							error = e.getStackTrace()[0].getLineNumber();
							if(error == 112) {
								if(i == 0) {
									
								}
								if(i == 19) {
									
								}
								if(j == 0) {
									
								}
								if(j == 19) {
									
								}
							}else if(error == 113) {
								
							}else if(error == 115) {
								
							}else if(error == 117) {
								
							}else if(error == 119) {
								
							}
						}
					}
					
				}
			}
		}
		
		return forestGrid;
	}
}