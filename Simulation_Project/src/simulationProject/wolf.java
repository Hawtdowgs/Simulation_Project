package simulationProject;
import java.util.Random;
import java.util.Scanner;
public class wolf {
private boolean[][] wSex, wFull, wMove;
public boolean[][] wPosition;
private int[][] wolf;
private double rate;
private int initial, sex, pos1, pos2;
	@SuppressWarnings("null")
	public wolf() {
		wPosition = new boolean[20][20];
		wSex = new boolean[20][20];
		wFull = new boolean[20][20];
		wMove = new boolean[20][20];
		wolf = new int[20][20];
		rate = 0;
		initial = 0;
	}
	public void wSetUp() {
		Random r = new Random();
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		
		boolean validRate = false, validStart;
		
		//loops until a valid number has been entered
		do {
			System.out.println("How many wolves would you like to begin the simulation with?");
			System.out.println("values between 0 and 400 inclusive are valid:");
			initial = input.nextInt();
			
			if(initial < 0 ||  initial > 400) {
				validStart = false;
			}else {
				validStart = true;
			}
		}while(validStart == false);
		
		//loops until a valid growth rate has been entered
		do {
			System.out.println("What it the reproductive rate of the wolves?");
			System.out.println("values between 0 and 1 inclusive are valid:");
			rate = input.nextDouble();
			
			if(rate < 0 || rate > 1) {
				validRate = false;
			}else {
				validRate = true;
			}
		}while(validRate == false);
			
	}
	
	public boolean[][] getWolfGrid() {
		return wPosition;
	}
	
	@SuppressWarnings("null")
	public boolean[][] wSpawn(){
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		
		
		//sets every space to a non wolf
				for(int i = 0; i < 20; i ++) {
					for(int j = 0; j < 20; j ++) {
						wPosition[i][j] = false;
						wSex[i][j] = false;
					}
				}
				
				for(int i = 0; i < initial; i++) {
					pos1 = r.nextInt(19-0+1)+0;
					pos2 = r.nextInt(19-0+1)+0;
					sex = r.nextInt(1-0+1)+0;
					
					wPosition[pos1][pos2] = true;
					
					//gives the wolf a sex helping determine whether the wolf can reproduce
					if(sex == 0) {
						wSex[pos1][pos2] = true;
					}else {
						wSex[pos1][pos2] = false;
					}
					System.out.println(pos1 + " " + pos2 + " " + wPosition[pos1][pos2]  + " " + wSex[pos1][pos2]);
				}
				return wPosition;
	}
	
}
