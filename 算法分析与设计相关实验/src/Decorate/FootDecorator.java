package Decorate;

public class FootDecorator extends Decorator{
	public FootDecorator(int t){
		super(t);
	}
	
	public void printlnvoice(){
		super.printlnvoice();
		System.out.println(ticket);
		System.out.println("This is the footnote of the invoice!");
	}
}
