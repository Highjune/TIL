//1���� 6���� ���� �ٸ� �� ���� �� �̾Ƴ���(do while�̸� ���ϴ�, �ֳ��ϸ� ����! ���� �ϳ� �̰� �ٸ� �� ������ �Ǵϱ�)
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