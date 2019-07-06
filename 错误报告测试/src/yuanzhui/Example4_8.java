package yuanzhui;
class Circle{
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
class Circular{
	Circle bottom;
	double height;
	void setBottom(Circle c){
		bottom = c;
	}
	void setHeight(double h){
		height = h;
	}
	double getVolme(){
		return bottom.getArea()*height/3;
	}
	public void setBottomRadious(double r){
		bottom.setRadious(r);
	}
	double getBottomRadious(){
		return bottom.radious;
	}
}
public class Example4_8 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Circle circle = new Circle();
		circle.setRadious(29);
		Circular circular = new Circular();
		circular.setBottom(circle);
		circular.setHeight(128.76);
		System.out.println("圆锥底圆的半径："+circular.getBottomRadious());
		System.out.printf("圆锥底员的体积(保留三位小数)：%5.3f\n",circular.getVolme());
		circular.setBottomRadious(208);
		System.out.println("圆锥底圆的半径："+circular.getBottomRadious());
		System.out.printf("圆锥的体积(保留三位小数)：%5.3f\n",circular.getVolme());
	}

}
