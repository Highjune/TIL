//EXCEPTION 의도적 발생시키기 자바의 정석p424


public class ExceptionDemo5 {
	public static void main(String[] args) {
		try {  //try에서 던지면 catch가 받는다. 단 타입이 맞을 경우만.
			Student chulsu = new Student(101);	
			System.out.println(chulsu);
		}catch(RuntimeException e ) { //위에서 생성자가 만들어짐과 동시에 runtimeexception을 던졋으니 여기서 runtimexception으로 받았음.
			System.out.println(e.getMessage());  
		}
	}
}



class Student{
	private int kor;
	public Student(int kor) {
		if(kor>=0 && kor <= 100)	this.kor = kor;
		else throw new RuntimeException("국어점수는 0부터 100점까지 입니다.");// 주소를 만들어서 던져야 되므로 new~ 

	}
	@Override
	public String toString() {
		return "Student [kor=" + kor + "]";
	}
	
}