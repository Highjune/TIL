// java ArrayDemo1 45 + 78 = 
//���� �����. �� �ϰ� ���� ��� ������Ʈ���� �����غ���. p213 ���� 5-17
public class ArrayDemo1 {
	public static void main(String[] array) { 
		
		if(array.length != 4) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			System.exit(-1);  // Q) 
			
		}//if�� ����ߴٴ� ���� ���� 4����� ��		
			String firstStr = array[0]; // "45"
			int first = Integer.parseInt(firstStr); //"45" --> 45
			
			String op = array[1]; // "+"      //Q) å������ �� charAt���� �ٲ�?
			
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
				System.out.printf("%d %% %d = %d\n", first, second, (first%second)); //%�� �������� %%�� ��� �ȴ�.
				break;
			default : 
			}
		}
		}



















