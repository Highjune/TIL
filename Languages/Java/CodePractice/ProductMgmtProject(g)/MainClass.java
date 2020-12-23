import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


//이 프로그램은 시작될 때 직렬화되어있는 파일로부터 직렬화되어있는 제품들을 가져오는 것.
//

public class MainClass {
	
	//이렇게 바깥쪽으로 멤버변수(지역변수 말고)로 빼면 input calc sort output들이 파라미터를 넘길 필요가 없다.
	//멤버변수의 lifescycle은 내가 고민해야되는 것임.
	//지역변수는 자동적으로 생성되고 사라지기 때문에 lifecycle을 고민할 필요가 없다.
	private ArrayList<Product> list; //Q) 이렇게 쓰면 파라미터를 쓸 필요가 없다. 멤버변수를 쓰면 되니까=> 이 말이 무슨말?, 이거때문에 input calc sort output => 파라미터를 넘길 필요가 없다? 
	
	public MainClass() { // 생성자 초기화
		this.list = new ArrayList<Product>(); // productdata.txt보면 7개가 있는 줄 알지만 여유롭게 10개로 잡기. 기본값 : 10개임
	}
	
	public static void main(String[] args) {
		MainClass mc = new MainClass(); //생성자 호출 : arraylist만들어짐. product가 만들어진 것이 아니라 product가 들어갈 수첩이 만들어진 것임
		mc.input();    mc.calc();   mc.sort();  mc.output();
	}
	// ==> 이 프로그램은 제일 위에서부터 여기까지 실행되는 것임.
	
	
	//아래의 각 함수들은 return값이 다 없어서 void 
	private void input(){   //빨대의 시작 : productdata.txt // 빨대의 끝 : 메모리의 입력버퍼
		try(FileInputStream fis = new FileInputStream("productdata.txt")) {  // 파일로부터 읽어들이는 것임 FileInputstream은 autocloseable 자식이므로 finally에 close로 닫을 필요없다.
			byte [] buffer = new byte[fis.available()]; //available은 한번에 다 읽어들임. (양은 무관) - 어떻게 보면 안 좋은 방식. 파일의 사이즈를 모르기 때문에
			int number = fis.read(buffer); //읽어들인 데이터를 버퍼에 담음. 
			String str = new String(buffer, 0, number); // byte -> string으로 변환 : String 생성자로.(buffer에 들어있는 것을 0부터 number수만큼 String으로 변환
			StringTokenizer st = new StringTokenizer(str, "\n"); //productdata.txt를 \n기준으로 짜름. (줄바꿈)
			String [] array = new String[st.countTokens()]; //7개의 갯수만큼 배열 만듬 7개의 방
			for(int i = 0 ; i < array.length ; i++) {
				array[i] = st.nextToken();  //NOTEBOOK	36000	5000	4700	2000 (첫번째 token) => 그런데 여기에 스페이스바가 있으니 밑에서 그것을 기준으로 짜름
				Scanner scan = new Scanner(array[i]).useDelimiter("\\s+"); // \\s+ 스페이스 1개 이상
				Product product = new Product(scan.next(), scan.nextInt(), scan.nextInt(), 
						                                      scan.nextInt(), scan.nextInt());
				this.list.add(product);
			}
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	private void calc(){
		for(Product product : this.list) { //list에서 product들을 다 꺼냄
			//bolpen을 읽어서 밑의 게산 쭉 ~ , books, pencil 등도 마찬가지
			
			//판매금액 = 수량 * 판매단가
			int sales = product.getQty() * product.getSalemoney(); 
			//매입금액 = 수량 * 매입단가
			int buy = product.getQty() * product.getBuymoney();
			//이익금 =판매금액 - (매입금액 + 운송료)
			int sum = sales - (buy + product.getFee());
			//이익율 = 이익금 / 매입금액 * 100
			double rate = sum / (double)buy * 100; //sum buy 100이 다 정수이므로 어느 한쪽을 double로 만들어준 것
			product.setSum(sum);  product.setRate(rate);
		}
	}
	
	private void sort(){ //sort하기 위해서는, product가 comparable의 자식이어야 한다. 그래서 product 클래스에서 implements Comparable해준 것임
		Collections.sort(this.list); //sort()의 parameter는 list계열의 자식 다 가능하니까 this.list 넣었음
		//sort하고 싶으면 Comparable의 자식이 되어야 하고(compareto구현) sort에서는 Collections.sort()해주면 끝
		//이렇게 정렬하면 오히려 버블정렬, 셀렉션 정렬 같은 것들의 알고리즘으로 정렬하는 것보다 훨씬 더 쉽다.	
	}
	
	
	private void output(){ 
		//PrintStream를 이용하여 파일로 출력 
		//print를 하는데 stream으로 끝나면? byte기반
		//우리가 여태껏 해온 Sytem.out.println(표준출력)의 type은 PrintStream이다.(우리가 해왔던 것)
		
		try(PrintStream ps = new PrintStream(//PrintStream(OutputStream)이므로 outputstream의 자식들(그 중 FileOutPutStrema)은 다 사용가능하다
				new FileOutputStream("C:/temp/productresult.txt"))){
			for(Product product : this.list) { //반복의 대상 : list
				ps.println(product); //printstream으로 내보내는 것. printstream의 빨대는 "C:/temp/productresult.txt"을 가리키고 있으니까 이 파일에 내보낸다는 말 
			}//이렇게 prinstream은 지정된 빨대에 출력
			ps.flush(); //for문으로 빨대에 반복해서 다 내보내고 한번에 flush
			System.out.println("Save Success");
		}catch(IOException ex) {
			System.out.println(ex);
		}
		//제품을 한번에 내보내면 autoflush 안해줘도 된다.
		//api에서 autocloseble 자식이면 finally안 써도 된다.
		
		
		}
	}

