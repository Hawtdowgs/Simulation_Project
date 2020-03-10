package Math_Test;
import java.util.Scanner;
import java.util.Random;
public class MathTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		double wolfI = 2, wolfF = 0, rate = 0, fMod = 0;
		boolean[][]wPos = new boolean[20][20];
		int unfed = 0;
		boolean fed = false;
		System.out.println("What is the growth rate?");
		rate = in.nextDouble();
		for(int i = 0; i < 20; i++) {
			fed = r.nextBoolean();
			System.out.println(wolfI);
			System.out.println(fed);
			if(fed == true) {
				fMod = 1.5;
				unfed = 0;
			}else {
				fMod = 1;
				unfed ++;
			}
			if(unfed == 5) {
				wolfI =  -2;
			}
			wolfF = (rate*fMod) * (wolfI) * (1-(wolfI/400)); 
			wolfF= (int) Math.round(wolfF);
			wolfI = wolfF;
		}

	}

}
