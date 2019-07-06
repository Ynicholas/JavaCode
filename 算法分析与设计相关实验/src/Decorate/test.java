package Decorate;

public class test {
	public static void main(String[] args){
		Decorator decorator = new FootDecorator(3);
		decorator.printlnvoice();
		
	}
}
