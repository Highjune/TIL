// java ArrayDemo1 45 + 78 = 
//계산기 만들기. 다 하고 나서 명령 프롬프트에서 실행해보기. p213 예제 5-17
public class ArrayDemo1 {
	public static void main(String[] array) { 
		
		if(array.length != 4) {
			System.out.println("잘못 입력하셨습니다.");
			System.exit(-1);  // Q) 
			
		}//if을 통과했다는 말은 방이 4개라는 말		
			String firstStr = array[0]; // "45"
			int first = Integer.parseInt(firstStr); //"45" --> 45
			
			String op = array[1]; // "+"      //Q) 책에서는 왜 charAt으로 바꿈?
			
			String secondStr = array[2]; // "78"
			int second = Integer.parseInt(secondStr); //"78" --> 78
	
			switch(op) {
			case "+" : 
				System.out.printf("%d + %d = %d\n", first, second, (first+second));
				break;
			case "-" :
				System.out.printf("%d - %d = %d\n", first, second, (first-second));
				break;
			case "x" :
				System.out.printf("%d x %d = %d\n", first, second, (first*second));
				break;
			case "/" :
				System.out.printf("%d / %d = %d\n", first, second, (first/second));
				break;
			case "%" :
				System.out.printf("%d %% %d = %d\n", first, second, (first%second)); //%를 찍으려면 %%를 써야 된다.
				break;
			default : 
			}
		}
		}



















