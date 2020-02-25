package simulationProject;
import java.util.Random;
import java.util.Scanner;
public class wolf {
	

	@SuppressWarnings("null")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		
		boolean[][] wAlive = new boolean[20][20], wSex = new boolean[20][20], full = new boolean[20][20],
				move = new boolean[20][20];;
		
		//spawns wolves
		wAlive = wolfSpawn(wSex); 
		
		
	}
	
	@SuppressWarnings("null")
	public static boolean[][] wolfSpawn(boolean[][] male){
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		int pos1,pos2,initial,sex;
		boolean[][] alive = new boolean[20][20];
		
		//sets every space to have a "dead" wolf of a false gender
				for(int i = 0; i < 20; i ++) {
					for(int j = 0; j < 20; j ++) {
						alive[i][j] = false;
						male[i][j] = false;
					}
				}
				
				System.out.println("How many wolves would you like to begin the simulation with?");
				initial = input.nextInt();
				
				for(int i = 0; i < initial; i++) {
					pos1 = r.nextInt(20);
					pos2 = r.nextInt(20);
					sex = r.nextInt(2);
					
					alive[pos1][pos2] = true;
					
					
					if(sex == 0) {
						male[pos1][pos2] = true;
					}else {
						male[pos1][pos2] = false;
					}
				}
				return alive;
	}
	
	public static boolean[][] wolfFed(){
		boolean[][] fed = new boolean [20][20];
		
		
		return fed;
	}
	
}
