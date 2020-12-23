package practice;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare(); // 안됨. vehicle인터페이스에는 checkFare()가 없다. 즉 리모콘에 해당하는 버튼이 없다.
		
		Bus bus = (Bus)vehicle; //강제 타입 변환
		
		bus.run();
		bus.checkFare(); //bus클래스에는 checkFare()가 있음(bus타입 리모콘이므로 모든 버튼이 다 있음)
	}
}
