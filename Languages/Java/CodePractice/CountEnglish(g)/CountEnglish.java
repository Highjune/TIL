import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


	//constructor 생성자 (빨대 여는 역할)
	public class CountEnglish {
		
		//파일로부터 입력, 표준출력(화면출력)
		private BufferedInputStream bis;	//영문자이므로 byte단위로 읽어들일 것이고, byte단위의 최고부모인 BufferdInputStream(버퍼링해서 읽어들이는 것이라서 효율 높다)
		
		private CountEnglish() throws IOException{//외부에서 생성하지는 않을 것이니 private 생성자.
				File file = new File("usatoday.txt");
				this.bis = new BufferedInputStream(
						new FileInputStream(file));					
		}

		//Destructor 소멸자(빨대 닫는 역할)
		@Override
		protected void finalize() { //Object에 있는 것이다.
		if(this.bis != null) {//파이프가 열려있다면
			try {
				this.bis.close();
			} catch (IOException e) {}
			}
		}	
	
	
	
	
		private void print(int[] array) {
			int count = 0;
			for(int i=0 ; i<26 ; i++) { //대문자
				System.out.printf("%c=%d\t", (char)(i+65), array[i]);
				count++;
				if(count % 5 ==0 ) System.out.println(); //한줄에 5개씩 찍기 위해서.
			}

			System.out.println();

			count = 0;
			for(int i=26 ; i<array.length; i++) { //소문자
				System.out.printf("%c=%d\t", (char)(i+71), array[i]);
				count++;
				if(count % 5 ==0 ) System.out.println();
			}
		}
		
		public static void main(String[] args) throws IOException {
			CountEnglish ce = new CountEnglish();
			int[] array = new int[52]; //대문자 26, 소문자 26개, 배열의 타입이 int이므로 각 방은 0으로 초기화 되어있다.
			int number = 0, count = 0; //count는 전체글자를 위해
			while((number = ce.bis.read()) >= 0) { //read()는 1byte씩 읽어들인다. -1이 들어올 때까지. ce.bis.read() 가 알파벳 하나씩 빨아들이는데, number는 A일 경우 65, a일 경우 97
				if(number >=65 && number <=90) {//대문자 (배열 0~25까지가 대문자의 방)
					array[number-65]++; count++;
				}else if (number >=97 && number <=122) {//소문자(26~51까지가 소문자의 방)
					array[number-71]++; count++;
				}
			}
			ce.print(array);
			System.out.println("Total Count = " + count);
		}

}
	

	
	
	

