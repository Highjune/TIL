//생성자 this()
public class Car2 {
	String color;
	String gearType;
	int door;
	
	Car2() {
		//Car2대신에 this라고 쓰는 것임.
		this("white", "auto", 4); // 생성자 Car2(String color, String gearType, int door)를 호출
	}
	
	Car2(String color) {
		this(color, "auto", 4); // 생성자 Car2(String color, String gearType, int door)를 호출
	} 
	
	Car2(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
