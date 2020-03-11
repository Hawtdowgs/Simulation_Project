package simulationProject;
import java.util.Random;
import java.util.Scanner;
public class wolf {
private boolean[][] wPosition, wSex, wFull, wMoved;
private int[][] unfed;
private double rate, wolf, wolfI, wolfF;
private int sex, pos1, pos2;
	@SuppressWarnings("null")
	public wolf() {
		wPosition = new boolean[20][20];
		wSex = new boolean[20][20];
		wFull = new boolean[20][20];
		wMoved = new boolean[20][20];
		unfed = new int[20][20];
		wolf = 0;
		rate = 0;
		wolf = 0;
		wolfI = 0;
		wolfF = 0;
	}
	
	public void wSetUp() {
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		boolean validRate = false, validStart = false;
		
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
			System.out.println("**CAUTION: values higher than 3.5 can give chaotic results**");
			System.out.println("values between 1 and 3 are ideal:");
			rate = input.nextDouble() * 100;
			
			if(rate < 0) {
				validRate = false;
			}else {
				validRate = true;
			}
		}while(validRate == false);
	}
	
	@SuppressWarnings("null")
	public boolean[][] wSpawn(){
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
					do {
					pos1 = r.nextInt(20);
					pos2 = r.nextInt(20);
					if(wPosition[pos1][pos2] == false) {
						wPosition[pos1][pos2] = true;
						wMoved[pos1][pos2] = true;
						wPosition[i][j] = false;
					}
					}while(wPosition[i][j] == true);
				}
			}
		}
		return wPosition;
	}
	
	public boolean[][] wEat(boolean[][] rabPosition) {
		int error = 0;
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
						error = e.getStackTrace()[0].getLineNumber();
						
						}if(error == 126) {
							if(rabPosition[0][j] == true) {
								rabPosition[0][j] = false;
								wFull[i][j] = true;
							}
						}else if(error == 129) {
							if(i == 19 && j == 19) {
								if(rabPosition[0][0] == true) {
									rabPosition[0][0] = false;
									wFull[i][j] = true;
								}
							}else if(i == 19) {
								if(rabPosition[0][j] == true) {
									rabPosition[0][j] = false;
									wFull[i][j] = true;
								}
							}else if(j == 19) {
								if(rabPosition[i][0] == true) {
									rabPosition[i][0] = false;
									wFull[i][j] = true;
								}
							}
						}else if(error == 132) {
							if(i == 19 && j == 0) {
								if(rabPosition[0][19] == true) {
									rabPosition[0][19] = false;	
									wFull[i][j] = true;
								}
							}else if(i == 19) {
								if(rabPosition[0][j] == true) {
									rabPosition[0][j] = false;
									wFull[i][j] = true;
								}
							}else if(j == 0) {
								if(rabPosition[i][19] == true) {
									rabPosition[i][19] = false;
									wFull[i][j] = true;
								}
							}
						}else if(error == 135) {
							if(rabPosition[i][0] == true) {
								rabPosition[i][0] = false;
								wFull[i][j] = true;
							}
						}else if(error == 138) {
							if(rabPosition[i][19] == true) {
								rabPosition[i][19] = false;
								wFull[i][j] = true;
							}
						}else if(error == 141) {
							if(rabPosition[19][i] == true) {
								rabPosition[19][j] = false;
								wFull[i][j] = true;
							}
						}else if(error == 144) {
							if(i == 0 && j == 19) {
								if(rabPosition[19][0] == true) {
									rabPosition[19][0] = false;
									wFull[i][j] = true;
								}
							}else if(i == 0) {
								if(rabPosition[19][j] == true) {
									rabPosition[19][j] = false;
									wFull[i][j] = true;
								}
							}else if(j == 19) {
								if(rabPosition[i][0] == true) {
									rabPosition[i][0] = false;
									wFull[i][j] = true;
								}
							}
							
						}else if(error == 147) {
							if(i == 0 && j == 0) {
								if(rabPosition[19][19] == true) {
									rabPosition[19][19] = false;
									wFull[i][j] = true;
								}
							}else if(i == 0) {
								if(rabPosition[19][j] == true) {
									rabPosition[19][j] = false;
									wFull[i][j] = true;
								}
							}else if(j == 0) {
								if(rabPosition[i][19] == true) {
									rabPosition[i][19] = false;
									wFull[i][j] = true;
								}
							}
						}
					}
				}		
					
			}
		return rabPosition;
	}
	
	public boolean[][] wReproduce(){
		double fed = 0, wolves = 0, fMod = 0,sMod = 0, male = 0, female = 0;
		int newWolf = 0, ranPos = 0, error;
		boolean place = false;
		Random r = new Random();
		
		//check for fed wolves and the wolves sex, as well as kills starving and old wolves
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				
				//is there a wolf on this position
					if(wPosition[i][j] == true) {
						wolves ++;
						
						//has this wolf been fed
						if(wFull[i][j] == true) {
							fed++;
						}else if(wFull[i][j] == false){
							unfed[i][j] ++;
							
							//has it starved
							if(unfed[i][j] == 5) {
								wPosition[i][j] = false;
							} 
						}
						
						//what is the sex of the wolf
						if(wSex[i][j] == true) {
							male++;
						}else if(wSex[i][j] == false) {
							female++;
						}
					}
			}
		}
		//uses the sex and fullness affect the reproduction
		if(fed/wolves == 0) {
			fMod = 1;
		}else if(fed/wolves > 0 && fed/wolves < .2) {
			fMod = 1.1;
		}else if(fed/wolves > .2 && fed/wolves < .5) {
			fMod = 1.2;
		}else if(fed/wolves > .5 && fed/wolves < .7) {
			fMod = 1.3;
		}else if(fed/wolves > .7 && fed/wolves < .9) {
			fMod = 1.4;
		}else if(fed/wolves == 1) {
			fMod = 1.5;
		}
		if(female/male == 0) {
			sMod = 1;
		}else if(female/male > 0 && female/male <= .2) {
			sMod = 1.1;
		}else if(female/male > .2 && female/male <= .5) {
			sMod = 1.2;
		}else if(female/male > .5 && female/male <= .7) {
			sMod = 1.3;
		}else if(female/male > .7 && female/male < 1) {
			sMod = 1.4;
		}else if(female/male >= 1) {
			sMod = 1.5;
		}
		//find the next population of the wolves
		if(male > 0 && female > 0) {
			wolfF = (rate*fMod*sMod) * (wolves) * (1-(wolves/400));
			wolfF = (int) Math.round(wolfF);
		}else {
			wolfF = wolves;
		}
		//finds how many wolves to add
		newWolf = (int) (wolfF - wolves);
		//places the new wolves next to a mother wolf
		for(int w = 0; w < newWolf; w++) {
			if(newWolf > 0) {
				for(int i = 0; i < 20; i++) {
					for(int j = 0; j < 20; j ++) {
						if(wSex[i][j] = false) {
							//makes sure it is a valid spot that the new wolf is places on
							do {
								ranPos = r.nextInt(8);
								try {
									if(ranPos == 0) {
										wPosition[i-1][j-1] = true;
									}else if(ranPos == 1) {
										wPosition[i+1][j] = true;
									}else if(ranPos == 2) {
										wPosition[i+1][j+1] = true;
									}else if(ranPos == 3) {
										wPosition[i+1][j-1] = true;
									}else if(ranPos == 4) {
										wPosition[i][j+1] = true;
									}else if(ranPos == 5) {
										wPosition[i][j-1] = true;
									}else if(ranPos == 6) {
										wPosition[i-1][j] = true;
									}else if(ranPos == 7) {
										wPosition[i-1][j+1] = true;
									}
								}catch(Exception e) {
									error = e.getStackTrace()[0].getLineNumber();
									if(error == 333) {
										place = false;
									}else if(error == 335) {
										place = false;
									}else if(error == 337) {
										place = false;
									}else if(error == 339) {
										place = false;
									}else if(error == 341) {
										place = false;
									}else if(error == 343) {
										place = false;
									}else if(error == 345) {
										place = false;
									}else if(error == 347) {
										place = false;
									}
								}
							}while(place == false);
						}
					}
				}
			}
		}
		
		return wPosition;
	}
	
}
