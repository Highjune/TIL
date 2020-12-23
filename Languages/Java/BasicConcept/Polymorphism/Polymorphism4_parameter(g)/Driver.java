package test;

public class Driver {
	public void driver(Vehicle vehicle) {
		// 파라미터가 Vehicle의 자식이 들어오면 자식 객체가 각각 재정의한 run() 메서드가 실행이 된다.
		// 자동 타입 변환이 발생한다. 
		// Vehicle vehicle = bus; (자동 형변환) bus가 부모형인 vehicle이 된다. 
		vehicle.run();
	}
}
