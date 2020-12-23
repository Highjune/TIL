
public class Method2 {
	public static void main(String[] args) {
		int kor = 90, eng = 100, mat = 79;
		Method2 md = new Method2(); //static이 없으므로 이렇게 생성해서 주소로 불러온다.
		md.calc(kor, eng, mat);
}
	void calc(int kor1, int eng1, int mat1) {  //여기서 kor, eng, mat이라 써도 된다. 지역변수라 지역이 달라서 위랑 똑같이 써도 됨
		int total = kor1 + eng1 + mat1;
		double avg = total/3. ; 
		char grade = mygrade(avg); // 여기에서는 calc와 mygrade가 안방과 부엌 동등하므로 주소 필요없이 바로 불러낼 수 있다??
		System.out.println("total = " + total + ", avg = " + avg + ", grade = " + grade);
	}
	
	char mygrade(double avg) {//double형인 avg가 들어가게 되더라도 ABCD grade가 넘어오므로 char으로
		char grade = '\0'; //지역변수는 항상 초기화해야 된다.  Q) null로 하면 안됨. char이므로 null 값이 아니라 null 주소를 줘야됨
		grade = (avg >= 90) ? 'A' :
						(avg >= 80) ? 'B' :
							(avg >= 70) ? 'C' :
								(avg >= 60) ? 'D' : 'F';
		return grade; //돌아간다. 어디로? 자기를 호출한 곳으로 간다.
		
		}
}
///cf) null에는 null주소와 null값 2개가 있다. char인 곳에 값을 넢을 수 없으므로~ . 
//*****매우 중요
//제일 위에서 MethodDemo2 md = new MethodDemo2(); 새로운 집을 만들었기 때문에. md가 새로운 집 주소임
//MethodDemo2 md를 생성하게 되면 그 안에서 또 calc와 mygrade가 생성된다. 메인도 결국 함수이므로 static이 붙어 있으니까
//외부에 잇다고 생각. 그래서 외부에서 calc와 mygrade를 부르기 위해서는 생성 해줘야되기 때문에 new를 써서 md.~ 으로 부름
//그런데 calc와 mygrade는 결국 같은 영역(집) 안에 있는 멤버변수이기 때문에 생성해줄 필요가 없다. 그래서 그냥 바로 
//char grade = mygrade(avg); 그래서 여기서는 바로 mygrade로 불러내는 것.
//만약 calc에도 static이 붙은 상태라면 calc도 집 밖(외부, 놀이터)에 있기 때문에 또 생성후에 mygrade를 불러내야 된다.




