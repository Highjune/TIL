//import java.util.Scanner;
//public class IfDemo {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);  //Ű����� ����
//	System.out.println("�����Ͻô� ���� : ");
//	String season = scan.next();
//	System.out.println("season = " + season);
//	
//	if(season == "spring") {
//		System.out.println("������, ���޷�");
//	}else if(season == "summer") {
//		System.out.println("���, ��ī�þ�");		
//	}else if(season == "fall") {
//		System.out.println("�ڽ���, ����");
//	}else {
//		System.out.println("����, ��ȭ");		
//	}
//	}
//}
//////////�������� logic ������ �� �߻�? season ���� �ּҰ� ����Ǿ������ϱ� ���� ���ص� �ȵȴ�. �׷��� ���ڿ��� ���� ���� == �� ���� �ȵȴ�. ==�� ���� ���� �� ��
////season�� �ּ��̸�, spring, summer, fall�� �� ����.

//�׷��� �Ʒ��� ���� �Ѵ�.(equals�Լ� ��)

//import java.util.Scanner;
//public class IfDemo {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);  //Ű����� ����
//	System.out.println("�����Ͻô� ���� : ");
//	String season = scan.next();
//	System.out.println("season = " + season);
//	
//	if(season.equals("spring")) {                      //season�̶�� ���� ���� spring? �׷��� equals�� �Լ��� ������ true, Ʋ���� false�� ��ȯ�ϴ´�. ���ڿ��� �񱳴� equals��� �޼ҵ��Լ��� ����.
//		System.out.println("������, ���޷�");
//	}else if(season.equals("summer")) {
//		System.out.println("���, ��ī�þ�");		
//	}else if(season.equals("fall")) {
//		System.out.println("�ڽ���, ����");
//	}else if(season.equals("winter")) {
//		System.out.println("����, ��ȭ");		
//	}
//	}
//}
///���� ���� switch ������ ---------------------------------------------------------------------------
import java.util.Scanner;
public class If_Season {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);  //Ű����� ����
	System.out.println("�����Ͻô� ���� : ");
	String season = scan.next();
	System.out.println("season = " + season);
	switch(season) {
	case "spring":
		System.out.println("������, ���޷�"); break;
	case "summer":
		System.out.println("���, ��ī�þ�"); break;
	case "fall":
		System.out.println("�ڽ���, ����"); break;
	case "winter":
		System.out.println("����, ��ȭ"); break;
				
}
}
}







