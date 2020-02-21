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
	
	
	
	public static void Rabb() {
		int x, y, inp;
		int[][] ranSpawn = new int[20][20];
		Random r = new Random();
		
		inp = Rabbit.getRab();
		
		for(int i = 0; i < inp; i++) {
			
			
			x = r.nextInt(19 - 0 + 1) + 0;
			y = r.nextInt(19 - 0 + 1) + 0;
		
			ranSpawn[x][y] = 1;
			System.out.println(ranSpawn[x][y]);
			
		
		}
		
		
		
		
	}

}
