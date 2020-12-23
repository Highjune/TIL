/*
 * 정수 2개를 입력받아서 LCM(최소공배수), GCM(최대공약수) 구하기 // 최대공약수, 최소공배수
 * A = aG
 * B = bG
 * L = abG
 */


import java.util.Scanner;
public class LCMGCM {
	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	int a = scan.nextInt(); 
	int b = scan.nextInt();
	
	LCMGCM lg = new LCMGCM();
	int gcm = lg.calcGcm(a, b);
	int lcm = a / gcm * b / gcm * gcm;
	System.out.println("lcm = " + lcm + ", gcm = " + gcm);

	
	}
	int calcGcm(int a, int b){  //ex) 6, 8 넣는다고 생각
		int gcm = 0 ; //초기화
		for(int i = 2 ; i <=a ; i++) {
			if(a%i ==0 && b%i ==0) gcm = i;
		}
		return gcm;
	}
}








