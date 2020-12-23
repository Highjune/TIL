

import java.util.Scanner;
public class IfDemo1_teacher {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("학번 : "); 	String hakbun = scan.next();
		System.out.print("이름 : "); 	String name = scan.next();  
		// scan.next 말고 scan.nextline 을 넣는다면 학번: ~~ 넣고 이름: (엔터) 가 되어 넘어가게 된다.
		System.out.print("국어 : "); 	int kor = scan.nextInt();
		System.out.print("영어 : "); 	int eng = scan.nextInt();
		System.out.print("수학 : "); 	int mat = scan.nextInt();
		
		int tot = kor + eng + mat;		double avg = tot/3.;
		char grade;
		
		switch((int)(avg/10)) {
		case 10: /*grade = 'A'; break; */ // 이렇게 안 써도 된다. 어차피 10을 찾았을 때 없으니 그냥 밑으로 내려와서 밑의 값 A찾고 break 한다.
		case 9:	 grade = 'A'; break;
		case 8:	 grade = 'B'; break; 
		case 7:	 grade = 'C'; break;
		case 6:	 grade = 'D'; break;
		default : grade = 'F';
		/* 아래처럼 말고 case 5부터는 어차피 나머지 이므로 dafault로 묶는 것이 편하다.
		case 5:		
		case 4:
		case 3:
		case 2:
		case 1:
		case 0; grade = 'F'; break;  // 제일 끝이니까 break안 써도 된다.
		 */
		
		System.out.printf("%s(%s)\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
		name, hakbun, kor, eng, mat, tot, avg, grade);
	
		}
	}
}
		



//if문으로 하려면 밑의 것처럼
		
//		if(avg>=90) grade = 'A';
//		else if(avg >= 80) grade = 'B';
//		else if(avg >= 70) grade = 'C';
//		else if(avg >= 60) grade = 'D';
//		else grade = 'F';
//		System.out.printf("%s(%s)\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
//				name, hakbun, kor, eng, mat, tot, avg, grade);
//		
	



