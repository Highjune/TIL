package practice;

import java.util.Scanner;

//잔돈 구하기
//
/*
Money : 6666661 
50000원 : 133
10000원 : 1
5000원 : 1
1000원 : 1
500원 : 1
100원 : 1
50원 : 1
10원 : 1
5원 : 0
1원 : 1
Again(y/n) ? : 
 *
 */
public class Changes {
   public static void main(String[] args) {

      Changes md = new Changes();
      Scanner scan = new Scanner(System.in);
      int money = -1;
      String y_n = "";
      do {
         money = md.input(scan);
         md.output(money);
         System.out.println("Again(y/n) ? : ");
         y_n = scan.next();
      }while(y_n.equals("y") || y_n.equals("Y"));   
//      }while(y_n.equalsIgnoreCase("y")); // 이렇게 해도 됨   
         System.out.println("==end==");
   }
   
      int input(Scanner scan) {
         System.out.println("Money : ");
         return scan.nextInt();
      }
   
      void output(int money) {
         int[] array = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
         for(int i = 0 ; i<array.length ; i++) {
            System.out.println(array[i] + "원 : " + money/array[i] + "개");
            money = money%array[i];
         }
      }
   
}