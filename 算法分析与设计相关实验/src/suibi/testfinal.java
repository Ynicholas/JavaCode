package suibi;

import java.util.Random;

class Test{
	int j;
	Test(int i){
		j = i;
	}
}

public class testfinal {
	static Random rand = new Random();
	private final int VALUE_1 = 9;
	private static final int VALUE_2 = 10;
	private final Test test = new Test(1);
	private Test test2 = new Test(2);
	private final int[] a ={1,2,3,4,5,6};
	private final int i4 = rand.nextInt(20);
	private static final int i5 = rand.nextInt(20);
	public String toString(){
		return i4+" "+i5+" ";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testfinal tf = new testfinal();
		System.out.println(tf);
		testfinal tf2 = new testfinal();
		System.out.println(tf2);
		
	}

}
