import java.util.Date;
import java.util.Hashtable;
import java.util.StringTokenizer;

//자바의 정석 p644
//문법도 아니고 자료구조도 아니고 그냥 API


public class MapDemo {
	public static void main(String[] args) {
		Date now = new Date(); //현재 날짜 시간. 자바에서 현재 날짜를 알 수 있는 가장 쉬운 방법 (미국 방식)
//		System.out.println(now); 
		System.out.println(now.toString()); 
		String str = now.toString();//Thu Jan 23 16:10:42 KST 2020
		//Tokenizing 자바에서 많이 씀. 1. String클래스 2. tokenizing클래스 3. Scanner
		//Token화 Thu Jan 23 16:10:42 KST 2020 --> 나눠져 있는 것을 확실하게 구분~		
		//문장열을 token화 하는 객체(java.util.Stringtokenizer)
		StringTokenizer st = new StringTokenizer(str);  //()안은 토큰화 할 문자열. " \t\n\r\f" 기준 -> API 보면 확인 가능.
//		System.out.println(st.countTokens());//토큰화 하면 몇 토막 되었는지 물어본다. 우리는 배열로 할 것이기 때문에 이것을 알아야 된다. 이 갯수가 배열의 갯수
		String[] array = new String[st.countTokens()];
		int i = 0;
		while(st.hasMoreTokens()) {
			array[i] = st.nextToken();
			i++;
		}
		System.out.println("오늘은" + array[5] + "년" + getMonth(array[1]) + "월" + array[2] + "일입니다.");
		
	}
		static int getMonth(String month) {
			Hashtable<String, Integer> ht = new Hashtable <String, Integer> ();
			ht.put("Jan", 1); 	ht.put("Feb", 2);		ht.put("Mar", 3);
			ht.put("Apr", 4); 	ht.put("May", 5);		ht.put("Jun", 6);
			ht.put("Jul", 7); 	ht.put("Aug", 8);		ht.put("Sep", 9);
			ht.put("Oct", 10); 	ht.put("Nov", 11);		ht.put("Dec", 12);
			return ht.get(month);
			
//		while(st.hasMoreTokens()) { //hasmorTokens이 없을 때까지.(우리는총 몇개인지 모르니까)
//			System.out.println(st.nextToken());
//		}		
	}
}

























