package simulationProject;

import java.util.Scanner;
import java.util.Random;

public class Wolf2 {
private int xPos;
private int yPos;
	public Wolf2(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public int[] move() {
		Random r = new Random();
		int direction;
		int[]newPos = new int[2];
		
		direction = r.nextInt(4);
		
		if(direction == 0) {
			xPos = xPos + 1;
		}else if(direction == 1) {
			yPos = yPos + 1;
		}else if(direction == 2) {
			xPos = xPos - 1;
		}else if(direction == 3) {
			yPos = yPos - 1;
		}
		
		newPos[0] = xPos;
		newPos[1] = yPos;
		
		return newPos;
	}
	
	public void reproduce() {
		//Search around for a square for the new wolf to sit on
		Wolf2 wolf = new Wolf2(xPos, yPos + 1);
	}
	
	public void eat() {
		
	}
	
	public int[] getPos() {
		int[]wolfPos = new int[2];
		
		wolfPos[0] = xPos;
		wolfPos[1] = yPos;
		
		return wolfPos;
	}
}
