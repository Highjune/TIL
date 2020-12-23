import java.util.Scanner;

public class EnumDemo1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("좋아하시는 계절(영문대문자로) : ");
		String seasonStr = scan.next();
		
		Season season = null; //선언
		
		if(seasonStr.equals("SPRING")) 				season = Season.SPRING;
		else if(seasonStr.equals("SUMMER"))			season = Season.SUMMER;
		else if(seasonStr.equals("FALL"))			season = Season.FALL;
		else if(seasonStr.equals("WINTER"))			season = Season.WINTER;
		
		switch(season) {
			case SPRING : 	System.out.println("오 봄이고"); break;
			case SUMMER :	System.out.println("덥네잉");	  break;
			case FALL	:	System.out.println("시리다");	  break;
			case WINTER	:	System.out.println("춥당");	  break;
		}
	}
}
