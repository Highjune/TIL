package practice;

import java.util.Scanner;
/*
 * 홀수만 입력하세요 : 7
 * 
 *   
   *  
  * *  
 * * *  
* * * *  
 * * * 
  * * 
   * 
 */

// 내가 푼 것!!!!!!(개선이 필요함)
public class Diamond {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("홀수만 입력하세요 : ");
		int number = 0;
		number = scan.nextInt();
		for(int i = 1 ; i <= number/2 ; i++) { //  7/2 = 3
			for(int k = number/2 -i ; k >= 0 ; k--) { 
				System.out.print(" ");
			}
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for(int i = 1 ; i<=number/2 + 1 ; i++) {
			System.out.print("* ");			
		}
		
		System.out.println();
		
		for(int i = number/2 ; i>=0 ; i--) {
			for(int k = 1 ; k<=number/2-i+1 ; k++) {
				System.out.print(" ");
			}
			for(int j = i ; j >= 1  ; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("==end==");
	}	
		
}
