package Decorate;

public class Decorator {
	//protected invoice ticket;
	protected int ticket;
	public Decorator(int t){
		ticket = t;
	}
	
	public void printlnvoice(){
		ticket = ticket+1;
		System.out.println(ticket);
	}
}
