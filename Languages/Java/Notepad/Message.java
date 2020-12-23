package practice;

import java.util.Scanner;

public class Message {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			System.out.println("<<상대에게 보낼 매시지를 입력해 주세요");
			System.out.println("<<만일 그만 보내시려면 그냥 엔터치세요");
			
		while(true) {
			System.out.println("보낼 메시지 입력 : ");
			String msg = scan.next();
			if(msg.length() ==0 ) {
				break;
			}
			System.out.println("메시지 : " + msg);
			
			
		}
		
	}
}
