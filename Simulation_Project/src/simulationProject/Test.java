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
		Rabbit rabbit = new Rabbit();
		int startTrees, startRabbits, startWolves;
		boolean[][]forestGrid = new boolean[20][20];
		
		System.out.print("Choose number of starting trees: ");
		do {
			startTrees = input.nextInt();
		}while(startTrees < 0 || startTrees > 400);
		
		Forest forest = new Forest(startTrees, 3);
		forest.generateForestGrid();
		forestGrid = forest.returnForestGrid();
		startRabbits = rabbit.getRabbits();
		rabbit.createRabbitGrid(startRabbits);
		SimulationGui simulationGui = new SimulationGui(forestGrid);
		
		
	}

}
