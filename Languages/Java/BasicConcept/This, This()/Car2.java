//������ this()
public class Car2 {
	String color;
	String gearType;
	int door;
	
	Car2() {
		//Car2��ſ� this��� ���� ����.
		this("white", "auto", 4); // ������ Car2(String color, String gearType, int door)�� ȣ��
	}
	
	Car2(String color) {
		this(color, "auto", 4); // ������ Car2(String color, String gearType, int door)�� ȣ��
	} 
	
	Car2(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
