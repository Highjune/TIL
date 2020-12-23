//////////////////////////////////////반환타입 method 생성///////////////////////
//반환타입 Method

public class Method1 {	
	public static void main(String[] args) { 	

	Method1 md = new Method1(); 
//	md.print(72.6);    //함수에 넣기는 넣었는데, 받아오는 애를 또 만들어줘야 됨
	double result = md.print(72.6); //result는 넘어온 값
	System.out.println(result);
}
	double print(double weight) {  
		return weight*weight; //입력은 몇개나 넣어도 상관없는데, 리턴값은 무조건 종류 1개,
		// 리턴값은 무조건 종류 1개여야 되기 때문에, 아래와 같이 하면 안됨
//		String, int print(double weight) {
//			return "Hello", 40
		}

	};	





	
	
	
	