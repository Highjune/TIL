import java.util.Vector;


public class Main {
	public static void main(String[] args) {
		//프로그램을 돌릴 때 vector를 새로 만드는 것이 아니라 기존의 vector를 파일에서 들고 오는 것.
		
		
		String path = "C:/temp/sungjuklist.ser";
		Init init = new Init(path); //Init은 초기화(프로그램이 메모리에 올라올 때)
		Vector<Student> vector = init.init(); //init()을 통해 기존의 vector를 파일(DB말고)에서 들고옴. 
		//ex) 만약 기존의 vector에 3명이 있는 상태라면 input부터는 4번째 학생부터 담게 되는 것임.
		//그런데 우리는 지운상태에서 시작
		//vector는 null이 아님. init()이 끝나면 새로운 vector를 만들었거나, 파일에서 역직렬화해서 만든 vector이든지.
		//파일없음 -> 없으니까 createnewFile로 파일 만들어짐 -> 파일만들어지면서 ois가 null이니까 vector가 null -> vertor가 null이니까 리턴하면서 new vector로 넘겨줌 -> 메인입장에서는 
		
		Input input = new Input(vector); //null이 아닌 vector이거나 null이 아닌상태에서 새로운 vector를 만들어주거나임. 그래서 밑의input.input()을 호출하니깐 그 때는 무조건 vector는 null이 아니다. 
		input.input(); //그래서 
		
		Calc calc = new Calc(vector);  
		calc.calc();
		  
//		Sort sort = new Sort(vector);  
//		sort.sort();
//		
		Output output = new Output(vector, path);  //여기에서의 vector는 이미 calc등 다 정리된 상태//지정한 곳(path)에 저장.
		output.output();
	}
}

