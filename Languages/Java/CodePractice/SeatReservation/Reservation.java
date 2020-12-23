
import java.util.Scanner;

public class Reservation {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String[] array = new String[10];
      for (int i = 0; i < array.length; i++) {
         array[i] = "예약가능";
      }
      int c = 1;
      while (c != 0) {
         System.out.print("\n좌석을 예약하시겠습니까? (예 - 1 / 아니오 - 0) : \n");
         c = scan.nextInt();
         if (c == 1) {
            System.out.println("==현재 좌석 상태==");
            for (int i = 0; i < 10; i++) {
               System.out.print("[" + (i + 1) + "]" + array[i] + "\t");
               if (i % 4 == 3)
                  System.out.println();
            }
            System.out.print("\n몇 번째 좌석을 예약하시겠습니까? : ");
            int d = scan.nextInt();
            if (array[d - 1].equals("예약됨"))
               System.out.println("이미예약된 좌석입니다.");
            else
               array[d - 1] = "예약됨";
            System.out.println("==현재 좌석 상태==");
            for (int i = 0; i < 10; i++) {
               System.out.print("[" + (i + 1) + "]" + array[i] + "\t");
               if (i % 4 == 3)
                  System.out.println();
            }
         } else {
            System.out.println("프로그램을 종료합니다.");
            break;
         }

      }
   }
}