package test;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		// 차를 5번 움직이게 함
		for(int i = 1 ; i<=5 ; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
				case 1:
					System.out.println("앞왼쪽 HankookTire로 대체");
					car.frontLeftTire = new HankookTire("앞왼쪽", 15);
					break;
				case 2:
					System.out.println("앞으론쪽 KumoTire로 대체");
					car.frontLeftTire = new HankookTire("앞왼쪽", 15);
					break;
				case 3:
					System.out.println("뒤왼쪽 HankookTire로 대체");
					car.backLeftTire = new HankookTire("앞왼쪽", 15);
					break;
				case 4:
					System.out.println("뒤오른쪽 kumhoTire로 대체");
					car.backRightTire = new HankookTire("앞왼쪽", 15);
					break;
			}
			System.out.println("-----------------------------------");
		}
	}
}
