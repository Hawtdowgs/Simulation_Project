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
	
	public Rabbit() {
		fed = true;
		alive = true;
		
		
	}
	
	
	/**
	 * gets a value  from the player for how many rabbits are in the simulation
	 * @return
	 */
	public static int getRab() {
		int spawnNum;
		Scanner input = new Scanner(System.in);
		
		System.out.println("how many rabbits?");
		spawnNum = input.nextInt();
		return spawnNum;
	}
	
	
	/**
	 * populates an array which corresponds to the grid for where the rabbits start
	 * @return
	 */
	public static int[][] Rabb() {
		boolean Rabbi;
		int x, y, s, inp, rSex = 0;
		int[][] ranSpawn = new int[20][20];
		Random r = new Random();
		
		inp = Rabbit.getRab();
		
		for(int i = 0; i < inp; i++) {

			x = r.nextInt(20);
			y = r.nextInt(20);
			s = r.nextInt(20);
		
			if(ranSpawn[x][y] == 1) {
				i--;
			}else {	
				if(s == 1) {
				rSex = 1;
				}else {
				rSex = 0;
				}
			ranSpawn[x][y] = 1;
			}
			System.out.println(rSex + "  " + x + " " + y);
		}
		return ranSpawn;
		
		
		
		
	}

}
