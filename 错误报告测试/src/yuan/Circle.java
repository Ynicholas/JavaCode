package yuan;

public class Circle {
	double radious,area;
	void setRadious(double r){
		if(r>0){
			radious = r;
		}
	}
	double getRadious(){
		return radious;
	}
	double getArea(){
		area = 3.14*radious*radious;
		return area;
	}
}
