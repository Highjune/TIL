import kr.co.sist.libs.Coin;


//enum�� ���� ���� ��Դ� ���� switch
//swtich(Ÿ��) {}
//Ÿ�� : byte, short, int, char, String, enum // switch�� ���� �� �ִ� �͵�


//public class EnumDemo {
//	public static void main(String[] args) {
////		int num = (int)Weekday.WED;  //�׳� Weekday Ÿ����.
//		Weekday num = Weekday.JUNE;
//		Weekday[] array = Weekday.values(); //API���� ���� ������ values();
//		System.out.println(num);
//		
//		for(Weekday wd : array) {
//		System.out.print(wd + "-->" + wd.name());
//		System.out.println(" --> " + wd.ordinal());
//		}
//	}
//}

//public class EnumDemo {
//	public static void main(String[] args) {
//
////		int num = (int)Weekday.WED;  //�׳� Weekday Ÿ����.
////		Weekday num = Weekday.WED;
//		Coin [] array = Coin.values(); //API���� ���� ������ values();
//		for(Coin coin : array) {
////		System.out.println(coin + "-->" + coin.name());
//		System.out.println(" --> " + coin.ordinal() + "==>" + coin.getValue());		
//		}
//	}
//}
				

public class EnumDemo {
	public static void main(String[] args) {
		Coin num = Coin.DIME;
		display(num);
	}
	
	static void display(Coin num) {
		switch(num) {
		case PENNY 	:	System.out.println("1Cent"); break;
		case DIME	:	System.out.println("5Cent"); break;
		case NICKEL :	System.out.println("10Cent"); break;
		case QUARTER:	System.out.println("25Cent"); break;
	}
}
}
