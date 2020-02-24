package simulationProject;

import java.util.Random;
import java.util.Scanner;

public class Wolf {

	public static void main(String[] args) {
		//formatting, what's that?
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		
		boolean[][] alive, sex, full, move;
		int initial, pos1, pos2 ;
		int[][] wolf = null;
		System.out.println("how many wolves would you like to start with?");
		initial = input.nextInt();
		
		for(int i = 0; i < initial; i++) {
			pos1 = r.nextInt(20-0+1)+0;
			pos2 = r.nextInt(20-0+1)+0;
			
			System.out.print(" " + pos1 + " ");
			System.out.println(" "+ pos2);
		}
	}

}
