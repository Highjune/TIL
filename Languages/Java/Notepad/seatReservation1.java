package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

// 내가 처음에 푼 것 (map으로)
public class seatReservation1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int seatNumber = 0;
		int choice = 1;
		int number = 0;
		String possibleComment = "예약가능";
		String impossibleComment = "예약됨";
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for(int i = 0 ; i < 10 ; i++) { // 0 ~ 9 
			map.put(i+1, possibleComment); // 다 넣음. 1-예약가능, 2-예약가능 ... 10-예약가능
		}
		
		while(choice != 0) {
			System.out.println(" > 좌석을 예약하시겠습니까? (예-1 아니오-0)");
			choice = scan.nextInt();
			if(choice == 1) {
				System.out.println("==현재 좌석 상태==");
	
				for(Integer key : map.keySet()) { 
					System.out.print("[" + key + "]" + map.get(key) + "\t");
					
					number++;
					
					if(number%4==0) {
						System.out.println();
					}
				}
				System.out.println("[*]종료 : 0");
				System.out.println();
				System.out.print("몇 번째 좌석을 예매하시겠습니까?");	
				
				seatNumber = scan.nextInt();				
				
				if(seatNumber==0) { // 예약 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				} else if(map.get(seatNumber).equals("예약가능")) {  //예약가능한 경우					
					map.put(seatNumber, impossibleComment); // 예약됨으로 변경
				} else if(map.get(seatNumber).equals("예약됨")){ //예약불가능한 경우
					System.out.println("-----------------------------");
					System.out.println("이미 예약된 좌석입니다.");
					System.out.println("다른 좌석을 선택해주세요");
					System.out.println("-----------------------------"); 					
				}	
			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}					
		}
	}
}


