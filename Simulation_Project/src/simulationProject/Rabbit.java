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
	public void tick(boolean[][]forestGrid) {
		//Wrap edges - when i or j = 20, set i or j = 0, and when i or j = -1, set i or j = 19
		Random r = new Random();
		int chooseTree, error;
		//For each rabbit:
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				if(rabbitSpawn[i][j] == true) {
					//If next to a tree/plant, eat
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
					
					try {
						if(rabbitSpawn[i - 1][j] == true) {
							fed[i][j] = true;
							forestGrid[i - 1][j] = false;
							actionUsed[i][j] = true;
						}else if(rabbitSpawn[i + 1][j] == true) {
							fed[i][j] = true;
							forestGrid[i + 1][j] = false;
							actionUsed[i][j] = true;
						}else if(rabbitSpawn[i][j - 1] == true) {
							fed[i][j] = true;
							forestGrid[i][j - 1] = false;
							actionUsed[i][j] = true;
						}else if(rabbitSpawn[i][j + 1] == true) {
							fed[i][j] = true;
							forestGrid[i][j + 1] = false;
							actionUsed[i][j] = true;
						}
					}catch(Exception e) {
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
			}
		}
	}
}
		
		//If next to a rabbit of the opposite sex, reproduce
		//Otherwise, move
	

	

