import java.util.Scanner;
public class While1{
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
		System.out.println("<<상대에게 보낼 메시지를 입력해 주세요.>>");
		System.out.println("<<만일 그만 보내시려면 그냥 엔터치세요.>>");
	while(true) {
		System.out.print("보낼 메시지 : "); 
		String msg = scan.nextLine();
		if(msg.length() == 0) break;
		System.out.println("전송함 메시지 : " + msg);
	}
}
}