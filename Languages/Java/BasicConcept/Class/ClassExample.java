package test;


//Class 객체 얻는 3가지 방법
public class ClassExample {
	public static void main(String[] args) throws Exception{
		//1번째 방법
		Class clazz1 = String.class;
		
		//2번째 방법 (예외처리 해야됨)
		Class clazz2= Class.forName("sec01.exam08.Car");
		
		//3번째 방법
		Car car = new Car();
		Class clazz3 = car.getClass();
		
		System.out.println(clazz1.getName());
		System.out.println(clazz2.getSimpleName());
		System.out.println(clazz3.getPackage().getName());
	}
	
}

class Car{}