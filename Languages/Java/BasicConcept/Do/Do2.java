//1부터 6까지 서로 다른 두 개의 수 뽑아내기(do while이면 편하다, 왜냐하면 먼저! 숫자 하나 뽑고 다른 것 뽑으면 되니까)
public class Do2 {
public static void main(String[] args) {
int rand, rand1;
	do {
		rand = (int)(Math.random() *6 +1);
		rand1 = (int)(Math.random() *6 +1);
	}while(rand == rand1);
	System.out.printf("%d, %d\n", rand, rand1);
}	
}