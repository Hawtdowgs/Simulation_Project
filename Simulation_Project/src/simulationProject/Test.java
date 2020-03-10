/*
 * Konner Friesen, Gabriel Hamm, and Spencer Molloy
 * February 18, 2020
 */
package simulationProject;

import java.util.Scanner;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rabbit rabbit = new Rabbit();
		int startTrees, startRabbits, startWolves;
		boolean running = true;
		boolean[][]forestGrid = new boolean[20][20];
		boolean[][]RabbitSpawn = new boolean[20][20];
		boolean[][] wolfPosition = new boolean[20][20];
		wolf wolf = new wolf();
		Rabbit rabbit = new Rabbit();
		
		wolf.wSetUp();
		wolfPosition = wolf.wSpawn();
		

		do {
			System.out.print("Choose number of starting trees: ");
			startTrees = input.nextInt();
			
		}while(startTrees < 0 || startTrees > 400);

		
		Forest forest = new Forest(startTrees, 3);
		

		forest.generateForestGrid();
		forestGrid = forest.returnForestGrid();
		startRabbits = rabbit.getRab();
		rabbit.createRabbitGrid(startRabbits);

		SimulationGui simulationGui = new SimulationGui(forestGrid);


		//while(running == true) {
			forest.checkForestReproductionSquares();
			forest.reproduce();
			forestGrid = forest.returnForestGrid();
			rabbit.tick(forestGrid);
			
		//}


		
		
	}


}
