package simulationProject;
import java.util.Random;
import java.util.Scanner;
public class wolf {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		
		boolean[][] wAlive = new boolean[20][20], male = new boolean[20][20], full = new boolean[20][20],
				move = new boolean[20][20];
		int initial, pos1, pos2 ;
		int[][] wolf;
		
		wAlive = wolfSpawn();
		
	}
	
	public static boolean[][] wolfSpawn(){
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		int pos1,pos2,initial;
		boolean[][] alive = new boolean[20][20];
		//sets every space to have a "dead" wolf
				for(int i = 0; i < 20; i ++) {
					for(int j = 0; j < 20; j ++) {
						alive[i][j] = false;
					}
				}
				
				System.out.println("How many wolves would you like to begin the simulation with?");
				initial = input.nextInt();
				
				for(int i = 0; i < initial; i++) {
					pos1 = r.nextInt(19-0+1)+0;
					pos2 = r.nextInt(19-0+1)+0;
					
					alive[pos1][pos2] = true;
					// System.out.println(pos1 + " " + pos2 + " " + wAlive[pos1][pos2]);
				}
				return alive;
	}
	
	
}
