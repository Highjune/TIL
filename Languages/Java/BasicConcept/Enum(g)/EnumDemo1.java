import java.util.Scanner;

public class EnumDemo1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�����Ͻô� ����(�����빮�ڷ�) : ");
		String seasonStr = scan.next();
		
		Season season = null; //����
		
		if(seasonStr.equals("SPRING")) 				season = Season.SPRING;
		else if(seasonStr.equals("SUMMER"))			season = Season.SUMMER;
		else if(seasonStr.equals("FALL"))			season = Season.FALL;
		else if(seasonStr.equals("WINTER"))			season = Season.WINTER;
		
		switch(season) {
			case SPRING : 	System.out.println("�� ���̰�"); break;
			case SUMMER :	System.out.println("������");	  break;
			case FALL	:	System.out.println("�ø���");	  break;
			case WINTER	:	System.out.println("���");	  break;
		}
	}
}
