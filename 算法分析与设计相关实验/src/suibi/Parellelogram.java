package suibi;

class Quadrangle{
	public static void draw(Quadrangle q){
		System.out.println("��ְ�");
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
			System.out.println("1�ְ��Ƕ���");
		}else{
			System.out.println("1�ְֲ��Ƕ���");
		}
		
		if(q instanceof Square){
			Square s = (Square)q;
			System.out.println("2�ְ��Ƕ���");
		}else{
			System.out.println("2�ְֲ��Ƕ���");
		}
		
		Quadrangle q2 = new Parellelogram();
		if(q2 instanceof Parellelogram){
			Parellelogram p2 = (Parellelogram)q2;
			System.out.println("3�ְ��Ƕ���");
		}else{
			System.out.println("3�ְֲ��Ƕ���");
		}
	}

}
