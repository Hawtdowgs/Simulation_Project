package simulationProject;
import java.util.Random;
import java.util.Scanner;
public class wolf {
private boolean[][] wPosition, wSex, wFull, wMove, wMoved;
private double rate, wolf, wolfI, wolfF;
private int initial, sex, pos1, pos2, fedMod;
	@SuppressWarnings("null")
	public wolf() {
		wPosition = new boolean[20][20];
		wSex = new boolean[20][20];
		wFull = new boolean[20][20];
		wMove = new boolean[20][20];
		wMoved = new boolean[20][20];
		wolf = 0;
		rate = 0;
		wolfI = 0;
		wolfF = 0;
		fedMod = 0;
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
			wolfI = input.nextDouble();
			
			if(wolfI < 0 ||  wolfI > 400) {
				validStart = false;
			}else {
				validStart = true;
			}
		}while(validStart == false);
		
		//loops until a valid growth rate has been entered
		do {
			System.out.println("What it the reproductive rate of the wolves?");
			System.out.println("values between 0 and 1 inclusive are valid:");
			rate = input.nextDouble() * 100;
			
			if(rate < 0 || rate > 1) {
				validRate = false;
			}else {
				validRate = true;
			}
		}while(validRate == false);
		
		
		
		
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
				
				for(int i = 0; i < wolfI; i++) {
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
				}
				return wPosition;
	}
	
	public boolean[][]wMove(){
		Random r = new Random();
		//resets the moved boolean
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				wMoved[i][j] = false;
			}
		}
		//check for current spots with a wolf
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				//if there is a wolf on the space that has not yet been moved
				if(wPosition[i][j] == true && wMoved[i][j] == false) {
					pos1 = r.nextInt(20);
					pos2 = r.nextInt(20);
					wPosition[pos1][pos2] = true;
					wMoved[pos1][pos2] = true;
					wPosition[i][j] = false;
				}
			}
		}
		return wPosition;
	}
	
	public boolean[][] wEat(boolean[][] rabPosition) {
		
		//loops to find all wolves and to see if they are fed or not
		for(int i = 0; i < 20; i ++) {
			for(int j = 0; j < 20; j++) {
				if(wPosition[i][j] == true && wFull[i][j] == false) {
					
					try {
						if(rabPosition[i][j] == true) {
							rabPosition[i][j] = false;
							wFull[i][j] = true;
						}else if(rabPosition[i+1][j] == true) {
							rabPosition[i+1][j] = false;
							wFull[i][j] = true;
						}else if(rabPosition[i+1][j+1] == true) {
							rabPosition[i+1][j+1] = false;
							wFull[i][j] = true;
						}else if(rabPosition[i+1][j-1] == true) {
							rabPosition[i+1][j-1] = false;
							wFull[i][j] = true;
						}else if(rabPosition[i][j+1] == true) {
							rabPosition[i][j+1] = false;
							wFull[i][j] = true;
						}else if(rabPosition[i][j-1] == true) {
							rabPosition[i][j-1] = false;
							wFull[i][j] = true;
						}else if(rabPosition[i-1][j] == true) {
							rabPosition[i-1][j] = false;
							wFull[i][j] = true;
						}else if(rabPosition[i-1][j+1] == true) {
							rabPosition[i-1][j+1] = false;
							wFull[i][j] = true;
						}else if(rabPosition[i-1][j-1] == true) {
							rabPosition[i-1][j-1] = false;
							wFull[i][j] = true;
						}
					}catch(Exception e) {
						
					}
					
				}
			}
		}
		return rabPosition;
	}
	
	public boolean[][] wReproduce(boolean [][]position){
		//check for fed wolves
		
		//finds the next population of the wolves
		if(wolfI >= 2) {
			wolfF = (rate*fedMod) * (wolfI) * (1-(wolfI/400));
			wolfF= (int) Math.round(wolfF);
		}
		wolf = wolfI - wolfF;
		
		
		
		return position;
	}
	
}
