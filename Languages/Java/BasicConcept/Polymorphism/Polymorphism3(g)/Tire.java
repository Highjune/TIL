package test;

public class Tire {
	//최대 회전수(타이어 수멍)
	public int maxRotation;
	//누적 회전수
	public int accumulatedRotation;
	//타이어의 위치
	public String location;
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {
		++accumulatedRotation;	// 누적 회전수 1 증가
		if(accumulatedRotation<maxRotation) {
			//정상 회전(누적<최대)일 경우 실행
			System.out.println(location + " Tire 수명 : " + (maxRotation-accumulatedRotation) + "회"); 
			return true;
		} else {
			//펑크일 때
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;			
		}			
		
	}
}
