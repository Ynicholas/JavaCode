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
		// TODO �Զ����ɵķ������
		Circle circle = new Circle();
		circle.setRadious(29);
		Circular circular = new Circular();
		circular.setBottom(circle);
		circular.setHeight(128.76);
		System.out.println("Բ׶��Բ�İ뾶��"+circular.getBottomRadious());
		System.out.printf("Բ׶��Ա�����(������λС��)��%5.3f\n",circular.getVolme());
		circular.setBottomRadious(208);
		System.out.println("Բ׶��Բ�İ뾶��"+circular.getBottomRadious());
		System.out.printf("Բ׶�����(������λС��)��%5.3f\n",circular.getVolme());
	}

}
