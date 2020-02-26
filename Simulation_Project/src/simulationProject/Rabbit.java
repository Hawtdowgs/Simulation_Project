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
		Random r = new Random();
		int chooseTree;
		//For each rabbit:
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				if(rabbitSpawn[i][j] == true) {
					//If next to a tree/plant, eat
					//Corner cases: check only the squares next to the selected square which are inside the grid
					if(i == 0 && j == 0) {
						if(forestGrid[i + 1][j] == true || forestGrid[i][j + 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(2);
							switch(chooseTree) {
							case 0: forestGrid[i + 1][j] = false;break;
							case 1: forestGrid[i][j + 1] = false;break;	
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							//If next to another rabbit, reproduce
							if(rabbitSpawn[i + 1][j] == true || rabbitSpawn[i][j + 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(2);
								switch(chooseTree) {
								case 0: forestGrid[i + 1][j] = false;break;
								case 1: forestGrid[i][j + 1] = false;break;	
								default: System.out.print("");
								}
								actionUsed[i][j] = true;
							}
						}
					}else if(i == 0 && j == 19) {
						if(forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(2);
							switch(chooseTree) {
							case 0: forestGrid[i + 1][j] = false;break;
							case 1: forestGrid[i][j - 1] = false;break;	
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							if(rabbitSpawn[i + 1][j] == true || rabbitSpawn[i][j - 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(2);
								switch(chooseTree) {
								case 0: forestGrid[i + 1][j] = false;break;
								case 1: forestGrid[i][j + 1] = false;break;	
								default: System.out.print("");
								}
								actionUsed[i][j] = true;
							}
						}
					}else if(i == 19 && j == 0) {
						if(forestGrid[i - 1][j] == true || forestGrid[i][j + 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(2);
							switch(chooseTree) {
							case 0: forestGrid[i - 1][j] = false;break;
							case 1: forestGrid[i][j + 1] = false;break;	
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							if(rabbitSpawn[i - 1][j] == true || rabbitSpawn[i][j + 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(2);
								switch(chooseTree) {
								case 0: forestGrid[i + 1][j] = false;break;
								case 1: forestGrid[i][j + 1] = false;break;	
								default: System.out.print("");
								}
								actionUsed[i][j] = true;
							}
						}
					}else if(i == 19 && j == 19) {
						if(forestGrid[i - 1][j] == true || forestGrid[i][j - 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(2);
							switch(chooseTree) {
							case 0: forestGrid[i - 1][j] = false;break;
							case 1: forestGrid[i][j - 1] = false;break;	
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							if(rabbitSpawn[i - 1][j] == true || rabbitSpawn[i][j - 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(2);
								switch(chooseTree) {
								case 0: forestGrid[i + 1][j] = false;break;
								case 1: forestGrid[i][j + 1] = false;break;	
								default: System.out.print("");
								}
								actionUsed[i][j] = true;
							}
						}
					//Edge cases: check only the squares next to the selected square which are inside the grid	
					}else if(i == 0) {
						if(forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true || forestGrid[i][j + 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(3);
							switch(chooseTree) {
							case 0: forestGrid[i + 1][j] = false;break;
							case 1: forestGrid[i][j - 1] = false;break;
							case 2: forestGrid[i][j + 1] = false;break;
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							if(rabbitSpawn[i + 1][j] == true || rabbitSpawn[i][j - 1] == true || rabbitSpawn[i][j + 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(3);
								switch(chooseTree) {
								case 0: forestGrid[i + 1][j] = false;break;
								case 1: forestGrid[i][j - 1] = false;break;
								case 2: forestGrid[i][j + 1] = false;break;
								default: System.out.print("");
								}
								actionUsed[i][j] = true;
							}
						}
					}else if(i == 19) {
						if(forestGrid[i - 1][j] == true || forestGrid[i][j - 1] == true || forestGrid[i][j + 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(3);
							switch(chooseTree) {
							case 0: forestGrid[i - 1][j] = false;break;
							case 1: forestGrid[i][j - 1] = false;break;
							case 2: forestGrid[i][j + 1] = false;break;
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							if(rabbitSpawn[i - 1][j] == true || rabbitSpawn[i][j - 1] == true || rabbitSpawn[i][j + 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(3);
								switch(chooseTree) {
								case 0: forestGrid[i - 1][j] = false;break;
								case 1: forestGrid[i + 1][j] = false;break;
								case 2: forestGrid[i][j + 1] = false;break;	
								default: System.out.print("");
								}
								actionUsed[i][j] = true;
							}
						}
					}else if(j == 0) {
						if(forestGrid[i - 1][j] == true || forestGrid[i + 1][j] == true || forestGrid[i][j + 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(3);
							switch(chooseTree) {
							case 0: forestGrid[i - 1][j] = false;break;
							case 1: forestGrid[i + 1][j] = false;break;
							case 2: forestGrid[i][j + 1] = false;break;
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							if(rabbitSpawn[i - 1][j] || rabbitSpawn[i + 1][j] == true || rabbitSpawn[i][j + 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(3);
								switch(chooseTree) {
								case 0: forestGrid[i + 1][j] = false;break;
								case 1: forestGrid[i][j + 1] = false;break;	
								default: System.out.print("");
								}
								actionUsed[i][j] = true;
							}
						}
					}else if(j == 19) {
						if(forestGrid[i - 1][j] == true || forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(3);
							switch(chooseTree) {
							case 0: forestGrid[i - 1][j] = false;break;
							case 1: forestGrid[i + 1][j] = false;break;
							case 2: forestGrid[i][j - 1] = false;break;
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							if(rabbitSpawn[i - 1][j] == true || rabbitSpawn[i + 1][j] == true || rabbitSpawn[i][j - 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(3);
								switch(chooseTree) {
								case 0: forestGrid[i + 1][j] = false;break;
								case 1: forestGrid[i][j + 1] = false;break;	
								default: System.out.print("");
								}
								actionUsed[i][j] = true;
							}
						}
					//General case: check all neighbouring squares
					}else{
						if(forestGrid[i - 1][j] == true || forestGrid[i + 1][j] == true || forestGrid[i][j - 1] == true || forestGrid[i][j + 1] == true) {
							fed[i][j] = true;
							chooseTree = r.nextInt(4);
							switch(chooseTree) {
							case 0: forestGrid[i - 1][j] = false;break;
							case 1: forestGrid[i + 1][j] = false;break;
							case 2: forestGrid[i][j - 1] = false;break;
							case 3: forestGrid[i][j + 1] = false;break;
							default: System.out.print("");
							}
							actionUsed[i][j] = true;
						}else{
							if(rabbitSpawn[i - 1][j] == true || rabbitSpawn[i + 1][j] == true || rabbitSpawn[i][j - 1] == true || rabbitSpawn[i][j + 1] == true) {
								fed[i][j] = true;
								chooseTree = r.nextInt(4);
								switch(chooseTree) {
								case 0: forestGrid[i + 1][j] = false;break;
								case 1: forestGrid[i][j + 1] = false;break;	
								default:
								}
								actionUsed[i][j] = true;
							}
						}
					}
				}
			}
		}
		
		//If next to a rabbit of the opposite sex, reproduce
		//Otherwise, move
	}
	
	

}
