/*
 * ���� 2���� �Է¹޾Ƽ� LCM(�ּҰ����), GCM(�ִ�����) ���ϱ� // �ִ�����, �ּҰ����
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
	int calcGcm(int a, int b){  //ex) 6, 8 �ִ´ٰ� ����
		int gcm = 0 ; //�ʱ�ȭ
		for(int i = 2 ; i <=a ; i++) {
			if(a%i ==0 && b%i ==0) gcm = i;
		}
		return gcm;
	}
}








