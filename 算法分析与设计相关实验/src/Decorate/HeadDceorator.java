package Decorate;

public class HeadDceorator extends Decorator{
	public HeadDceorator(invoice t){
		super(t);
	}
	
	public void printlnvoice(){
		System.out.println("This is the header of the invoice");
		ticket.printlnvoice();
	}
}
