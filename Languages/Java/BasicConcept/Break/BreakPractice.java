
//public class BreakPractice {
//	public static void main(String[] args) {
//		int sum = 0;
//		int i  = 0 ;
//		
//		while(true) { //���ѹݺ���
//			if(sum>100)
//				break;
//			i++;
//			sum+=i;
//		}
//		System.out.println("i = " + i);
//		System.out.println("sum = " + sum);
//	}
//}

//for������ ���ѷ���

public class BreakPractice {
	public static void main(String[] args) {
		int sum = 0;
		int i  = 0 ;
		
		for(;;) { //���ѹݺ���
			if(sum>100)
				break;
			i++;
			sum+=i;
		}
		System.out.println("i = " + i);
		System.out.println("sum = " + sum);
	}
}