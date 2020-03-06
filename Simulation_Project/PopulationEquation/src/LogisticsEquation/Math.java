package LogisticsEquation;
import java.util.Scanner;
public class Math {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double wolf = 2;
		
		System.out.println("how many rounds would you like to play?");
		double round = input.nextDouble();
		
		System.out.println("what is the growth rate?");
		double rate = input.nextDouble() *10;
		for(int i = 0; i < round; i++) {
			System.out.println(wolf);
			
			wolf =  rate * (wolf/100) * (1-(wolf/100));
		}
	}

}
