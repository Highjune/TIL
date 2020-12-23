package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * > 좌석을 예약하시겠습니까? (예-1 아니오-0) : 1
	==현재 좌석 상태==
	[1]예약가능 [2]예약가능 [3]예약가능 [4]예약가능
	[5]예약가능 [6]예약가능 [7]예약가능 [8]예약가능 
	[9]예약가능 [10]예약가능
	몇 번째 좌석을 예약하시겠습니까? 2
	예약되었습니다.
	> 좌석을 예약하시겠습니까? (예-1 아니오-0) : 1
	==현재 좌석 상태==
	[1]예약가능 [2]예약됨 [3]예약가능 [4]예약가능 
	[5]예약가능 [6]예약가능 [7]예약가능 [8]예약가능 
	[9]예약가능 [10]예약가능 
	몇 번째 좌석을 예약하시겠습니까? 2
	이미 예약된 좌석입니다.
	> 좌석을 예약하시겠습니까? (예-1 아니오-0) : 0
	프로그램을 종료합니다.
*
*/

// array로 해결한 다른 사람 답 참고하여 다시 문제 품
public class seatReservation2 {
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		
		String[] array = new String[10];
		int option = 1;
		
		for(int i = 0 ; i < array.length ; i++) {
			array[i] = "예약가능"; 
		}
		
		int cnt = 0;
		int seatNumber = 0;
		
		while(option!=0) { // 좌석 예약 옵션 : 1
			System.out.println("> 좌석을 예약하시겠습니까? (예-1 아니오-0)");
			option = scan.nextInt();
			if(option==1) { 
				// 좌석 보여주기
				System.out.println("==현재 좌석 상태==");
				for(int i = 0 ; i < array.length; i++) {
					System.out.print("[" + (i+1) + "]" + array[i] + "\t");
					cnt++;
					if(cnt%4==0) System.out.println();
				}
				System.out.println();
				System.out.println("몇 번째 좌석을 예약하시겠습니까?");
				seatNumber = scan.nextInt();
				if(array[seatNumber-1].equals("예약가능")) { 
					array[seatNumber-1] = "예약됨";
				} else if(array[seatNumber].equals("예약됨")) {
					System.out.println("이미 예약된 좌석입니다.");					
					continue;
				}
			} else { //좌석 예약 옵션 : 0
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}			
	}		
}

