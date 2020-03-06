/*
 * Konner Friesen
 * February 18, 2020
 */
package simulationProject;

import java.util.Scanner;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int startTrees, startRabbits, startWolves;
		boolean[][]forestGrid = new boolean[20][20];
		boolean[][]RabbitSpawn = new boolean[20][20];
		boolean[][] wolfPosition = new boolean[20][20];
		wolf wolf = new wolf();
		Rabbit rabbit = new Rabbit();
		
		wolf.wSetUp();
		wolfPosition = wolf.wSpawn();
		
		System.out.println("how many rounds would you like to display?");
		int round = input.nextInt();
		for(int i = 0; i < round; i++) {
			wolf.wReproduce();
		}
		
		
		
		
		do {
			System.out.print("Choose number of starting trees: ");
			startTrees = input.nextInt();
			System.out.println(startTrees);
		}while(startTrees < 0 || startTrees > 400);
		
		Forest forest = new Forest(startTrees, 3);
		SimulationGui simulationGui = new SimulationGui(forestGrid);
		
		forest.generateForestGrid();
		
		forestGrid = forest.returnForestGrid();
		
		
	}

}
