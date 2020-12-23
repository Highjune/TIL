import java.util.Scanner;
import java.util.Calendar;

public class ZodianSign {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Calendar now = Calendar.getInstance();
		int current_year = now.get(Calendar.YEAR);
		
		System.out.print("이름 : "); String name = scan.next();
		System.out.print("출생년도 : "); int born_year = scan.nextInt();
		System.out.printf("%s(%d세)님!", name, (current_year-born_year +1));
		switch(born_year%12) {
		case 0 : System.out.println("원숭이띠입니다."); break;
		case 1 : System.out.println("닭띠입니다."); break;
		case 2 : System.out.println("개띠입니다."); break;
		case 3 : System.out.println("돼지띠입니다."); break;
		case 4 : System.out.println("쥐띠입니다."); break;
		case 5 : System.out.println("소띠입니다."); break;
		case 6 : System.out.println("범띠입니다."); break;
		case 7 : System.out.println("토끼띠입니다."); break;
		case 8 : System.out.println("용띠입니다."); break;
		case 9 : System.out.println("뱀띠입니다."); break;
		case 10 : System.out.println("말띠입니다."); break;
		default : System.out.println("양띠입니다."); break;
		
		
		}
	}

}
