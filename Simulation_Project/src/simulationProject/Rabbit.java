/*
 * Konner Friesen	
 * Feb 19, 2020
 */
package simulationProject;

import java.util.Random;
import java.util.Scanner;

public class Rabbit {
	int inSpawn;
	boolean alive, fed, roam, reproduce;
	
	public static int getRab() {
		int spawnNum;
		Scanner input = new Scanner(System.in);
		
		System.out.println("how many rabbits?");
		spawnNum = input.nextInt();
		return spawnNum;
	}
	
	
	
	public Rabbit() {
		int x, y, inp;
		int[][] ranSpawn = null;
		Random r = new Random();
		
		inp = Rabbit.getRab();
		
		for(int i = 0; i < inp; i++) {
			
			
			x = r.nextInt(20 - 0 + 1) + 1;
			y = r.nextInt(20 - 0 + 1) + 1;
			
			ranSpawn[x][y] = 1;
			
		
		}
		
		
	}

}
