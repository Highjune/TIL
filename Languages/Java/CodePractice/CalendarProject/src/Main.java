import java.util.Scanner;
public class Main { 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("몇 년, 몇 월 ? : ");
		int year = scan.nextInt(); int month = scan.nextInt();
		Main m = new Main();
		int space  = m.getWeekday(year, month);
		int maxday = m.getMaxDay(year,  month);
		m.display(space, maxday);
	}
	
	void display(int space, int maxday) {// 달력을 그리는 method임 // space는 처음에 몇칸띄워야 되는지.
		//첫 줄...
		System.out.println("日\t月\t火\t水\t木\t金\t土");
		System.out.println("--------------------------------------------------------------------");
		int count = 0;
		for(int i = 0 ; i<space; i++) {
			System.out.print("★\t"); count++; //찍을때마다 count를 헤아린다.
		}
		for(int i = 1 ; i<=maxday ; i++) {
			System.out.print(i+"\t"); count++; //i가 1이니까 
			if(count % 7 ==0) {
				System.out.println();
			}
		}
	}
	
	
	//마지막 줄 별 출력하기
	// 마지막줄 공백에 별 찍으려면 마지막 줄 엔터한 후에 count=0 으로 초기화 하고 전체-count 수 하면 된다. 그런데 
		//토요일날 끝나는 순간에는 그게 안되는데, 토요일날 끝나는 날에는 물어봐야된다.
//	if(count != 0) {
//		for(int i = 0 ; i<(7-count) ; i++) {
//			System.out.print("★\t");
//		}
//		}
//	
	
	
	int getWeekday(int year, int month) {  //해당하는 달의 1일이 무슨 요일인지 알려줌
		//1. 총 날수 계산하기
		int sum = 0;
		for(int i = 1 ; i<year ; i++) {  //서기 1년부터 작년까지 다 돔, 윤년이면 366을 아니면 365을 더함
			if(isLeapYear(i)) sum += 366;
			else sum += 365; //해당하는 년의 한 해 전에 12월 31일까지 다 더했음
		}
		for(int i = 1 ; i <=month ; i++) {
			sum += getMaxDay(year, i);  // 해당하는 년의 1월부터 해당하는 달의 한 달 전까지 더 더함
		}
		sum++; //하루만 더하면 됨. ex) 6월 말까지 다 더하고, 7월 1일을 구해야 하니깐 +1 하면 7/1일이 된다.
		return sum % 7 ;	//딱 떨어지면 일요일, 1이 남으면 월요일 ~ (대부분의 달려이 일요일부터 시작하는 이유=일요일이 7로 나눈 나머지)
	}
	int getMaxDay(int year, int month) {
		int maxday = 0;
		switch(month) {//switch, if else, 3항 연산자 등 뭐든 다 가능
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: maxday = 31; break;
		case 4:
		case 6:
		case 9:
		case 11: maxday = 30; break;
		case 2:
			if(isLeapYear(year)) maxday = 29;
			else maxday = 28;
			break;
		}
		return maxday;
	}
	boolean isLeapYear(int year){ // 윤년인지 여부 확인, is~??면 보통 boolean 을 쓴다
		//Parameter로 들어온 년도가 윤년이라면 true, 그렇지 않으면 false를 리턴하기
		if((year%400 == 0) || (year%4 ==0 && year % 100 != 0))
			return true; //if문 만족하면 true, 
		else return false; // if문 만족안하면 false; //원래는 return 밑에 아무것도 쓰면 안되는데 조건문 안에 ~
	}
}
	//static으로 안 쓰고 각 변수들을 member로 쓴 이유는, static은 공유니까 보안의 문제가 생긴다.
	//main은 작을수록 좋다. main이 할 일들을 outsourcing
	//마지막줄의 공백에도 별 찍으려면? 
	
	
