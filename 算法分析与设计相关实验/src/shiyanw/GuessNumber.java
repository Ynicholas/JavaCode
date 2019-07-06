package shiyanw;

import java.util.Scanner;
import java.util.Random;
public class GuessNumber {
	public static void main (String args[]) {
		Scanner reader = new Scanner (System.in);
		Random random = new Random();
		System.out.println("给你一个1至100之间的整数，请猜测这个数");
		int realNumber = random.nextInt(100)+1;
		int yourGuess = 0;
		System.out.print("输入你的猜测:");
		yourGuess = reader.nextInt();
		while(realNumber != yourGuess)
		{
			if(yourGuess>realNumber)
			{
				System.out.print("猜大了，再输入你的猜测：");
				yourGuess = reader.nextInt();
			}
			else if(yourGuess<realNumber)
			{
				System.out.print("猜小了，再输入你的猜测：");
				yourGuess = reader.nextInt();
			}
		}
		System.out.println("猜对了");
	}
}