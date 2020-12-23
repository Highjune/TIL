package practice;

public class Driver {
	public void drive(Vehicle vehicle) { //인터페이스 vehicle을 구현한 Bus객체나 Taxi객체 모두 들어올 수 있다.
		if(vehicle instanceof Bus) { //vehicle 매개 변수가 참조한느 객체가 bus인지 조사
			Bus bus = (Bus) vehicle; // Bus 객체일 경우 안전하게 강제 타입 변환
			bus.checkFare(); // Bus 타입으로 강제 타입 변환을 하는 이유
		}
		vehicle.run();
	}	
}
