package practice;

public class SwitchNoBreakCaseExample {
	public static void main(String[] args) {
		int time = (int)(Math.random()*4) + 8; // 8 <= time <= 11
		System.out.println("[현재 시각 : " + time + " 시]"  );
		System.out.println("----------------------------");
		System.out.println("         지금시간부터 할 일은 ?   ");
		
		switch(time) {
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("하루 업무 일지를 작성합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
		case 11:
			System.out.println("외근을 나갑니다.");
		case 12:
			System.out.println("점심을 먹으러 나갑니다.");
		}
	}
}
