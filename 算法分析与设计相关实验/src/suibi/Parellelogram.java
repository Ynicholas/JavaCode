package suibi;

class Quadrangle{
	public static void draw(Quadrangle q){
		System.out.println("你爸爸");
	}
}

class Square extends Quadrangle{
	
}

class Anything{
	
}

public class Parellelogram extends Quadrangle{

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quadrangle q = new Quadrangle();
		if(q instanceof Parellelogram){
			Parellelogram p = (Parellelogram)q;
			System.out.println("1爸爸是儿子");
		}else{
			System.out.println("1爸爸不是儿子");
		}
		
		if(q instanceof Square){
			Square s = (Square)q;
			System.out.println("2爸爸是儿子");
		}else{
			System.out.println("2爸爸不是儿子");
		}
		
		Quadrangle q2 = new Parellelogram();
		if(q2 instanceof Parellelogram){
			Parellelogram p2 = (Parellelogram)q2;
			System.out.println("3爸爸是儿子");
		}else{
			System.out.println("3爸爸不是儿子");
		}
	}

}
